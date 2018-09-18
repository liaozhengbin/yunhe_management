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
		//最后要返回的list
		List<T> list=new ArrayList<T>();
		//从数据库取出来的mapList
		List<Map<String, Object>> listMap=UtilityClass42.utitli().performDQL(sql, paramList);
		
		try {
			for (Map<String, Object> map : listMap) {
				Set<String> allKeys=map.keySet();
				
				//获取clazz的所有字段
				Field[] fieldArray=clazz.getDeclaredFields();
				T obj=clazz.newInstance();
				
				
				for (String key : allKeys) {
					
					for (Field field : fieldArray) {
						if (field.getName().toLowerCase().equals(key.toLowerCase())) {
							field.setAccessible(true);
							
							try {
								field.set(obj, map.get(key));
							} catch (Exception e) {
								//捕获到了IllegalArgumentException异常才会进入
								//数据库结果集中字段的类型   与  java实体类中属性的类型   不匹配
								//map.get(key)          field
								
								Object value=map.get(key);
								
								if (value!=null) {
									if (value.getClass() == java.sql.Date.class) {//数据库那边是datetime
										if (field.getType().getName()
												.equals("java.lang.String")) {//java这边是String
											Date dateValue = (Date) value;

											SimpleDateFormat sdf = new SimpleDateFormat(
													"yyyy-MM-dd");
											String strValue = sdf
													.format(dateValue);

											field.set(obj, strValue);

										}
									}
									if (field.getType() == char.class) {//java这边是char
										if (value.getClass() == String.class) {//数据库那边是String
											String str = (String) value;
											field.set(obj, str.charAt(0));
										}
									}
									if (field.getType() == double.class) {//java这边是double
										if (value.getClass() == BigDecimal.class) {//数据库那边是BigDecimal
											BigDecimal str = (BigDecimal) value;
											field.set(obj, str.doubleValue());
										}
									}
								}
								
								
//								if (value.getClass()==BigDecimal.class) {//数据库是number类型
//									if (field.getType()==int.class) {//java这边是int
//										
//									}
//									if (field.getType()==double.class) {//java这边是double
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
