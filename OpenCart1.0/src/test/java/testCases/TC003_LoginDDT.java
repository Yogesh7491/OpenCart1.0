package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = {"regression", "master"})
	public void loginDDT(String email, String pwd, String exp) {

		logger.info("*****TC003 LoginDDT Started*****");
		try {
			// HomePage
			HomePage hp = new HomePage(wd);
			hp.clickMyAccount();
			hp.clickLogin();

			// LoginPage
			LoginPage lp = new LoginPage(wd);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			MyAccountPage myac = new MyAccountPage(wd);
			boolean targetpage = myac.isMyAccounPagePresent();

			if (exp.equalsIgnoreCase("valid")) {
				if (targetpage == true) {
					myac.clickLogout();
					myac.clickContinue();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("invaild")) {
				if (targetpage == false) {
					Assert.assertTrue(true);
				} else {
					myac.clickLogout();
					myac.clickContinue();
					Assert.assertTrue(false);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
		}

		logger.info("***** TC003_LoginDDT Finished******");
	}

}
