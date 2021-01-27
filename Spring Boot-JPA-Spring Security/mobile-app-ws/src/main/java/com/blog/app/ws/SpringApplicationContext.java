package com.blog.app.ws;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContext implements ApplicationContextAware{
	
	private static ApplicationContext CONTEXT;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		CONTEXT = applicationContext;
	}
	
	// bean이름을 넘기면 이름이 같은 bean을 가져옴
	public static Object getBean(String beanName) {
		return CONTEXT.getBean(beanName);
	}

}
