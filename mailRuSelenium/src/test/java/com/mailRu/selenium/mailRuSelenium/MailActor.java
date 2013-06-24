package com.mailRu.selenium.mailRuSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * Class includes interaction functionality with mail.ru web site.
 * Actions are methods name.
 */
public class MailActor {
	//ToDo: Need to cover each method in expectation time of execution.

	private WebDriver driver;

	MailActor(){
		driver = new FirefoxDriver();
	}
	
	/**
	 * Open browser on page. 
	 * 
	 * @param url Url for opening.
	 */
	public void GoToUrl(String url){
		driver.get(url);
	}
	
	/**
	 * Login to mail.ru system. 
	 * 
	 * @param login_name  Login without domain.
	 * @param domain_name  Domain name.
	 * @param pass_name  Password.
	 */
	public void Login(String login_name, String domain_name, String pass_name) {
		// Enter the login string login_name
        WebElement login = driver.findElement(By.id("mailbox__login"));
        login.sendKeys(login_name);
        
        Select droplist = new Select(driver.findElement(By.id("mailbox__login__domain")));

        // Choose domain from drop down list
        droplist.selectByVisibleText(domain_name);
        
        // Enter the password string pass_name
        WebElement pass = driver.findElement(By.id("mailbox__password"));
        pass.sendKeys(pass_name);

        // Click on login button
        WebElement login_button = driver.findElement(By.id("mailbox__auth__button"));
        login_button.click();
        
        //Wait 3 seconds for page loading.
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	/**
	 * Check domains. It has to compare with included domains list. 
	 * 
	 * @param domains  List of domain, which have to be in dropdown box.
	 */
	public void CheckDomains(List<String> domains){
		Select droplist = new Select(driver.findElement(By.id("mailbox__login__domain")));
        // Check domains from domains list.
        int current_len = 1;
        int comparator = 1;
        List<WebElement> domain_dropdown = droplist.getOptions();
        while (current_len < domains.size()) {
        	for (int domains_index = 1; domains_index <= domain_dropdown.size(); domains_index++){
        		if (domains.get(domains_index).equals(domain_dropdown.get(current_len).getText())){
        			comparator++;
        			break;
        		}
        	}
        	current_len++;
        }
        Assert.assertEquals(comparator, domain_dropdown.size());
	}

	/**
	 * Check that we login to the mail system.domains.
	 * 
	 * @param equal. Show our expectation. Do we need login in system or not.
	 */
	public void checkInsideMailSystem(Boolean equal){
		try{
			WebElement new_letter_button = driver.findElement(By.id("HeaderBtnSentMsg"));
			Assert.assertNotNull(new_letter_button);
		}
		catch (org.openqa.selenium.NoSuchElementException e){
			if (equal){
				throw e;
			}
		}
	}
	
	/**
	 * Check that we logout from the mail system.domains.
	 * Focus should be on the main http://mail.ru page.
	 */
	public void checkOutsideMailSystem(){
		WebElement search = driver.findElement(By.id("q"));
		search.getAttribute("q");
	}
	
	/**
	 * Logout from mail.ru system.
	 */
	public void Logout(){
		WebElement logout_button = driver.findElement(By.id("PH_logoutLink"));
		logout_button.click();
	}
	
	/**
	 * Close browser.
	 */
	public void quit(){
		driver.quit();
	}
}
