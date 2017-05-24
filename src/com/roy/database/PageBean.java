package com.roy.database;

import java.util.List;

/**
 * ��ҳ��Ϣ��
 * @author Roy
 * @date: 2017��5��23��  ����8:43:39
 * version:
 */
public class PageBean {
	private List<? extends Object> list;//Ҫ���ص�ĳһҳ���б�
	private int totalPage;//��ҳ��
	private int currentPage;//��ǰҳ
	private int pageSize;//ÿҳ��¼��
	private int totalRecord;//�ܼ�¼��
	
	@SuppressWarnings("unused")
	private boolean isFirstPage;//�Ƿ�Ϊ��һҳ
	@SuppressWarnings("unused")
	private boolean isLastPage;//�Ƿ�Ϊ���һҳ
	@SuppressWarnings("unused")
	private boolean hasPreviousPage;//�Ƿ���ǰһҳ
	@SuppressWarnings("unused")
	private boolean hasNextPage;
	
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public List<? extends Object> getList() {
		return list;
	}
	public void setList(List<? extends Object> list) {
		this.list = list;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * �����ж�ҳ��Ϣ
	 */
	public boolean isOver() {
		return currentPage > totalPage;
	}
	public boolean isFirstPage() {
		return currentPage == 1;
	}
	
	public boolean isLastPage() {
		return currentPage == totalPage;
	}
	
	public boolean isHasPreviousPage() {
		return currentPage != 1;
	}
	
	public boolean isHasNextPage() {
		return currentPage != totalPage;
	}
	
	/**
	 * ������ҳ��
	 */
	public static int countTotalPage(final int pageSize, final int allRow) {
		int totalPage = allRow % pageSize == 0? allRow / pageSize : allRow / pageSize + 1;
		return totalPage;
	}
	/**
	 * ���㵱ǰҳ
	 */
	public static int countCurrentPage(int page) {
		final int curPage = (page == 0? 1: page);
		return curPage;
	}
}
