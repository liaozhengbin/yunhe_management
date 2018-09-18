package cn.yunhe.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.yunhe.dao.StudentDao;
import cn.yunhe.entity.Student;
import cn.yunhe.util.ORMUtil;
import cn.yunhe.util.UtilityClass42;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> seleteStudentMessage(String filterName,String filterProfessional,String filterSex,String class_id, int page,int line) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("SELECT t1.*,t2.class_name FROM tb_student t1,tb_class t2 where t1.class_id=t2.class_id ");
		
		List<Object> stuList=new ArrayList<Object>();
		if(filterName!=null && !filterName.equals("")){
			sql.append(" and stu_name like ? ");
			stuList.add("%"+filterName+"%");
		}
		
		if(filterProfessional!=null && !filterProfessional.equals("")){
			sql.append(" and stu_profession like ? ");
			stuList.add("%"+filterProfessional+"%");
		}
		
		if(filterSex!=null && !filterSex.equals("")){
			sql.append("and stu_sex=? ");
			stuList.add(filterSex);
		}
		if(Integer.parseInt(class_id)!=-1){
			sql.append("and t1.class_id=? ");
			stuList.add(Integer.parseInt(class_id));
		}
		
		//·ÖÒ³
		sql.append("ORDER BY stu_id LIMIT ?,?");
		stuList.add((page-1)*line);
		stuList.add(line);
		
		
		List<Student> StudentList=ORMUtil.ormutil().selectList(sql.toString(), stuList.toArray(), Student.class);
		return StudentList;
	}

	@Override
	public int seleteStudentRecord(String filterName,String filterProfessional,String filterSex,String class_id) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("SELECT count(*) num FROM tb_student t1,tb_class t2 where t1.class_id=t2.class_id ");
		List<Object> stuList=new ArrayList<Object>();
		if(filterName!=null && !filterName.equals("")){
			sql.append(" and stu_name like ? ");
			stuList.add("%"+filterName+"%");
		}
		
		if(filterProfessional!=null && !filterProfessional.equals("")){
			sql.append(" and stu_profession like ? ");
			stuList.add("%"+filterProfessional+"%");
		}
		
		if(filterSex!=null && !filterSex.equals("")){
			sql.append("and stu_sex=? ");
			stuList.add(filterSex);
		}
		
		if(Integer.parseInt(class_id)!=-1){
			sql.append("and t1.class_id=? ");
			stuList.add(Integer.parseInt(class_id));
		}
		
		List<Map<String, Object>> list=UtilityClass42.utitli().performDQL(sql.toString(), stuList.toArray());
		Long num=(Long) list.get(0).get("num");
		return num.intValue();
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		if(student.getStu_img()!=null){
			String sql="INSERT INTO tb_student (stu_no,stu_name,stu_profession,stu_sex,stu_img,stu_phone,stu_icno,stu_birth,stu_qq,class_id,stu_edu,stu_school) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			Object[] studentArray={student.getStu_no(),student.getStu_name(),student.getStu_profession(),student.getStu_sex(),student.getStu_img(),student.getStu_phone(),student.getStu_icno(),student.getStu_birth(),student.getStu_qq(),student.getClass_id(),student.getStu_edu(),student.getStu_school()};
			ORMUtil.ormutil().performDML(sql, studentArray);
			
		}else{
			String sql="INSERT INTO tb_student (stu_no,stu_name,stu_profession,stu_sex,stu_phone,stu_icno,stu_birth,stu_qq,class_id,stu_edu,stu_school) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			Object[] studentArray={student.getStu_no(),student.getStu_name(),student.getStu_profession(),student.getStu_sex(),student.getStu_phone(),student.getStu_icno(),student.getStu_birth(),student.getStu_qq(),student.getClass_id(),student.getStu_edu(),student.getStu_school()};
			ORMUtil.ormutil().performDML(sql, studentArray);
		}
		
		
		
	
	
	}

	@Override
	public void deleteStudent(int stuId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM tb_student WHERE stu_id=?";
		Object[] studentArray={stuId};
		ORMUtil.ormutil().performDML(sql, studentArray);
		
	}

	@Override
	public Student selectStudentOne(int stuId) {
		// TODO Auto-generated method stub
		String sql="select * from tb_student where stu_id=?";
		Object[] StudentArray={stuId};
		List<Student> studentList=ORMUtil.ormutil().selectList(sql, StudentArray, Student.class);
		return studentList.size()>0?studentList.get(0):null;
	}

	@Override
	public void updateStudent(Student stu) {
		// TODO Auto-generated method stub
		if(stu.getStu_img()!=null){
			String sql="UPDATE tb_student SET stu_no=?,stu_name=?,stu_profession=?,stu_sex=?,stu_img=?,stu_phone=?,stu_icno=?,stu_birth=?,stu_qq=?,class_id=?,stu_edu=?,stu_school=? WHERE stu_id=?";
			Object[] params={stu.getStu_no(),stu.getStu_name(),stu.getStu_profession(),stu.getStu_sex(),stu.getStu_img(),stu.getStu_phone(),stu.getStu_icno(),stu.getStu_birth(),stu.getStu_qq(),stu.getClass_id(),stu.getStu_edu(),stu.getStu_school(),stu.getStu_id()};
			ORMUtil.ormutil().performDML(sql, params);
		}else{
			stu.setStu_img("-1.jpg");
			String sql="UPDATE tb_student SET stu_no=?,stu_name=?,stu_profession=?,stu_sex=?,stu_img=?,stu_phone=?,stu_icno=?,stu_birth=?,stu_qq=?,class_id=?,stu_edu=?,stu_school=? WHERE stu_id=?";
			Object[] params={stu.getStu_no(),stu.getStu_name(),stu.getStu_profession(),stu.getStu_sex(),stu.getStu_img(),stu.getStu_phone(),stu.getStu_icno(),stu.getStu_birth(),stu.getStu_qq(),stu.getClass_id(),stu.getStu_edu(),stu.getStu_school(),stu.getStu_id()};
			ORMUtil.ormutil().performDML(sql, params);
			
		}
		
		
		
	}

	

	

}
