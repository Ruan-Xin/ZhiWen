package com.roy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.roy.database.Question;
import com.roy.service.IQuestionService;

/**
 * �û�������������
 * @author Roy
 * @date: 2017��5��12��  ����9:44:42
 * version:
 */
public class QuestionAction extends ActionSupport{
	private Question question;
	private IQuestionService iquestionService;
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public IQuestionService getIquestionService() {
		return iquestionService;
	}
	public void setIquestionService(IQuestionService iquestionService) {
		this.iquestionService = iquestionService;
	}
	
	/**
	 * ������� 
	 * @return
	 */
	public String add() {
		try {
			iquestionService.add(question);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * ����������Ϣ
	 * @return
	 */
	public String update() {
		try {
			iquestionService.update(question);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
	/**
	 * ɾ������
	 * @return
	 */
	public String delete() {
		try {
			iquestionService.delete(question);
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
}
