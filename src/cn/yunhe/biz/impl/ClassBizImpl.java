package cn.yunhe.biz.impl;

import java.util.List;

import cn.yunhe.biz.ClassBiz;
import cn.yunhe.dao.ClassDao;
import cn.yunhe.dao.impl.ClassDaoImpl;
import cn.yunhe.entity.ClassInfo;

public class ClassBizImpl implements ClassBiz {
	private ClassDao classDao=new ClassDaoImpl();
	@Override
	public List<ClassInfo> seleteClass(int page, int line) {
		// TODO Auto-generated method stub
		return classDao.seleteClass(page, line);
	}
	@Override
	public int selectClassRecord() {
		// TODO Auto-generated method stub
		return classDao.selectClassRecord();
	}
	@Override
	public ClassInfo selectClassOne(int classId) {
		// TODO Auto-generated method stub
		return classDao.selectClassOne(classId);
	}
	@Override
	public boolean addClass(String cls) {
		// TODO Auto-generated method stub
		return classDao.addClass(cls);
	}
	@Override
	public void deleteClass(int classId) {
		// TODO Auto-generated method stub
		classDao.deleteClass(classId);
	}
	@Override
	public void updateClass(int class_id,String class_name) {
		// TODO Auto-generated method stub
		ClassInfo classInfo=new ClassInfo();
		classInfo.setClass_id(class_id);
		classInfo.setClass_name(class_name);
		classDao.updateClass(classInfo);
	}
	@Override
	public int selectClassPage(int num) {
		// TODO Auto-generated method stub
		int zonghans=classDao.selectClassRecord();
		return zonghans%num==0?zonghans/num:zonghans/num+1;
	}
	@Override
	public List<ClassInfo> seleteClass2() {
		// TODO Auto-generated method stub
		return classDao.seleteClass2();
	}

}
