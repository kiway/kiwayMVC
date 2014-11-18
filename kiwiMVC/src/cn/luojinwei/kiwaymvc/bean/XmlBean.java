package cn.luojinwei.kiwaymvc.bean;

import java.util.HashMap;
import java.util.Map;

public class XmlBean {

	private String beanName = "";
	private String path = ""; 
	private String actionClass = "";
	private String formClass = "";
	private Map<String,String> actionForward = new HashMap<String,String>();
	/**
	 * @return the beanName
	 */
	public String getBeanName() {
		return beanName;
	}
	/**
	 * @param beanName the beanName to set
	 */
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the actionType
	 */
	 
	/**
	 * @return the actionClass
	 */
	public String getActionClass() {
		return actionClass;
	}
	/**
	 * @param actionClass the actionClass to set
	 */
	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}
	/**
	 * @return the formClass
	 */
	public String getFormClass() {
		return formClass;
	}
	/**
	 * @param formClass the formClass to set
	 */
	public void setFormClass(String formClass) {
		this.formClass = formClass;
	}
	/**
	 * @return the actionForward
	 */
	public Map<String, String> getActionForward() {
		return actionForward;
	}
	/**
	 * @param actionForward the actionForward to set
	 */
	public void setActionForward(Map<String, String> actionForward) {
		this.actionForward = actionForward;
	}
	
	
}
