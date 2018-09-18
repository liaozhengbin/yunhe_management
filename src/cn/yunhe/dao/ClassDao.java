package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.ClassInfo;


public interface ClassDao {
	// ��ѯ�༶��Ϣ
	List<ClassInfo> seleteClass(int page, int line);
	
	// ��ѯ�༶��Ϣ
	List<ClassInfo> seleteClass2();
	

	// �鿴���а༶��Ϣ����
	int selectClassRecord();

	// ����classID��ѯ��Ϣ
	ClassInfo selectClassOne(int classId);

	// ��ӷ���
	boolean addClass(String cls);

	/**
	 * ָ���༶IDɾ���༶
	 * 
	 * @param classId
	 */
	void deleteClass(int classId);

	/**
	 * �޸İ༶��Ϣ
	 * 
	 * @param stu
	 */
	void updateClass(ClassInfo cla);

}
