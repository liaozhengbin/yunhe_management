package cn.yunhe.biz;

import java.util.List;

import cn.yunhe.entity.ClassInfo;

public interface ClassBiz {

	// 查询班级信息
	List<ClassInfo> seleteClass(int page, int line);
	
	// 查询班级信息
	List<ClassInfo> seleteClass2();

	// 查看所有班级信息总数
	int selectClassRecord();

	// 根据classID查询信息
	ClassInfo selectClassOne(int classId);

	// 添加分数
	boolean addClass(String cls);

	/**
	 * 指定班级ID删除班级
	 * 
	 * @param classId
	 */
	void deleteClass(int classId);

	/**
	 * 修改班级信息
	 * 
	 * @param stu
	 */
	void updateClass(int class_id, String class_name);
	
	
	//查看所有学生总页数
	int selectClassPage(int num);

}
