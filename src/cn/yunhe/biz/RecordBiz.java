package cn.yunhe.biz;

import java.util.List;

import cn.yunhe.entity.RecordInfo;

public interface RecordBiz {
	//查询所有人的打卡记录
		List<RecordInfo> queryRecordInfo(String time,String name,String status,String class_id,int yeshu,int line);
		
		//查询学生信息总记录数
		int seleteRecord(String time,String name,String status,String class_id);
		
		//查询学生信息总页数
		int calculateRecordPage(String time,String name,String status,String class_id,int num);
		
		
		// 根据recordID查询信息
		RecordInfo selectRecordOne(int recordId);
		
		
		/**
		 * 指定记录ID删除记录
		 * 
		 * @param recordId
		 */
		void deleteRecord(int recordId);

		/**
		 * 修改打卡记录信息
		 * 
		 * @param rec
		 */
		void updateRecord(String date,String stu_name,String start_time,String end_time,int status,int record_id);
		
		
		//批量修改打卡记录的状态
		
		void updateRecordStatus(List<String> recordList,String status);
		
}
