package pl.undemy.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

	public boolean addSilliMember() {
		System.out.println(getClass() + ":DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
		return false;
	}
}
