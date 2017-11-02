package Tests;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginBaseTest extends BaseTest {
    private LoginPage loginPage;
    @BeforeClass
    public void loginBeforeClass(){

        loginPage = new LoginPage(driver);
    }
    @Test(priority = 1)
    public void testLogin(){
        loginPage.setUserLogin("filllipa12345@yahoo.com");
        loginPage.setPasswordLogin("phillipa12345");
        loginPage.clickLoginButton();
        String userIcon = loginPage.getUserIconAttribut();
        Assert.assertEquals("icon-user",userIcon);
    }
}
