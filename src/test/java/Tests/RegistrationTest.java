package Tests;

import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{
    private RegistrationPage registrationPage;

    @BeforeClass
    public void BeforeTest(){
        registrationPage = new RegistrationPage(driver);
    }
    @Test
    public void TestRegistrationNewUser(){
        String password = "milla12345";
        registrationPage.clickRegisterBtn();
        registrationPage.userTypeCheckBox();
        registrationPage.setFirstName("Milla");
        registrationPage.setMiddleNameInitial("I");
        registrationPage.setLastName("SOM");
        registrationPage.setRegistrationEmail("mijhlllahhgfsdggd@yahoo.com");
        registrationPage.setPhoneNumber("8798767876");
        registrationPage.setPassword(password);
        registrationPage.setRetypePassword(password);
        //set country
        registrationPage.clickCountryField();
        registrationPage.clickSelectedCountry();
        registrationPage.setAddress("123 Main St.");
        registrationPage.setCity("Tampa");
        registrationPage.setState("Florida");
        registrationPage.setTypeZipCode("55555");
        registrationPage.clickCreateAccount();

        String verification = registrationPage.getVerificationRegistration();
        Assert.assertEquals("",verification);
    }
}
