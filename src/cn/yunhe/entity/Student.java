package cn.yunhe.entity;

public class Student {
	
	private int stu_id; //ID
	private String stu_no;//学号
	private String stu_name;//姓名
	private String stu_img;	//头像
	private String stu_sex;	//性别
	private String stu_profession;//专业
	private String stu_phone;	//电话
	private String stu_icno;	//身份证
	private String stu_birth;	//生日
	private String stu_qq;		//QQ
	private int class_id;		//班级ID
	private String class_name;	//班级名称
	private String stu_edu;		//学历
	private String stu_school;	//学校
	
	
	public Student(){}
	public Student(String stu_no, String stu_name, String stu_img,
			String stu_sex, String stu_profession, String stu_phone,
			String stu_icno, String stu_birth, String stu_qq, int class_id,
			String stu_edu, String stu_school) {
		super();
		this.stu_no = stu_no;
		this.stu_name = stu_name;
		this.stu_img = stu_img;
		this.stu_sex = stu_sex;
		this.stu_profession = stu_profession;
		this.stu_phone = stu_phone;
		this.stu_icno = stu_icno;
		this.stu_birth = stu_birth;
		this.stu_qq = stu_qq;
		this.class_id = class_id;
		this.stu_edu = stu_edu;
		this.stu_school = stu_school;
	}
	public Student(int stu_id, String stu_name, String stu_img,
			String stu_sex, String stu_profession, String stu_phone,
			String stu_icno, String stu_birth, String stu_qq,
			String stu_edu, String stu_school) {
		super();
		this.stu_id=stu_id;
		this.stu_name = stu_name;
		this.stu_img = stu_img;
		this.stu_sex = stu_sex;
		this.stu_profession = stu_profession;
		this.stu_phone = stu_phone;
		this.stu_icno = stu_icno;
		this.stu_birth = stu_birth;
		this.stu_qq = stu_qq;
		this.stu_edu = stu_edu;
		this.stu_school = stu_school;
	}
	
	
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_no() {
		return stu_no;
	}
	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_img() {
		return stu_img;
	}
	public void setStu_img(String stu_img) {
		this.stu_img = stu_img;
	}
	public String getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}
	public String getStu_profession() {
		return stu_profession;
	}
	public void setStu_profession(String stu_profession) {
		this.stu_profession = stu_profession;
	}
	public String getStu_phone() {
		return stu_phone;
	}
	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}
	public String getStu_icno() {
		return stu_icno;
	}
	public void setStu_icno(String stu_icno) {
		this.stu_icno = stu_icno;
	}
	public String getStu_birth() {
		return stu_birth;
	}
	public void setStu_birth(String stu_birth) {
		this.stu_birth = stu_birth;
	}
	public String getStu_qq() {
		return stu_qq;
	}
	public void setStu_qq(String stu_qq) {
		this.stu_qq = stu_qq;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getStu_edu() {
		return stu_edu;
	}
	public void setStu_edu(String stu_edu) {
		this.stu_edu = stu_edu;
	}
	public String getStu_school() {
		return stu_school;
	}
	public void setStu_school(String stu_school) {
		this.stu_school = stu_school;
	}
	
	
	
}
