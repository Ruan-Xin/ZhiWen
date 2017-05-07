package com.roy.service;
import java.util.List;

import com.roy.database.User;
/**
 * �û�ҵ�����ӿ�
 * @author Roy
 * @date: 2017��5��6��  ����11:22:34
 * version:
 */
public interface IUserService {
	/**
	 * ��ѯ�û�����������
	 * @return
	 */
	public List<User> query(String account) throws Exception;
	
	/**
	 * �����û�
	 * @param user
	 */
	public void update(User user) throws Exception;
	
	/**
	 * ɾ��ѡ���û�
	 * @param ids
	 */
	public void delete(int...ids) throws Exception;
	
	/**
	 * �������û�
	 * @param user
	 * @throws Exception
	 */
	public void add(User user) throws Exception;
}
