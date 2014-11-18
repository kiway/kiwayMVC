package cn.luojinwei.kiwaymvc.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParserFactory;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import cn.luojinwei.kiwaymvc.bean.XmlBean;

public class StrutsXmlParse {

	public static Map<String,XmlBean> parseXml(String xmlPath) throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		System.out.println("xmlPath:"+xmlPath);
		Document document = builder.build(new File(xmlPath));
		Element root = document.getRootElement();  //根节点		 
		
		// 结果map
		Map<String,XmlBean> rMap = new HashMap<String, XmlBean>();
		
		//获得action-mappings元素
		List<Element> actionMapping = root.getChild("action-mappings").getChildren();
		for(Element action : actionMapping) {
			XmlBean actionBean = new XmlBean();   // xml实体Bean
			String name = action.getAttributeValue("name");
			String type = action.getAttributeValue("type");
			String path = action.getAttributeValue("path");
			actionBean.setBeanName(name);
			actionBean.setActionClass(type);
			actionBean.setPath(path);			 
			
			// 遍历 formBeans，查找与action的name相同的formBean；
			List<Element> formBeans = root.getChild("form-beans").getChildren();
			for(Element formBean : formBeans) {
				if(name.equals(formBean.getAttributeValue("name"))){ 
					actionBean.setFormClass(formBean.getAttributeValue("type"));
					break;
				}
			}
			 
			// 遍历action子元素forward，获得跳转map
			Map<String,String> forwardMap = new HashMap<String,String>();
			List<Element> forwards = action.getChildren();
			for(Element forward : forwards) {
				String names = forward.getAttributeValue("name"); 
				String paths = forward.getAttributeValue("path");
				forwardMap.put(names, paths);
			}
			// 解析XML,完成了 action实体bean的属性装载;
			actionBean.setActionForward(forwardMap);
			// 每解析完一个action,则以path为key,actionBean为value;
			rMap.put(path, actionBean);
			
		}
		return rMap;		 
	}
	 
}
