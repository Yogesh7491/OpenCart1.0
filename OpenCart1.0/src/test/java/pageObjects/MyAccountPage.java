package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver wd) {
		super(wd);

	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")  // MyAccount header 
	WebElement msgMyaccountHeader;
	
	@FindBy(linkText  = "Logout")		//Logout button
	WebElement btnlogout;
	
	@FindBy(xpath = "//a[normalize-space()='Continue']")	//COntinue button
	WebElement btnContinue;

	public boolean isMyAccounPagePresent() {
		try {
			return (msgMyaccountHeader.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	public void clickLogout()
	{
		btnlogout.click();
	}
	public void clickContinue()
	{
		btnContinue.click();
	}
}
