package com.roy.idao;

import java.util.List;

import com.roy.database.Comment;

/**
 * ���ݷ��ʹ����ӿ�
 * @author Roy
 * @date: 2017��5��5��  ����7:25:19
 * version:
 */
public interface IDaoService {
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
	 * @return 
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
