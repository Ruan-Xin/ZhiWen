package com.roy.service;

import java.util.List;

import com.roy.database.Question;
import com.roy.database.User;

/**
 * ���ʹ���ӿ�
 * @author Roy
 * @date: 2017��5��12��  ����8:49:35
 * version:
 */
public interface IQuestionService {
	
	/**
	 * ���ݱ�������ѯ��������
	 * @param title
	 * @return
	 */
	public List<Question> query(String title) throws Exception;
	
	/**
	 * �����û�����ѯ��������
	 * @param user
	 * @return
	 */
	public List<Question> query(User user) throws Exception;
	
	/**
	 * ��������
	 * @param question
	 */
	public void update(Question question) throws Exception;
	
	/**
	 * ����������
	 * @param question
	 */
	public void add(Question question) throws Exception;
	/**
	 * ɾ������
	 * @param question
	 */
	public void delete(Question question) throws Exception;
}
