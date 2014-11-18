package cn.luojinwei.kiwaymvc.listener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jdom2.JDOMException;

import cn.luojinwei.kiwaymvc.bean.XmlBean;
import cn.luojinwei.kiwaymvc.util.StrutsXmlParse;

public class ActionListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("info: kiwayMVC has shutdown !!");
	}

	public void contextInitialized(ServletContextEvent servleEvent) {
		Map<String,XmlBean> map = null;
		ServletContext context = servleEvent.getServletContext();
		String tomcatPath = context.getRealPath("//");
		String xmlPath = "/WEB-INF/struts-config.xml";
		try {
			map = StrutsXmlParse.parseXml(tomcatPath + xmlPath);   // ����xml��·������xml
			context.setAttribute("struts", map);   //��servletContext����application�з���xml�Ľ���Bean
			 
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("info: kiwayMVC has started!! ");
		
	}

}
