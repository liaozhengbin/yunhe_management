package cn.yunhe.biz;

import java.util.List;

import cn.yunhe.entity.RecordInfo;

public interface RecordBiz {
	//��ѯ�����˵Ĵ򿨼�¼
		List<RecordInfo> queryRecordInfo(String time,String name,String status,String class_id,int yeshu,int line);
		
		//��ѯѧ����Ϣ�ܼ�¼��
		int seleteRecord(String time,String name,String status,String class_id);
		
		//��ѯѧ����Ϣ��ҳ��
		int calculateRecordPage(String time,String name,String status,String class_id,int num);
		
		
		// ����recordID��ѯ��Ϣ
		RecordInfo selectRecordOne(int recordId);
		
		
		/**
		 * ָ����¼IDɾ����¼
		 * 
		 * @param recordId
		 */
		void deleteRecord(int recordId);

		/**
		 * �޸Ĵ򿨼�¼��Ϣ
		 * 
		 * @param rec
		 */
		void updateRecord(String date,String stu_name,String start_time,String end_time,int status,int record_id);
		
		
		//�����޸Ĵ򿨼�¼��״̬
		
		void updateRecordStatus(List<String> recordList,String status);
		
}
