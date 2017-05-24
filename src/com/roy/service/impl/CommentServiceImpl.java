package com.roy.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.roy.database.Comment;
import com.roy.database.PageBean;
import com.roy.database.User;
import com.roy.idao.IDaoService;
import com.roy.service.ICommentService;

public class CommentServiceImpl implements ICommentService {
	private IDaoService idaoService;
	private Map<Integer, PageBean> titleid_pageBean;

	public IDaoService getIdaoService() {
		return idaoService;
	}

	public void setIdaoService(IDaoService idaoService) {
		this.idaoService = idaoService;
	}

	public Map<Integer, PageBean> getTitleid_pageBean() {
		return titleid_pageBean;
	}

	public void setTitleid_pageBean(Map<Integer, PageBean> titleid_pageBean) {
		this.titleid_pageBean = titleid_pageBean;
	}

	@Override
	public List<Comment> query(int titleid, int pageSize) {
		// TODO Auto-generated method stub
		if (titleid_pageBean.get(titleid) == null) {
			PageBean pageBean = new PageBean();
			String hql = "select count(*) from Comment where titleid=" + titleid;
			int totalRecord = idaoService.getCount(hql);// һ���ж�������¼
			int totalPage = PageBean.countTotalPage(pageSize, totalRecord);// һ���ж���ҳ
			pageBean.setTotalRecord(totalRecord);
			if (totalRecord < pageSize) {
				// һҳ�ļ�¼�����ܼ�¼������
				pageBean.setTotalPage(totalPage);
				pageBean.setCurrentPage(totalPage);
				pageBean.setPageSize(totalPage);
				String hql_query = "from comment where titleid=" + titleid;
				try {
					List<Comment> list = (List<Comment>) idaoService.query(hql_query, 0, totalRecord);
					titleid_pageBean.put(titleid, pageBean);
					return list;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				// ��һҳ
				pageBean.setPageSize(pageSize);
				pageBean.setTotalPage(totalPage);
				String hql_query = "from comment where titleid=" + titleid;
				try {
					List<Comment> list = (List<Comment>) idaoService.query(hql, 0, pageSize);
					pageBean.setCurrentPage(2);
					titleid_pageBean.put(titleid, pageBean);
					return list;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			PageBean pageBean = titleid_pageBean.get(titleid);
			if (pageBean.isOver()) {
				//û�м�������
				return null;
			} else if (pageBean.isLastPage()) {
				int offset = (pageBean.getCurrentPage() - 1) * pageSize;
				int length = pageBean.getTotalRecord() - offset + 1;
				String hql_query = "from comment where titleid=" + titleid;
				pageBean.setCurrentPage(pageBean.getCurrentPage() + 1);
				try {
					List<Comment> list = (List<Comment>) idaoService.query(hql_query, offset, length);
					titleid_pageBean.put(titleid, pageBean);
					return list;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			} else {
				// pageSize < total - current
				int offset = (pageBean.getCurrentPage() - 1) * pageSize;
				String hql_query = "from comment where titleid=" + titleid;
				pageBean.setCurrentPage(pageBean.getCurrentPage() + 1);
				try {
					List<Comment> list = (List<Comment>) idaoService.query(hql_query, offset, pageSize);
					titleid_pageBean.put(titleid, pageBean);
					return list;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public List<Comment> query(User user) throws Exception {
		// TODO Auto-generated method stub
		List<Comment> list = (List<Comment>) idaoService
				.query("from Comment where user_account='" + user.getUserAccount() + "'");
		return list;
	}

	@Override
	public List<Comment> query(int titleid) throws Exception {
		// TODO Auto-generated method stub
		List<Comment> list = (List<Comment>) idaoService
				.query("from Comment where titleid=" + titleid + " order by date desc");
		return list;
	}

	@Override
	public void add(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		comment.setDate(new Timestamp(System.currentTimeMillis()));
		idaoService.save(comment);
	}

	@Override
	public void delete(Comment comment) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Comment comment) throws Exception {
		// TODO Auto-generated method stub

	}
}
