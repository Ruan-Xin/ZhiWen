package com.roy.service;

import java.util.List;

import com.roy.database.Comment;
import com.roy.database.Question;
import com.roy.database.User;

public interface ICommentService {
	/**
	 * ��ѯһ���û�����������
	 * @return
	 */
	public List<Comment> query(User user) throws Exception;
	
	/**
	 * ��ѯһ�������µ���������
	 * @param question
	 * @return
	 */
	public List<Comment> query(int titleid) throws Exception;
	/**
	 * �������
	 * @param comment
	 */
	public void add(Comment comment) throws Exception;
	/**
	 * ɾ������
	 * @param comment
	 */
	public void delete(Comment comment) throws Exception;
	/**
	 * ��������
	 * @param comment
	 */
	public void update(Comment comment) throws Exception;
}
