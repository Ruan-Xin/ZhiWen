package com.roy.idao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.roy.idao.IDaoService;

public class DaoServiceImpl implements IDaoService {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * �򿪲�����һ�����ݿ�ĻỰ
	 * @return
	 */
	public Session getSession(){
		return sessionFactory.openSession();
	}

	@Override
	public List<? extends Object> query(String hql) throws Exception {
		// TODO Auto-generated method stub
		//��ȡһ�����ݿ�Ự����
		Session session = getSession();
		//������ѯ���ݶ���
		Query query = session.createQuery(hql);
		//��ѯ�������ݼ���
		List<? extends Object> list = query.list();
		//�رջỰ
		session.close();
		return list;
	}

	@Override
	public void save(Object object) throws Exception {
		// TODO Auto-generated method stub
		Session session = getSession();
		//��������
		Transaction transaction = session.beginTransaction();
		//������session��
		session.save(object);
		//�ύ����
		transaction.commit();
		session.flush();
		//�ر�session
		session.close();
	}

	@Override
	public void update(Object object) throws Exception {
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		session.update(object);
		transaction.commit();
		session.close();
	}

	@Override
	public void delete(Object... objects) throws Exception {
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		for(Object object : objects){
			//����ɾ��
			session.update(object);
		}
		transaction.commit();
		session.close();
	}

}
