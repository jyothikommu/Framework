package framework.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FBHomeObjects {

	//find the objects
	//find the login email
	//FindBy()//to identify the objects twi methods prpoperty name and value
			//identify email
			@FindBy(id = "email")
			WebElement loginEmail;
			@FindBy(how = How.NAME, using = "pass") 
			//identify password
			WebElement loginPassword;
			//identify ok button
			@FindBy(how = How.XPATH, using = "//button[@name='login']")
			WebElement okButton;
			//identify create ac
			@FindBy(how = How.LINK_TEXT, using = "Create new account")
			WebElement createAc;
			
			//define webdriver
			WebDriver driver= null;
			
			//develop constructor
			public FBHomeObjects(WebDriver driver) {
				this.driver=driver;
			PageFactory.initElements( driver, this);	
			
				
			}
			//define object methods
			//enter login email
			public void enteLoginMail(String email) {
				loginEmail.sendKeys("jyothiflkfl");
			}
			
			//enter password
			public void enetrPassword(String password) {
				loginPassword.sendKeys("hsakhdksdhk");
			}
			//
			public void okbutton()
			{
				okButton.click();
			}
			public void createAc()
			{
				createAc.click();
			}
			//login testscript
			public void testScript(String email, String password)
			{
				enteLoginMail(email);
				enetrPassword(password);
				okbutton();
				createAc();
		
			}
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
}


