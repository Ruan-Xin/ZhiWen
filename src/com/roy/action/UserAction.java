package com.roy.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.roy.database.User;
import com.roy.service.IUserService;

/**
 * �û�����ҵ�������
 * @author Roy
 * @date: 2017��5��12��  ����9:44:27
 * version:
 */
public class UserAction extends ActionSupport{
	private IUserService iuserService;
	private User user;//�������������ͻ����ύ�������Զ���װ�����ԣ���ǰ������user
	
	public void setIuserService(IUserService iuserService) {
		this.iuserService = iuserService;
	}
	public IUserService getIuserService() {
		return iuserService;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	
	public String list() {
		try {
			List<User> list = iuserService.query(user.getUserAccount());
			ActionContext.getContext().getContextMap().put("list", list);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public String add() {
		try {
			iuserService.add(user);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	/**
	 * ��¼�߼�
	 * @return
	 */
	public String login() {
		try {
			List<User> list = iuserService.query(user.getUserAccount());
			
			if (list == null || list.size() == 0) {
				return ERROR;
			}else {
				if (list.size() != 0 && 
						list.get(0).getUserPassword().equals(user.getUserPassword())) {
					return SUCCESS;
				}else {
					return ERROR;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
}
