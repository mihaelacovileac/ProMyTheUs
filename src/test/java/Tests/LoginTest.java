package Tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
private LoginPage loginPage;

@BeforeClass
public void BeforeTest(){
    loginPage = new LoginPage(driver);
}

@Test(priority = 1)
public void TestInvalidCredentials(){
    loginPage.setUserLogin("masha@yahoo.com");
    loginPage.setPasswordLogin("kisulea");
    loginPage.clickLoginButton();
    String error = loginPage.getWrongCredentialsMessage();
    Assert.assertEquals("Invalid Email or Password.",error);
}

    @Test(priority = 2)
    public void TestInvalidPassword(){
        loginPage.setUserLogin("buquxahu@cars2.club");
        loginPage.setPasswordLogin("kis12345");
        loginPage.clickLoginButton();
        String error = loginPage.getWrongCredentialsMessage();
        Assert.assertEquals("Invalid Email or Password.",error);
    }

    @Test(priority = 3)
    public void TestEmptyUserName(){
        loginPage.setUserLogin("");
        loginPage.setPasswordLogin("kis12345");
        loginPage.clickLoginButton();
        String error = loginPage.getEmailRequiredField();
        Assert.assertEquals("This value is required.",error);
    }

    @Test(priority = 4)
    public void TestEmptyPasswordField(){
        loginPage.setUserLogin("buquxahu@cars2.club");
        loginPage.setPasswordLogin("");
        loginPage.clickLoginButton();
        String error = loginPage.getPasswordRequiredField();
        Assert.assertEquals("This value is required.",error);
    }

    @Test(priority = 5)
    public void TestEmptyFields(){
        loginPage.setUserLogin("");
        loginPage.setPasswordLogin("");
        loginPage.clickLoginButton();
        String emptyPassword = loginPage.getPasswordRequiredField();
        Assert.assertEquals("This value is required.",emptyPassword);
        String emptyUsername = loginPage.getEmailRequiredField();
        Assert.assertEquals("This value is required.", emptyUsername);
    }
@Test(priority = 6)
public void TestPositive(){
    loginPage.setUserLogin("buquxahu@cars2.club");
    loginPage.setPasswordLogin("kisulea");
    loginPage.clickLoginButton();
    String userIcon = loginPage.getUserIconAttribut();
    Assert.assertEquals("icon-user",userIcon);

 }

}
