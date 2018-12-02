package pl.undemy.spring.dao;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
	private  Logger log = Logger.getLogger(getClass().getName());
	public boolean addSilliMember() {
		log.info(getClass() + ":DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
		return true;
	}
	
	public void goToSleep() {
		log.info("I'm  going to sleep now");
	}
}
