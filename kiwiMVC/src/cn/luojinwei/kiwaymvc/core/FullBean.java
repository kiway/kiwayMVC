package cn.luojinwei.kiwaymvc.core;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

import cn.luojinwei.kiwaymvc.bean.ActionForm;

public class FullBean {

	public static ActionForm full(HttpServletRequest request,String formClass) 
			 {
		ActionForm form = null;
		try {
			Class clazz = Class.forName(formClass);
			form = (ActionForm) clazz.newInstance();
			Field[] fieldArr = clazz.getDeclaredFields();
			for(Field field : fieldArr) {
				field.setAccessible(true);
				field.set(form, request.getParameter(field.getName()));
				field.setAccessible(false);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return form;
	}
}
