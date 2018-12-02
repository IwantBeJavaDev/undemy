package pl.undemy.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import pl.undemy.spring.main.Account;

@Component
public class AccountDao {

	private  Logger log = Logger.getLogger(getClass().getName());
	private String name;
	private String serviceCode;

	public void addAccount(Account account) {
		log.info(account.getName());
		log.info(account.getLevel());
		log.info(getClass() + ":DOING MY DB WORK: ADDING AN ACCOUNT");
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
		log.info(getClass() + ": getName");
		return name;
	}

	public void setName(String name) {
		log.info(getClass() + ": setName");
		this.name = name;
	}

	public String getServiceCode() {
		log.info(getClass() + ": getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		log.info(getClass() + ": setServiceCode");
		this.serviceCode = serviceCode;
	}
}
