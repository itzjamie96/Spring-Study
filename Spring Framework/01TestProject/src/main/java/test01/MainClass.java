package test01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
//		TransportationWalk walk = new TransportationWalk();
//		walk.move();
		
		//기존: 클래스 만들고 new이용해서 생성자 호출 , 메모리에 로딩 후 레퍼런스 이용해 메소드 호출
		//스프링: xml로 객체 생성 - 컨테이너에서 생성된 객체에 접근
		//generic~ 안에 리소스 자원을 적어줌
		
		//스프링 컨테이너 접근
		//컨테이너 접근을 위한 데이터 타입
		//getBean("id", class type)
		//자원 반납 필요
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TransportationWalk walk = ctx.getBean("tWalk",TransportationWalk.class);
		walk.move();
		
		ctx.close();
	}

}
