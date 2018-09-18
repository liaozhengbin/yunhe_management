package cn.yunhe.dao.impl;


import java.util.List;
import java.util.Map;

import cn.yunhe.dao.ClassDao;
import cn.yunhe.entity.ClassInfo;
import cn.yunhe.util.ORMUtil;
import cn.yunhe.util.UtilityClass42;

public class ClassDaoImpl implements ClassDao {

	@Override
	public List<ClassInfo> seleteClass(int page, int line) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tb_class ORDER BY class_id LIMIT ?,?";
		Object[] classArray={(page-1)*line,line};
		List<ClassInfo> classList=ORMUtil.ormutil().selectList(sql, classArray, ClassInfo.class);
		return classList;
	}

	@Override
	public int selectClassRecord() {
		// TODO Auto-generated method stub
		String sql="SELECT COUNT(*) num FROM tb_class ";
		List<Map<String, Object>> classList=UtilityClass42.utitli().performDQL(sql, null);
		Long num=(Long) classList.get(0).get("num");
		return num.intValue();
	}

	@Override
	public ClassInfo selectClassOne(int classId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tb_class where class_id=?";
		Object[] classArray={classId};
		List<ClassInfo> classList=ORMUtil.ormutil().selectList(sql, classArray, ClassInfo.class);
		return classList.size()>0?classList.get(0):null;
	}

	@Override
	public boolean addClass(String cls) {
		// TODO Auto-generated method stub
		boolean fag=false;
		String sql="INSERT INTO tb_class (class_name) VALUES (?)";
		Object[] classArray={cls};
		int result=ORMUtil.ormutil().performDML(sql, classArray);
		if(result==-1){
			fag=true;
		}
		return fag;
	}

	@Override
	public void deleteClass(int classId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM tb_class WHERE class_id=?";
		Object[] classArray={classId};
		ORMUtil.ormutil().performDML(sql, classArray);
		
	}

	@Override
	public void updateClass(ClassInfo cla) {
		// TODO Auto-generated method stub
		String sql="UPDATE tb_class SET class_name=? WHERE class_id=?";
		Object[] params={cla.getClass_name(),cla.getClass_id()};
		ORMUtil.ormutil().performDML(sql, params);
		
	}

	@Override
	public List<ClassInfo> seleteClass2() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tb_class ORDER BY class_id ";
		List<ClassInfo> classList=ORMUtil.ormutil().selectList(sql, null, ClassInfo.class);
		return classList;
	}

}
