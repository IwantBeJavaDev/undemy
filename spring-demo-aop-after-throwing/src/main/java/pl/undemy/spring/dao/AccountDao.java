package pl.undemy.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.undemy.spring.main.Account;

@Component
public class AccountDao {

	private String name;
	private String serviceCode;

	public void addAccount(Account account) {
		System.out.println(account.getName());
		System.out.println(account.getLevel());
		System.out.println(getClass() + ":DOING MY DB WORK: ADDING AN ACCOUNT");
	}

	public List<Account> findAccounts(boolean tripWire) {
		
		if (tripWire) {
			throw new RuntimeException("No soup for you");
		}
		
		
		List<Account> accountList = new ArrayList<>();
		accountList.add(new Account("Michal", "1"));
		accountList.add(new Account("Baraniak", "2"));
		accountList.add(new Account("Krzysztof", "3"));
		return accountList;
	}

	public String getName() {
		System.out.println(getClass() + ": getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode");
		this.serviceCode = serviceCode;
	}
}
