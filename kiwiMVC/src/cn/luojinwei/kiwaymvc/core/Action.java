package cn.luojinwei.kiwaymvc.core;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.luojinwei.kiwaymvc.bean.ActionForm;

public interface Action {
	public String execute(HttpServletRequest request, HttpServletResponse response, 
			ActionForm form, Map<String,String> actionForward);
}
