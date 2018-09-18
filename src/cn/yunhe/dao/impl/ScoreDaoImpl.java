package cn.yunhe.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.yunhe.dao.ScoreDao;
import cn.yunhe.entity.ScoreInfo;
import cn.yunhe.util.ORMUtil;
import cn.yunhe.util.UtilityClass42;

public class ScoreDaoImpl implements ScoreDao {

	@Override
	public List<ScoreInfo> selectScore(String assessment,String  scoreTime,String scoreName,String class_id,int yeshu,int line) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("SELECT t2.*,t1.stu_name,DATE_FORMAT(time,'%m/%d/%Y') FROM tb_student t1,tb_score t2 where t1.stu_id=t2.stu_id ");
		List<Object> scoList=new ArrayList<Object>();
		if(assessment!=null && !assessment.equals("")){
			sql.append(" and score_type=? ");
			scoList.add(Integer.parseInt(assessment));
		}
		
		if(scoreTime!=null && !scoreTime.equals("")){
			sql.append(" and DATE_FORMAT(time,'%m/%d/%Y')=? ");
			scoList.add(scoreTime);
			
		}
		
		if(scoreName!=null && !scoreName.equals("")){
			sql.append(" and t2.stu_id=? ");
			scoList.add(Integer.parseInt(scoreName));
		}
		
		if(Integer.parseInt(class_id)!=-1){
			sql.append(" and t2.class_id=? ");
			scoList.add(Integer.parseInt(class_id));
		}
		
		//·ÖÒ³
		sql.append("ORDER BY stu_id,time LIMIT ?,?");
		scoList.add((yeshu-1)*line);
		scoList.add(line);
		
		List<ScoreInfo> scoreList=ORMUtil.ormutil().selectList(sql.toString(), scoList.toArray(), ScoreInfo.class);
		return scoreList;
	}

	@Override
	public int selectScoreRecord(String assessment,String scoreTime,String scoreName,String class_id) {
		StringBuffer sql=new StringBuffer("SELECT t2.*,t1.stu_name,count(*) num,DATE_FORMAT(time,'%m/%d/%Y') FROM tb_student t1,tb_score t2 where t1.stu_id=t2.stu_id ");
		List<Object> scoList=new ArrayList<Object>();
		if(assessment!=null && !assessment.equals("")){
			sql.append(" and score_type=? ");
			scoList.add(Integer.parseInt(assessment));
		}
		
		if(scoreTime!=null && !scoreTime.equals("")){
			sql.append(" and DATE_FORMAT(time,'%m/%d/%Y')=?  ");
			scoList.add(scoreTime);
			
		}
		
		if(scoreName!=null && !scoreName.equals("")){
			sql.append(" and t2.stu_id=? ");
			scoList.add(Integer.parseInt(scoreName));
		}
		
		if(Integer.parseInt(class_id)!=-1){
			sql.append(" and t2.class_id=? ");
			scoList.add(Integer.parseInt(class_id));
		}
		
		List<Map<String, Object>> scorList=UtilityClass42.utitli().performDQL(sql.toString(), scoList.toArray());
		Long num=(Long) scorList.get(0).get("num");
		return num.intValue();
		
	}

	@Override
	public boolean addScore(ScoreInfo score) {
		// TODO Auto-generated method stub
		boolean fag=false;
		String sql="INSERT INTO tb_score (score_type,time,stu_id,score_contents,score_value) VALUES (?,?,?,?,?)";
		Object[] scoreArray={score.getScore_type(),score.getTime(),score.getStu_name(),score.getScore_contents(),score.getScore_value()};
		int result=ORMUtil.ormutil().performDML(sql, scoreArray);
		if(result==-1){
			fag=true;
		}
		return fag;
	}

	@Override
	public void deleteScore(int scoreId) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM tb_score WHERE score_id=?";
		Object[] scoreArray={scoreId};
		ORMUtil.ormutil().performDML(sql, scoreArray);
	}

	@Override
	public ScoreInfo selectScoreOne(int scoreId) {
		// TODO Auto-generated method stub
		String sql="select * from tb_score where score_id=?";
		Object[] scoreArray={scoreId};
		List<ScoreInfo> scoreList=ORMUtil.ormutil().selectList(sql, scoreArray, ScoreInfo.class);
		return scoreList.size()>0?scoreList.get(0):null;
	}

	@Override
	public void updateScore(ScoreInfo sco) {
		// TODO Auto-generated method stub
		String sql="UPDATE tb_score SET score_type=?,score_value=?,score_contents=?,time=? WHERE score_id=?";
		Object[] params={sco.getScore_type(),sco.getScore_value(),sco.getScore_contents(),sco.getTime(),sco.getScore_id()};
		
		ORMUtil.ormutil().performDML(sql, params);
	}

	

	

	

	

}
