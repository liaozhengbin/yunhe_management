package cn.yunhe.biz;

import java.util.List;

import cn.yunhe.entity.ScoreInfo;

public interface ScoreBiz {
	
	
	//查看所有学生分数
	List<ScoreInfo> selectScore(String assessment,String  scoreTime,String scoreName,String class_id,int yeshu,int line);
	
	//查看所有学生总记录数
	int selectScoreRecord(String assessment,String  scoreTime,String scoreName,String class_id);
	
	//查看所有学生总页数
	int selectScorePage(String assessment,String  scoreTime,String scoreName,String class_id,int num);
	
	//添加分数
	boolean addScore(ScoreInfo score);
	
	/**
	 * 指定分数ID删除分数
	 * @param scoreId
	 */
	void deleteScore(int scoreId);
	
	
	//根据scoreID查询信息
	ScoreInfo selectScoreOne(int scoreId);
	
	//修改score信息
	void updateScore(int scoreId,String score_type,String time,String stu_id,String score_contents,double score_value);

}
