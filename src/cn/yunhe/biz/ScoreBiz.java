package cn.yunhe.biz;

import java.util.List;

import cn.yunhe.entity.ScoreInfo;

public interface ScoreBiz {
	
	
	//�鿴����ѧ������
	List<ScoreInfo> selectScore(String assessment,String  scoreTime,String scoreName,String class_id,int yeshu,int line);
	
	//�鿴����ѧ���ܼ�¼��
	int selectScoreRecord(String assessment,String  scoreTime,String scoreName,String class_id);
	
	//�鿴����ѧ����ҳ��
	int selectScorePage(String assessment,String  scoreTime,String scoreName,String class_id,int num);
	
	//��ӷ���
	boolean addScore(ScoreInfo score);
	
	/**
	 * ָ������IDɾ������
	 * @param scoreId
	 */
	void deleteScore(int scoreId);
	
	
	//����scoreID��ѯ��Ϣ
	ScoreInfo selectScoreOne(int scoreId);
	
	//�޸�score��Ϣ
	void updateScore(int scoreId,String score_type,String time,String stu_id,String score_contents,double score_value);

}
