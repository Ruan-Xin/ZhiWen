package com.roy.idao;

import java.util.List;

/**
 * �������ݷ��ʽӿ�
 * @author Roy
 * @date: 2017��5��13��  ����7:39:50
 * version:
 */
public interface IQuestionDaoService {
	/**
	 * ��ѯ����
	 * @param hql
	 * @return
	 * @throws Exception
	 */
	public List<? extends Object> query(String hql) throws Exception;
	
	/**
	 * �������
	 * @param object
	 * @throws Exception
	 */
	public void save(Object object) throws Exception;
	
	/**
	 * �޸Ķ���
	 * @param object
	 * @throws Exception
	 */
	public void update(Object object) throws Exception;
	
	/**
	 * ɾ������
	 * @param objects
	 * @throws Exception
	 */
	public void delete(Object...objects) throws Exception;

}
