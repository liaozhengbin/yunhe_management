package cn.yunhe.entity;

public class RecordInfo {
	private int record_id;//ʱ���¼ID
	private int stu_id;//ѧ��
	private String stu_name;//ѧ������
	private String date;//����
	private String start_time;//�ϰ��ʱ��
	private String end_time;//�°��ʱ��
	private int status;//��״̬
	public RecordInfo(){}
	public RecordInfo(int record_id,int stu_id, String stu_name, String date,
			String start_time, String end_time, int status) {
		super();
		this.record_id=record_id;
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.status = status;
	}
	
	public int getRecord_id() {
		return record_id;
	}
	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "RecordInfo [record_id=" + record_id + ", stu_id=" + stu_id
				+ ", stu_name=" + stu_name + ", date=" + date + ", start_time="
				+ start_time + ", end_time=" + end_time + ", status=" + status
				+ "]";
	}
	
	
	
	
	
	
	
	

}
