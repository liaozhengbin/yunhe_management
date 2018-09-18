package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.ScoreInfo;

public interface ScoreDao {
	
	
	//查看所有学生分数
	List<ScoreInfo> selectScore(String assessment,String  scoreTime,String scoreName,String class_id,int yeshu,int line);
	
	//查看所有学生信息总数
	int selectScoreRecord(String assessment,String  scoreTime,String scoreName,String class_id);
	
	//根据scoreID查询信息
	ScoreInfo selectScoreOne(int scoreId);
	
	//添加分数
	boolean addScore(ScoreInfo score);
	
	
	/**
	 * 指定分数ID删除分数
	 * @param scoreId
	 */
	void deleteScore(int scoreId);
	
	
	
	/**
	 * 修改学员信息
	 * @param stu
	 */
	void updateScore(ScoreInfo sco);
	
	
}
