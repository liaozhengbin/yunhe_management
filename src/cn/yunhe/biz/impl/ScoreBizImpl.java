package cn.yunhe.biz.impl;

import java.util.List;

import cn.yunhe.biz.ScoreBiz;
import cn.yunhe.dao.ScoreDao;
import cn.yunhe.dao.impl.ScoreDaoImpl;
import cn.yunhe.entity.ScoreInfo;

public class ScoreBizImpl implements ScoreBiz {
	private ScoreDao scoreDao=new ScoreDaoImpl();
	
	@Override
	public List<ScoreInfo> selectScore(String assessment,String  scoreTime,String scoreName,String class_id,int yeshu, int line) {
		// TODO Auto-generated method stub
		return scoreDao.selectScore(assessment, scoreTime, scoreName,class_id, yeshu, line);
	}
	@Override
	public int selectScoreRecord(String assessment,String  scoreTime,String scoreName,String class_id) {
		// TODO Auto-generated method stub
		return scoreDao.selectScoreRecord(assessment, scoreTime, scoreName,class_id);
	}
	@Override
	public int selectScorePage(String assessment,String  scoreTime,String scoreName,String class_id,int num) {
		// TODO Auto-generated method stub
		int zong=scoreDao.selectScoreRecord(assessment, scoreTime, scoreName,class_id);
		int yeshu=zong%num==0?zong/num:zong/num+1;
		return yeshu;
	}
	@Override
	public boolean addScore(ScoreInfo score) {
		// TODO Auto-generated method stub
		boolean fah=scoreDao.addScore(score);
		
		return fah;
	}
	@Override
	public void deleteScore(int scoreId) {
		// TODO Auto-generated method stub
		scoreDao.deleteScore(scoreId);
	}
	@Override
	public ScoreInfo selectScoreOne(int scoreId) {
		// TODO Auto-generated method stub
		return scoreDao.selectScoreOne(scoreId);
	}
	@Override
	public void updateScore(int scoreId, String score_type, String time,
			String stu_id, String score_contents, double score_value) {
		// TODO Auto-generated method stub
		ScoreInfo score=new ScoreInfo();
		score.setScore_id(scoreId);
		score.setScore_type(Integer.parseInt(score_type));
		score.setTime(time);
		score.setStu_id(Integer.parseInt(stu_id));
		score.setScore_contents(score_contents);
		score.setScore_value(score_value);
		
		scoreDao.updateScore(score);
		
	}
	
	
	
}
