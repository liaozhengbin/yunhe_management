package cn.yunhe.biz.impl;

import java.util.List;

import cn.yunhe.biz.StudentBiz;
import cn.yunhe.dao.StudentDao;
import cn.yunhe.dao.impl.StudentDaoImpl;
import cn.yunhe.entity.Student;

public class StudentBizImpl implements StudentBiz {
	private StudentDao studentDao=new StudentDaoImpl();
	@Override
	public List<Student> seleteStudentMessage(String filterName,String filterProfessional,String filterSex,String class_id, int page,int line) {
		// TODO Auto-generated method stub
		return studentDao.seleteStudentMessage(filterName, filterProfessional, filterSex,class_id, page, line);
	}
	@Override
	public int seleteStudentRecord(String filterName,String filterProfessional,String filterSex,String class_id) {
		// TODO Auto-generated method stub
		return studentDao.seleteStudentRecord(filterName, filterProfessional, filterSex,class_id);
	}
	
	@Override
	public int calculateStudentPage(String filterName,String filterProfessional,String filterSex,String class_id,int line) {
		// TODO Auto-generated method stub
		//×Ü¼ÇÂ¼Êý
		int conn=studentDao.seleteStudentRecord(filterName, filterProfessional, filterSex,class_id);
		return conn%line==0?conn/line:conn/line+1;
	}
	@Override
	public void addStudent(String stu_no, String stu_name,
			String stu_profession, String stu_sex, String stu_img,
			String stu_phone, String stu_icno, String stu_birth, String stu_qq,
			int class_id, String stu_edu, String stu_school) {
		// TODO Auto-generated method stub
		Student student=new Student();
		student.setStu_no(stu_no);
		student.setStu_name(stu_name);
		student.setStu_profession(stu_profession);
		student.setStu_sex(stu_sex);
		student.setStu_img(stu_img);
		student.setStu_phone(stu_phone);
		student.setStu_icno(stu_icno);
		student.setStu_birth(stu_birth);
		student.setStu_qq(stu_qq);
		student.setClass_id(class_id);
		student.setStu_edu(stu_edu);
		student.setStu_school(stu_school);
		studentDao.addStudent(student);
	}
	@Override
	public void deleteStudent(int stuId) {
		// TODO Auto-generated method stub
		studentDao.deleteStudent(stuId);
	}
	@Override
	public Student selectStudentOne(int stuId) {
		// TODO Auto-generated method stub
		return studentDao.selectStudentOne(stuId);
	}
	@Override
	public void updateStudent(int stu_id, String stu_no, String stu_name,
			String stu_profession, String stu_sex, String stu_img,
			String stu_phone, String stu_icno, String stu_birth, String stu_qq,
			int class_id, String stu_edu, String stu_school) {
		// TODO Auto-generated method stub
		Student student=new Student();
		student.setStu_id(stu_id);
		student.setStu_no(stu_no);
		student.setStu_name(stu_name);
		student.setStu_profession(stu_profession);
		student.setStu_sex(stu_sex);
		student.setStu_img(stu_img);
		student.setStu_phone(stu_phone);
		student.setStu_icno(stu_icno);
		student.setStu_birth(stu_birth);
		student.setStu_qq(stu_qq);
		student.setClass_id(class_id);
		student.setStu_edu(stu_edu);
		student.setStu_school(stu_school);
		studentDao.updateStudent(student);
	}
	
	

}
