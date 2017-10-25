package Tests;

import Pages.LoginPage;
import Pages.MyProfilePage;
import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private MyProfilePage myProfilePage;
    String password = "phillipa12345";
    String firstName = "Milla";
    String middleInitial ="I";
    String lastName ="SOM";
    String email = "filllipa12345@yahoo.com";
    String phone = "8798767876";
    String address ="123 Main St.";
    String city = "Tampa";
    String state = "Florida";
    String zip = "55555";
    @BeforeClass
    public void BeforeTest(){

        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        myProfilePage = new MyProfilePage(driver);

    }
    @Test(enabled = false)
    public void TestRegistrationNewUser(){

        registrationPage.clickRegisterBtn();
        registrationPage.userTypeCheckBox();
        registrationPage.setFirstName(firstName);
        registrationPage.setMiddleNameInitial(middleInitial);
        registrationPage.setLastName(lastName);
        registrationPage.setRegistrationEmail(email);
        registrationPage.setPhoneNumber(phone);
        registrationPage.setPassword(password);
        registrationPage.setRetypePassword(password);
        //set country
        registrationPage.clickCountryField();
        registrationPage.clickSelectedCountry();
        registrationPage.setAddress(address);
        registrationPage.setCity(city);
        registrationPage.setState(state);
        registrationPage.setTypeZipCode(zip);
        registrationPage.clickCreateAccount();

        String verification = registrationPage.getVerificationRegistration();
        Assert.assertEquals("",verification);
    }
    @Test(priority = 1)
    public  void TestNewAccountVerification(){
        loginPage.setUserLogin(email);
        loginPage.setPasswordLogin(password);
        loginPage.clickLoginButton();
        loginPage.clickUserIcon();
        myProfilePage.clickMyProfileLink();
        String country = registrationPage.getTextCountry();

        Assert.assertEquals("Albania", country);

    }

}
