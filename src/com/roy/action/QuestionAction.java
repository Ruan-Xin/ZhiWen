package com.roy.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.roy.database.Question;
import com.roy.service.IQuestionService;

import net.sf.json.JSONObject;

/**
 * �û�������������
 * @author Roy
 * @date: 2017��5��12��  ����9:44:42
 * version:
 */
public class QuestionAction extends ActionSupport{
	private HttpServletRequest request;
	private HttpServletResponse response;
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
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
	/**
	 * ajax��ʾ����
	 * �˴���ʾ���5�����⣬����5����ʱ����ȫ����ʾ
	 */
	public void show() {
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		try {
			List<Question> list = iquestionService.query();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("title", list.get(0).getTitle());
			jsonObject.put("content", list.get(0).getContent());
			response.getWriter().println(jsonObject.toString());
			if (list.size() < 5) {
				
			}else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
