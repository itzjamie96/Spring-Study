package test02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Walk walk = ctx.getBean("walk",Walk.class);
		walk.move();
		ctx.close();

	}

}
