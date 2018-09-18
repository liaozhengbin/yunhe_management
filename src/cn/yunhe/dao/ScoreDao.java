package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.ScoreInfo;

public interface ScoreDao {
	
	
	//�鿴����ѧ������
	List<ScoreInfo> selectScore(String assessment,String  scoreTime,String scoreName,String class_id,int yeshu,int line);
	
	//�鿴����ѧ����Ϣ����
	int selectScoreRecord(String assessment,String  scoreTime,String scoreName,String class_id);
	
	//����scoreID��ѯ��Ϣ
	ScoreInfo selectScoreOne(int scoreId);
	
	//��ӷ���
	boolean addScore(ScoreInfo score);
	
	
	/**
	 * ָ������IDɾ������
	 * @param scoreId
	 */
	void deleteScore(int scoreId);
	
	
	
	/**
	 * �޸�ѧԱ��Ϣ
	 * @param stu
	 */
	void updateScore(ScoreInfo sco);
	
	
}
