/**
* Positive scenario test case.
*
* Action                                        Expected result
* 1. Open browser. GoTo to http://mail.ru       1. Browser is opened on http://mail.ru.
* 2. Check list of domains.                     2. List of domains is equal to expected.
* 3. Login to mail service using form           3. Fields are filled correctly.
* 	 on the main page http://mail.ru               Get access to web mail service. Check it.
* 4. Logout from web mail service.              4. Main page http://mail.ru is opened. Check it.
* 5. Close browser.                             5. Browser is closed.									
**/

/**
* Negative scenario test case.
*
* Action                                        Expected result
* 1. GoTo to http://mail.ru                     1. Browser is opened on http://mail.ru.
* 2. Login to mail service using form           2. Fields are filled correctly.
* 	 on the main page http://mail.ru               Redirect to login page with error. Check, that we are not login in.
* 3. Logout from web mail service.              3. Main page http://mail.ru is opened. Check it.
* 4. Close browser.                             4. Browser is closed.							
**/

package com.mailRu.selenium.mailRuSelenium;

import java.util.Arrays;
import java.util.List;

import com.mailRu.selenium.mailRuSelenium.MailActor;

/**
 * Include simple mail login tests.
 */
public class SimpleMailLogin {
	//ToDo: Need to cover each method in expectation time of execution.

	private String login_name = "psusloparov_test";w
	private String error_login_name = "error";
	private String domain_name = "@inbox.ru";
	private String pass_name = "PSUSLOPAROV1test";
	private String url = "http://www.mail.ru";
	private List<String> domains = Arrays.asList("@mail.ru", "@inbox.ru", "@list.ru", "@bk.ru");

	/**
	 * Positive scenario.
	 * 
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