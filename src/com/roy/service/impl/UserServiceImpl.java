package com.roy.service.impl;
import java.sql.Timestamp;
import java.util.List;

import com.roy.database.User;
import com.roy.idao.IDaoService;
import com.roy.service.IUserService;;
/**
 * �û�����ҵ�����ʵ����
 * @author Roy
 * @date: 2017��5��6��  ����11:38:06
 * version:
 */
public class UserServiceImpl implements IUserService{
	private IDaoService idaoService;
	
	public void setIdaoService(IDaoService idaoService) {
		this.idaoService = idaoService;
	}
	public IDaoService getIdaoService() {
		return idaoService;
	}
	
	/**
	 * ��ȡ��ѯ���
	 */
	@Override
	public List<User> query(String account) throws Exception {
		// TODO Auto-generated method stub
		//ͨ���������ݷ��ʽӿڲ�ѯ����
		List<User> list = (List<User>) idaoService.query("from User "
				+ "where " + "user_account='" + account + "'");
		return list;
	}

	@Override
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		user.setIsdel("0");
		user.setOperTime(new Timestamp(System.currentTimeMillis()));
		idaoService.update(user);
	}

	@Override
	public void delete(int... ids) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(User user) throws Exception {
		// TODO Auto-generated method stub
		//��װͨ���ֶ�
		user.setIsdel("0");
		user.setOperTime(new Timestamp(System.currentTimeMillis()));
		//�������ݿ⣬����ֵ
		idaoService.save((Object)user);
	}
	
}
