package cn.yunhe.biz;

import java.util.List;

import cn.yunhe.entity.ScoreInfo;
import cn.yunhe.entity.Student;

public interface StudentBiz {
	
	
	//查询所有学生信息
	List<Student> seleteStudentMessage(String filterName,String filterProfessional,String filterSex,String class_id, int page,int line);
	
	//查询学生信息总记录数
	int seleteStudentRecord(String filterName,String filterProfessional,String filterSex,String class_id);
	
	//查询学生信息总页数
	int calculateStudentPage(String filterName,String filterProfessional,String filterSex,String class_id,int num);
	
	//添加学生
	void addStudent(String stu_no,String stu_name,String stu_profession,String stu_sex,String stu_img,String stu_phone,String stu_icno,String stu_birth,String stu_qq,int class_id,String stu_edu,String stu_school);
	
	
	//删除学生
	void deleteStudent(int stuId);
	
	//根据studentID查询信息
	Student selectStudentOne(int stuId);
	
	//修改student信息
	void updateStudent(int stu_id,String stu_no,String stu_name,String stu_profession,String stu_sex,String stu_img,String stu_phone,String stu_icno,String stu_birth,String stu_qq,int class_id,String stu_edu,String stu_school);
	
}
