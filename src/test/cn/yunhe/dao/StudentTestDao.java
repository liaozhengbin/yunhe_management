package test.cn.yunhe.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cn.yunhe.dao.StudentDao;
import cn.yunhe.dao.impl.StudentDaoImpl;

public class StudentTestDao {
	private static StudentDao studentDao=new StudentDaoImpl();
	
	@Before
	public void test2(){
		System.out.println("正在加载配置文件");
	}
	
	
	
	
	
	@Test
	public void test1(){
		System.out.println("正在工作中1");
	}
	
	
	
	@Test
	public void test4(){
		System.out.println("正在工作中2");
	}
	
	
	
	@After
	public void test3(){
		System.out.println("释放资源");
	}
	

}
