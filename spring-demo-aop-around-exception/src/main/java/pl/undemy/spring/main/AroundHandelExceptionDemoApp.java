package pl.undemy.spring.main;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.undemy.spring.service.TrafficFortuneService;

public class AroundHandelExceptionDemoApp {

	private static Logger log = Logger.getLogger(AroundHandelExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
		// read spring config java class
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
			
				TrafficFortuneService trafficFortuneService = context.getBean(TrafficFortuneService.class);
				
				log.info("\nMain program: AroundHandelExceptionDemoApp");
				
				log.info("Calling getFortune");
				
				boolean tripWire = true;
				String fortune = trafficFortuneService.getFortune(tripWire);
				log.info("\nMy fortune is: " + fortune);
				
				context.close();
	}

}
