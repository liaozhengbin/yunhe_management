package cn.yunhe.biz;

import java.util.List;

import cn.yunhe.entity.ClassInfo;

public interface ClassBiz {

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
	void updateClass(int class_id, String class_name);
	
	
	//�鿴����ѧ����ҳ��
	int selectClassPage(int num);

}
