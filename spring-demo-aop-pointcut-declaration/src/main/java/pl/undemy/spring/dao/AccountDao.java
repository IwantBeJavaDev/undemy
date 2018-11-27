package pl.undemy.spring.dao;

import org.springframework.stereotype.Component;

import pl.undemy.spring.main.Account;

@Component
public class AccountDao {

	public void addAccount(Account account) {
		System.out.println(account.getName());
		System.out.println(account.getLevel());
		System.out.println(getClass() + ":DOING MY DB WORK: ADDING AN ACCOUNT");
	}
}
