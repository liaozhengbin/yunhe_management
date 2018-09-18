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
			//����һ�������ļ����󣬲�����
			Properties pro=new Properties();
			pro.load(UtilityClass4.class.getResourceAsStream("/cn/yunhe/db.properties"));
			//ʹ��apache�µ�dbcp���ӳش�������Դ
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
	 * ������
	 * 
	 * @throws SQLException
	 */
	public void start() throws SQLException {
			
		//>����jdbc���ӣ�ʹ�����ӳأ�
		nonn=dataSource.getConnection();

	}

	/**
	 * ִ��DML
	 * 
	 * @throws SQLException
	 *             PreparedStatement preStmt=null;
	 */
	public int performDML(String name, Object[] stuArray) {
		
		// 3>����Statement����
		// 4>ִ��DML���
		int result = 0;
		try {
			start();
			preStmt = nonn.prepareStatement(name);

			if (stuArray != null) {
				// 3.1>������(�������������������ͣ�)
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
	 * ִ��DML
	 * 
	 * @throws SQLException
	 *             PreparedStatement preStmt=null;
	 */
	public int performDML_index(String name, Object[] stuArray) {
		
		// 3>����Statement����
		// 4>ִ��DML���
		int result = 0;
		try {
			start();
			preStmt = nonn.prepareStatement(name);

			if (stuArray != null) {
				// 3.1>������(�������������������ͣ�)
				for (int i = 0; i < stuArray.length; i++) {
					preStmt.setObject(i + 1, stuArray[i]);
				}
			}
			preStmt.executeUpdate();
			
			//��ѯ����id
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
	 * ִ�ж���DML
	 * 
	 * @throws SQLException
	 *             PreparedStatement preStmt=null;
	 */
	public int morePerformDML(String[] name, Object[][] stuArray) {
		
		// 3>����Statement����
		// 4>ִ��DML���
		int result = 0;
		try {
			start();
			nonn.setAutoCommit(false);

			for (int i = 0; i < name.length; i++) {
				preStmt = nonn.prepareStatement(name[i]);
				if (stuArray != null) {
					if (stuArray[i] != null) {
						// 3.1>������(�������������������ͣ�)
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
	 * ִ��DQL
	 * 
	 * @throws SQLException
	 */
	public synchronized List<Map<String, Object>> performDQL(String name, Object[] stuArray) {
		
		// 3>����Statement����
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			start();
			preStmt = nonn.prepareStatement(name);
			if (stuArray != null) {
				// 4>ִ��DML���
				for (int i = 0; i < stuArray.length; i++) {
					preStmt.setObject(i + 1, stuArray[i]);
				}
			}
			// 4>ִ��DML���
			rs = preStmt.executeQuery();
			while (rs.next()) {// ÿ��ѭ����ȡ��һ�м�¼��
				Map<String, Object> mapObj = new HashMap<String, Object>();
				/*
				 * �������������ֵ��mapObj
				 */
				// ��ȡ������еĽṹ��Ϣ�������ֶ������ֶ���������
				ResultSetMetaData metaData = rs.getMetaData();
				// ��ȡ���ֶ���������
				int columnCount = metaData.getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					//metaData.getColumnName(column)   ��Զ�����ҡ����е��ֶ�����
					//metaData.getColumnLabel(column)  ����б��������ұ���
					
					mapObj.put(metaData.getColumnLabel(i).toLowerCase(),
							rs.getObject(i));
					// mapObj.put("�ֶ���", rs.getObject("�ֶ���/�±�"));

				}

				list.add(mapObj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			release();
		}
		return list;// ������list��������õ�ַ
	}

	/**
	 * �ͷ���Դ
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
