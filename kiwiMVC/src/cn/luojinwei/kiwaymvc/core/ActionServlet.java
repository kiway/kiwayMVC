package cn.luojinwei.kiwaymvc.core;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.luojinwei.kiwaymvc.bean.ActionForm;
import cn.luojinwei.kiwaymvc.bean.XmlBean;

public class ActionServlet extends HttpServlet{

	 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //����url
		String path = this.getPath(request.getServletPath());
		 // ���������Ϣ��XxmlBean
		Map<String,XmlBean> map = (Map<String,XmlBean>)request.getAttribute("struts");
		XmlBean xml = map.get(path);
		String actionClass = xml.getActionClass();
		String formClass = xml.getFormClass();
		
		//ͨ������ ��� ��װ��ǰ̨���ε�form��
		ActionForm form = FullBean.full(request, formClass);
		Action action = null;
		String url = "";   // �����ת��url
		try {
			// ͨ�������� Ҫִ�е�action��
			Class clazz = Class.forName(actionClass);
			action = (Action) clazz.newInstance();
			// ���ø�action���execute����,���������ת��url
			url = action.execute(request, response, form, xml.getActionForward());
		  
	 	} catch (Exception e) {
	 		e.printStackTrace();
		}
		// ����url��÷ַ���,���ҳ����ת
		RequestDispatcher dispacher = request.getRequestDispatcher(url);
		dispacher.forward(request, response); 
	}

	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	//�����ʵ���� �� hello.do -> hello
	private String getPath(String servletPath) {
		return servletPath.split(".")[0];
	}

}
