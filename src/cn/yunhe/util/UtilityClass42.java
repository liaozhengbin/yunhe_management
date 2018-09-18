package cn.yunhe.util;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

public class UtilityClass42 {

	private Connection nonn = null;
	private PreparedStatement preStmt = null;
	private ResultSet rs = null;
	private static Logger logger=Logger.getLogger(UtilityClass42.class);
	private UtilityClass42() {
	}

	private static UtilityClass42 utitli = null;

	public static UtilityClass42 utitli() {
		if (utitli == null) {
			utitli = new UtilityClass42();
		}
		return utitli;
	}

	private static String qudong;
	private static String dizhi;
	private static String zhanghao;
	private static String mima;

	static {
		try {
			Properties pro = new Properties();
			pro.load(UtilityClass42.class.getResourceAsStream("/cn/yunhe/db.properties"));
			qudong = pro.getProperty("db.qudong").trim();
			dizhi = pro.getProperty("db.dizhi").trim();
			zhanghao = pro.getProperty("db.zhanghao").trim();
			mima = pro.getProperty("db.mima").trim();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 1>加载驱动（数据库产商提供的驱动）
		// 下面这行代码会去寻找“com.mysql.jdbc.Driver”这个类是否存在，如果存在则创建它的对象
		// 如果“com.mysql.jdbc.Driver”这个类不存在，则会抛出ClassNotFoundException
		try {
			Class.forName(qudong);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void main(String[] args) {
		try {
			start();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 打开连接
	 * 
	 * @throws SQLException
	 */
	private void start() throws SQLException {
		
		// 2>创建jdbc连接
		// java.sql.SQLException: Access denied for user 'root'@'localhost'
		// (using password: YES)
		// The last packet sent successfully to the server was 0 milliseconds
		// ago. The driver has not received any packets from the server.

		nonn = DriverManager.getConnection(dizhi, zhanghao, mima);

	}

	/**
	 * 执行DML
	 * 
	 * @throws SQLException
	 *             PreparedStatement preStmt=null;
	 */
	public int performDML(String name, Object[] stuArray) {
		logger.debug("SQL>>>>>>>>>>>>>>>");
		logger.debug(name);
		logger.debug("参数列表");
		if (stuArray!=null) {
			for (Object obj : stuArray) {
				logger.debug(obj);
			}
		}
		// 3>创建Statement对象
		// 4>执行DML语句
		int result = 0;
		try {
			start();
			preStmt = nonn.prepareStatement(name);

			if (stuArray != null) {
				// 3.1>填充参数(参数个数？，参数类型？)
				for (int i = 0; i < stuArray.length; i++) {
					preStmt.setObject(i + 1, stuArray[i]);
				}
			}
			result = preStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			release();
		}
		return result;
	}
	
	
	/**
	 * 执行DML
	 * 
	 * @throws SQLException
	 *             PreparedStatement preStmt=null;
	 */
	public int performDML_index(String name, Object[] stuArray) {
		logger.debug("SQL>>>>>>>>>>>>>>>");
		logger.debug(name);
		logger.debug("参数列表");
		if (stuArray!=null) {
			for (Object obj : stuArray) {
				logger.debug(obj);
			}
		}
		// 3>创建Statement对象
		// 4>执行DML语句
		int result = 0;
		try {
			start();
			preStmt = nonn.prepareStatement(name);

			if (stuArray != null) {
				// 3.1>填充参数(参数个数？，参数类型？)
				for (int i = 0; i < stuArray.length; i++) {
					preStmt.setObject(i + 1, stuArray[i]);
				}
			}
			preStmt.executeUpdate();
			
			//查询自增id
			//SELECT LAST_INSERT_ID();
			rs=preStmt.executeQuery("SELECT LAST_INSERT_ID()");
			rs.next();
			result=rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			release();
		}
		return result;
	}

	/**
	 * 执行多条DML
	 * 
	 * @throws SQLException
	 *             PreparedStatement preStmt=null;
	 */
	public int morePerformDML(String[] name, Object[][] stuArray) {
		logger.debug("SQL>>>>>>>>>>>>>>>");
		logger.debug(name);
		logger.debug("参数列表");
		if (stuArray!=null) {
			for (Object obj : stuArray) {
				logger.debug(obj);
			}
		}
		// 3>创建Statement对象
		// 4>执行DML语句
		int result = 0;
		try {
			start();
			nonn.setAutoCommit(false);

			for (int i = 0; i < name.length; i++) {
				preStmt = nonn.prepareStatement(name[i]);
				if (stuArray != null) {
					if (stuArray[i] != null) {
						// 3.1>填充参数(参数个数？，参数类型？)
						for (int j = 0; j < stuArray.length; j++) {
							preStmt.setObject(j + 1, stuArray[j]);
						}
					}
					
				}
				
				result = preStmt.executeUpdate();
			}
			
			nonn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				nonn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		} finally {
			release();
		}
		return result;
	}

	/**
	 * 执行DQL
	 * 
	 * @throws SQLException
	 */
	public synchronized List<Map<String, Object>> performDQL(String name, Object[] stuArray) {
		logger.debug("SQL>>>>>>>>>>>>>>>");
		logger.debug(name);
		logger.debug("参数列表");
		if (stuArray!=null) {
			for (Object obj : stuArray) {
				logger.debug(obj);
			}
		}
		// 3>创建Statement对象
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			start();
			preStmt = nonn.prepareStatement(name);
			if (stuArray != null) {
				// 4>执行DML语句
				for (int i = 0; i < stuArray.length; i++) {
					preStmt.setObject(i + 1, stuArray[i]);
				}
			}
			// 4>执行DML语句
			rs = preStmt.executeQuery();
			while (rs.next()) {// 每次循环读取“一行记录”
				Map<String, Object> mapObj = new HashMap<String, Object>();

				/*
				 * 解析结果集，赋值给mapObj
				 */
				// 获取结果集中的结构信息（包括字段名、字段总数量）
				ResultSetMetaData metaData = rs.getMetaData();
				// 获取“字段总数量”
				int columnCount = metaData.getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					
					
					
					
					//metaData.getColumnName(column)   永远优先找“表中的字段名”
					//metaData.getColumnLabel(column)  如果有别名，则找别名
					
					mapObj.put(metaData.getColumnLabel(i).toLowerCase(),
							rs.getObject(i));
					// mapObj.put("字段名", rs.getObject("字段名/下标"));

				}

				list.add(mapObj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			release();
		}
		return list;// 返回是list对象的引用地址
	}

	/**
	 * 释放资源
	 */
	private void release() {
		try {
			if (nonn != null) {
				nonn.close();
			}
			if (preStmt != null) {
				preStmt.close();
			}
			if (rs != null) {
				rs.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
