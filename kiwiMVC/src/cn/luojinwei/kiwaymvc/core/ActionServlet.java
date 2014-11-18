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
		 //请求url
		String path = this.getPath(request.getServletPath());
		 // 获得配置信息的XxmlBean
		Map<String,XmlBean> map = (Map<String,XmlBean>)request.getAttribute("struts");
		XmlBean xml = map.get(path);
		String actionClass = xml.getActionClass();
		String formClass = xml.getFormClass();
		
		//通过反射 获得 已装载前台传参的form表单
		ActionForm form = FullBean.full(request, formClass);
		Action action = null;
		String url = "";   // 最后跳转的url
		try {
			// 通过反射获得 要执行的action类
			Class clazz = Class.forName(actionClass);
			action = (Action) clazz.newInstance();
			// 调用该action类的execute方法,获得最终跳转的url
			url = action.execute(request, response, form, xml.getActionForward());
		  
	 	} catch (Exception e) {
	 		e.printStackTrace();
		}
		// 根据url获得分发器,完成页面跳转
		RequestDispatcher dispacher = request.getRequestDispatcher(url);
		dispacher.forward(request, response); 
	}

	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	//获得真实请求， 如 hello.do -> hello
	private String getPath(String servletPath) {
		return servletPath.split(".")[0];
	}

}
