package cn.yunhe.dao;

import java.util.List;


import cn.yunhe.entity.RecordInfo;

public interface RecordDao {
	//��ѯ�����˵Ĵ򿨼�¼
	List<RecordInfo> queryRecordInfo(String time,String name,String status,String class_id,int yeshu,int line);
	
	//��ѯѧ����Ϣ�ܼ�¼��
	int seleteRecord(String time,String name,String status,String class_id);
	
	
	
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
	void updateRecord(RecordInfo rec);
	
	
	
	//�����޸Ĵ򿨼�¼��״̬
	
	void updateRecordStatus(String recordId,String status);
	
}
