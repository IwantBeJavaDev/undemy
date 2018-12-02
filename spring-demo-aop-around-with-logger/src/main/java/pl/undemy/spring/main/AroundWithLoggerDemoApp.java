package pl.undemy.spring.main;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.undemy.spring.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger log = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		// read spring config java class
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
			
				TrafficFortuneService trafficFortuneService = context.getBean(TrafficFortuneService.class);
				
				log.info("\nMain program: AroundDemoApp");
				
				log.info("Calling getFortune");
				
				String fortune = trafficFortuneService.getFortune();
				log.info("\nMy fortune is: " + fortune);
				
				context.close();
	}

}
