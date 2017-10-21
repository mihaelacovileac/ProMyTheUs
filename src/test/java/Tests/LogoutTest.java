package Tests;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    private LoginPage loginPage;
    @BeforeClass
    public void BeforeTest(){

        loginPage = new LoginPage(driver);
    }
    @Test
    public void TestLogOut(){
        loginPage.setUserLogin("buquxahu@cars2.club");
        loginPage.setPasswordLogin("kisulea");
        loginPage.clickLoginButton();
        loginPage.clickUserIcon();
        loginPage.clickSignOut();

        String message = "Back to LogIn Page";
        Assert.assertTrue(loginPage.getLoginText().isDisplayed(),message);


    }
}

