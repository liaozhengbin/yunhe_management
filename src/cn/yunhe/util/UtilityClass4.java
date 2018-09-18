package cn.yunhe.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;



public class UtilityClass4 {
	
	private static DataSource dataSource=null;
	private Connection nonn = null;
	private PreparedStatement preStmt = null;
	private ResultSet rs = null;
	
	private UtilityClass4() {
	}

	private static UtilityClass4 utitli = null;

	public static UtilityClass4 utitli() {
		if (utitli == null) {
			utitli = new UtilityClass4();
		}
		return utitli;
	}


	static {
		try {
			//创建一个属性文件对象，并加载
			Properties pro=new Properties();
			pro.load(UtilityClass4.class.getResourceAsStream("/cn/yunhe/db.properties"));
			//使用apache下的dbcp连接池创建数据源
			dataSource=BasicDataSourceFactory.createDataSource(pro);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	/**
	 * 打开连接
	 * 
	 * @throws SQLException
	 */
	public void start() throws SQLException {
			
		//>创建jdbc连接（使用连接池）
		nonn=dataSource.getConnection();

	}

	/**
	 * 执行DML
	 * 
	 * @throws SQLException
	 *             PreparedStatement preStmt=null;
	 */
	public int performDML(String name, Object[] stuArray) {
		
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
	public void release() {
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
