package com.mailRu.selenium.mailRuSelenium;

import java.util.Arrays;
import java.util.List;

import com.mailRu.selenium.mailRuSelenium.MailActor;

/**
 * Include simple mail login tests.
 */
public class SimpleMailLogin {

	private String login_name = "psusloparov_test";
	private String error_login_name = "error";
	private String domain_name = "@inbox.ru";
	private String pass_name = "PSUSLOPAROV1test";
	private String url = "http://www.mail.ru";
	private List<String> domains = Arrays.asList("@mail.ru", "@inbox.ru", "@list.ru", "@bk.ru");

	/**
	 * Positive scenario.
	 */
	public void SimpleMailLoginPositive(){
		MailActor mailActor = new MailActor();
        mailActor.GoToUrl(url);
        mailActor.CheckDomains(domains);
        mailActor.Login(login_name, domain_name, pass_name);
        mailActor.checkInsideMailSystem(true);
        mailActor.Logout();
        mailActor.checkOutsideMailSystem();
        mailActor.quit();
	}
	
	/**
	 * Negative scenario.
	 */
	public void SimpleMailLoginNegative(){    
		MailActor mailActor = new MailActor();
        mailActor.GoToUrl(url);
        mailActor.CheckDomains(domains);
        mailActor.Login(error_login_name, domain_name, pass_name);
        mailActor.checkInsideMailSystem(false);
        mailActor.quit();
	}
}