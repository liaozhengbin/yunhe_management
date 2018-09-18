package cn.yunhe.biz.impl;

import java.util.List;

import cn.yunhe.biz.RecordBiz;
import cn.yunhe.dao.RecordDao;
import cn.yunhe.dao.impl.RecordDaoImpl;
import cn.yunhe.entity.RecordInfo;

public class RecordBizImpl implements RecordBiz {
	private RecordDao recordDao=new RecordDaoImpl();
	@Override
	public List<RecordInfo> queryRecordInfo(String time, String name,String status,String class_id,
			int yeshu, int line) {
		// TODO Auto-generated method stub
		return recordDao.queryRecordInfo(time, name, status,class_id,yeshu, line);
	}
	@Override
	public int seleteRecord(String time, String name,String status,String class_id) {
		// TODO Auto-generated method stub
		return recordDao.seleteRecord(time, name,status,class_id);
	}
	@Override
	public int calculateRecordPage(String time, String name,String status,String class_id, int num) {
		// TODO Auto-generated method stub
		int conn=recordDao.seleteRecord(time, name,status,class_id);
		return conn%num==0?conn/num:conn/num+1;
				
	}
	@Override
	public RecordInfo selectRecordOne(int recordId) {
		// TODO Auto-generated method stub
		return recordDao.selectRecordOne(recordId);
	}
	@Override
	public void deleteRecord(int recordId) {
		// TODO Auto-generated method stub
		recordDao.deleteRecord(recordId);
	}
	@Override
	public void updateRecord(String date,String stu_name,String start_time,String end_time,int status,int record_id) {
		// TODO Auto-generated method stub
		RecordInfo recordInfo=new RecordInfo();
		recordInfo.setDate(date);
		recordInfo.setStu_name(stu_name);
		recordInfo.setStart_time(start_time);
		recordInfo.setEnd_time(end_time);
		recordInfo.setStatus(status);
		recordInfo.setRecord_id(record_id);
		recordDao.updateRecord(recordInfo);
		
	}
	@Override
	public void updateRecordStatus(List<String> recordList, String status) {
		// TODO Auto-generated method stub
		//调用dao层时，要将集合中的元素取出来，拼接成字符串，格式是“id1,id2,id3.....”
		StringBuffer sb=new StringBuffer();
		for (String record : recordList) {
			sb.append(record);
			sb.append(",");
		}
//		//去除末尾的逗号“,”
		sb.delete(sb.length()-1, sb.length());
		
		recordDao.updateRecordStatus(sb.toString(), status);
	}
	

}
