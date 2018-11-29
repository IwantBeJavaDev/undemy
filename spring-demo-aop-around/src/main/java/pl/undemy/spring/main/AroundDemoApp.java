package pl.undemy.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.undemy.spring.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		// read spring config java class
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
			
				TrafficFortuneService trafficFortuneService = context.getBean(TrafficFortuneService.class);
				
				System.out.println("\nMain program: AroundDemoApp");
				
				System.out.println("Calling getFortune");
				
				String fortune = trafficFortuneService.getFortune();
				System.out.println("\nMy fortune is: " + fortune);
				
				context.close();
	}

}
