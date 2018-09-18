package cn.yunhe.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.yunhe.dao.RecordDao;
import cn.yunhe.entity.RecordInfo;
import cn.yunhe.util.ORMUtil;
import cn.yunhe.util.UtilityClass42;

public class RecordDaoImpl implements RecordDao {

	@Override
	public List<RecordInfo> queryRecordInfo(String time, String name,String status,String class_id,int yeshu,int line) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("select t1.*,t2.class_id from (select *,DATE_FORMAT(date,'%m/%d/%Y') number from tb_record)t1 ,tb_student t2 WHERE t1.stu_id=t2.stu_id  ");
		List<Object> recordArray=new ArrayList<Object>();
		if(time!=null && !time.equals("")){
			sql.append(" and number=? ");
			recordArray.add(time);
		}
		if(name!=null && !name.equals("")){
			sql.append(" and t1.stu_id=? ");
			recordArray.add(Integer.parseInt(name));
		}
		if(status!=null && !status.equals("")){
			sql.append(" and t1.status=? ");
			recordArray.add(Integer.parseInt(status));
		}
		if(Integer.parseInt(class_id)!=-1){
			sql.append(" and t2.class_id=? ");
			recordArray.add(Integer.parseInt(class_id));
		}
		
		//分页
		sql.append(" ORDER BY stu_id LIMIT ?,?");
		recordArray.add((yeshu-1)*line);
		recordArray.add(line);
		
		
		
		List<RecordInfo> recordList=ORMUtil.ormutil().selectList(sql.toString(), recordArray.toArray(), RecordInfo.class);
		return recordList;
	}

	@Override
	public int seleteRecord(String time, String name,String status,String class_id) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("select t1.*,t2.class_id,count(*) num from (select *,DATE_FORMAT(date,'%m/%d/%Y') number from tb_record)t1 ,tb_student t2 WHERE t1.stu_id=t2.stu_id  ");
		List<Object> recordArray=new ArrayList<Object>();
		if(time!=null && !time.equals("")){
			sql.append(" and number=? ");
			recordArray.add(time);
		}
		if(name!=null && !name.equals("")){
			sql.append(" and t1.stu_id=? ");
			recordArray.add(Integer.parseInt(name));
		}
		if(status!=null && !status.equals("")){
			sql.append(" and t1.status=? ");
			recordArray.add(Integer.parseInt(status));
		}
		if(Integer.parseInt(class_id)!=-1){
			sql.append(" and t2.class_id=? ");
			recordArray.add(Integer.parseInt(class_id));
		}
		
		
		
		List<Map<String, Object>> list=UtilityClass42.utitli().performDQL(sql.toString(), recordArray.toArray());
		Long num=(Long) list.get(0).get("num");
		
		return num.intValue();
	}
	
	
	// 根据recordID查询信息
	@Override
	public RecordInfo selectRecordOne(int recordId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tb_record where record_id=?";
		Object[] recordArray={recordId};
		List<RecordInfo> recordList=ORMUtil.ormutil().selectList(sql, recordArray, RecordInfo.class);
		return recordList.size()>0?recordList.get(0):null;
	}
	
	
	/**
	 * 指定记录ID删除记录
	 * 
	 * @param recordId
	 */
	@Override
	public void deleteRecord(int recordId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM tb_record WHERE record_id=?";
		Object[] recordArray={recordId};
		ORMUtil.ormutil().performDML(sql, recordArray);
		
	}
	
	
	/**
	 * 修改打卡记录信息
	 * 
	 * @param rec
	 */
	@Override
	public void updateRecord(RecordInfo rec) {
		// TODO Auto-generated method stub
		String sql="UPDATE tb_record SET start_time=?,end_time=?,status=? WHERE record_id=?";
		Object[] params={rec.getStart_time(),rec.getEnd_time(),rec.getStatus(),rec.getRecord_id()};
		ORMUtil.ormutil().performDML(sql, params);
	}

	@Override
	public void updateRecordStatus(String recordId, String status) {
		// TODO Auto-generated method stub
		String sql="UPDATE tb_record SET status=? WHERE record_id IN("+recordId+")";
		Object[] recordArray={status};
		ORMUtil.ormutil().performDML(sql, recordArray);
	}

}
