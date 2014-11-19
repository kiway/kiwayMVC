/**
 * Title: LoginAction.java
 * Description: 
 * Copyright: Copyright (c) 2014
 * @author kiway
 * @date 2014Äê11ÔÂ19ÈÕ
 * @version 1.0
 */
package business;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.luojinwei.kiwaymvc.bean.ActionForm;
import cn.luojinwei.kiwaymvc.core.Action;


public class LoginAction implements Action{

	 
	public String execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm form,
			Map<String, String> actionForward) {
		LoginForm loginForm = (LoginForm)form;
		String name = loginForm.getName();
		String flag = "failuer";
		if("hello".equals(name)){
			flag = "success";
		}
				
		return actionForward.get(flag);
	}
	
}
