package cn.yunhe.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ORMUtil {
	
	private ORMUtil(){}
	private static ORMUtil ormutil=null;
	public static ORMUtil ormutil(){
		if(ormutil==null){
			ormutil=new ORMUtil();
		}
		return ormutil;
	}

	public int performDML(String name, Object[] stuArray) {
		return UtilityClass42.utitli().performDML(name, stuArray);
	}
	
	public int performDML_index(String name, Object[] stuArray) {
		return UtilityClass42.utitli().performDML_index(name, stuArray);
	}

	public <T> List<T> selectList(String sql,Object[] paramList,Class<T> clazz){
		//���Ҫ���ص�list
		List<T> list=new ArrayList<T>();
		//�����ݿ�ȡ������mapList
		List<Map<String, Object>> listMap=UtilityClass42.utitli().performDQL(sql, paramList);
		
		try {
			for (Map<String, Object> map : listMap) {
				Set<String> allKeys=map.keySet();
				
				//��ȡclazz�������ֶ�
				Field[] fieldArray=clazz.getDeclaredFields();
				T obj=clazz.newInstance();
				
				
				for (String key : allKeys) {
					
					for (Field field : fieldArray) {
						if (field.getName().toLowerCase().equals(key.toLowerCase())) {
							field.setAccessible(true);
							
							try {
								field.set(obj, map.get(key));
							} catch (Exception e) {
								//������IllegalArgumentException�쳣�Ż����
								//���ݿ��������ֶε�����   ��  javaʵ���������Ե�����   ��ƥ��
								//map.get(key)          field
								
								Object value=map.get(key);
								
								if (value!=null) {
									if (value.getClass() == java.sql.Date.class) {//���ݿ��Ǳ���datetime
										if (field.getType().getName()
												.equals("java.lang.String")) {//java�����String
											Date dateValue = (Date) value;

											SimpleDateFormat sdf = new SimpleDateFormat(
													"yyyy-MM-dd");
											String strValue = sdf
													.format(dateValue);

											field.set(obj, strValue);

										}
									}
									if (field.getType() == char.class) {//java�����char
										if (value.getClass() == String.class) {//���ݿ��Ǳ���String
											String str = (String) value;
											field.set(obj, str.charAt(0));
										}
									}
									if (field.getType() == double.class) {//java�����double
										if (value.getClass() == BigDecimal.class) {//���ݿ��Ǳ���BigDecimal
											BigDecimal str = (BigDecimal) value;
											field.set(obj, str.doubleValue());
										}
									}
								}
								
								
//								if (value.getClass()==BigDecimal.class) {//���ݿ���number����
//									if (field.getType()==int.class) {//java�����int
//										
//									}
//									if (field.getType()==double.class) {//java�����double
//										
//									}
//								}
								
							}
							
							
						}	
					}
				}
				list.add(obj);
			}
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	

}
