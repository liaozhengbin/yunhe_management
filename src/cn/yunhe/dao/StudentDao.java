package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.ScoreInfo;
import cn.yunhe.entity.Student;

public interface StudentDao {
	//��ѯ����ѧ����Ϣ
	List<Student> seleteStudentMessage(String filterName,String filterProfessional,String filterSex,String class_id, int page,int line);
	
	
	
	//��ѯѧ����Ϣ�ܼ�¼��
	int seleteStudentRecord(String filterName,String filterProfessional,String filterSex,String class_id);
	
	//���ѧ��
	void addStudent(Student student);
	
	
	/**
	 * ָ��ѧ��IDɾ��ѧ��
	 * @param scoreId
	 */
	void deleteStudent(int stuId);
	
	
	//����scoreID��ѯ��Ϣ
	Student selectStudentOne(int stuId);
	
	
	/**
	 * �޸�ѧԱ��Ϣ
	 * @param stu
	 */
	void updateStudent(Student stu);
	
	
	
}
