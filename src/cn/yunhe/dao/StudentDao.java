package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.ScoreInfo;
import cn.yunhe.entity.Student;

public interface StudentDao {
	//查询所有学生信息
	List<Student> seleteStudentMessage(String filterName,String filterProfessional,String filterSex,String class_id, int page,int line);
	
	
	
	//查询学生信息总记录数
	int seleteStudentRecord(String filterName,String filterProfessional,String filterSex,String class_id);
	
	//添加学生
	void addStudent(Student student);
	
	
	/**
	 * 指定学生ID删除学生
	 * @param scoreId
	 */
	void deleteStudent(int stuId);
	
	
	//根据scoreID查询信息
	Student selectStudentOne(int stuId);
	
	
	/**
	 * 修改学员信息
	 * @param stu
	 */
	void updateStudent(Student stu);
	
	
	
}
