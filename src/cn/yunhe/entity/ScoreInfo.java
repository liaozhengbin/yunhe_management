package cn.yunhe.entity;

public class ScoreInfo {
	private int score_id;//����ID
	private double score_value;//����ֵ
	private int score_type;//��������
	private String type_value;	//������������
	private String time;	//ʱ��
	private String score_contents;	//��ֵ����
	private String stu_name;	//ѧ������
	private int stu_id;	//ѧ������
	
	
	public ScoreInfo(){}
	public ScoreInfo(int score_id,double score_value, int score_type, String time,
			String score_contents, String stu_name,int stu_id) {
		super();
		this.score_id=score_id;
		this.score_value = score_value;
		this.score_type = score_type;
		this.time = time;
		this.score_contents = score_contents;
		this.stu_name = stu_name;
		this.stu_id=stu_id;
	}
	
	public int getScore_id() {
		return score_id;
	}
	public void setScore_id(int score_id) {
		this.score_id = score_id;
	}
	public double getScore_value() {
		return score_value;
	}
	public void setScore_value(double score_value) {
		this.score_value = score_value;
	}
	public int getScore_type() {
		return score_type;
	}
	public void setScore_type(int score_type) {
		this.score_type = score_type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getScore_contents() {
		return score_contents;
	}
	public void setScore_contents(String score_contents) {
		this.score_contents = score_contents;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	
	
	public String getType_value() {
		return type_value;
	}
	public void setType_value(String type_value) {
		this.type_value = type_value;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	@Override
	public String toString() {
		return "ScoreInfo [score_id=" + score_id + ", score_value="
				+ score_value + ", score_type=" + score_type + ", type_value="
				+ type_value + ", time=" + time + ", score_contents="
				+ score_contents + ", stu_name=" + stu_name + ", stu_id="
				+ stu_id + "]";
	}
	
	
	
	
	
	
	
}
