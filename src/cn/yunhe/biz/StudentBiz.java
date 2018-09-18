package cn.yunhe.biz;

import java.util.List;

import cn.yunhe.entity.ScoreInfo;
import cn.yunhe.entity.Student;

public interface StudentBiz {
	
	
	//��ѯ����ѧ����Ϣ
	List<Student> seleteStudentMessage(String filterName,String filterProfessional,String filterSex,String class_id, int page,int line);
	
	//��ѯѧ����Ϣ�ܼ�¼��
	int seleteStudentRecord(String filterName,String filterProfessional,String filterSex,String class_id);
	
	//��ѯѧ����Ϣ��ҳ��
	int calculateStudentPage(String filterName,String filterProfessional,String filterSex,String class_id,int num);
	
	//���ѧ��
	void addStudent(String stu_no,String stu_name,String stu_profession,String stu_sex,String stu_img,String stu_phone,String stu_icno,String stu_birth,String stu_qq,int class_id,String stu_edu,String stu_school);
	
	
	//ɾ��ѧ��
	void deleteStudent(int stuId);
	
	//����studentID��ѯ��Ϣ
	Student selectStudentOne(int stuId);
	
	//�޸�student��Ϣ
	void updateStudent(int stu_id,String stu_no,String stu_name,String stu_profession,String stu_sex,String stu_img,String stu_phone,String stu_icno,String stu_birth,String stu_qq,int class_id,String stu_edu,String stu_school);
	
}
