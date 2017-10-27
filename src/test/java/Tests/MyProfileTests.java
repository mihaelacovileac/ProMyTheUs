package Tests;

import Pages.LoginPage;
import Pages.MyProfilePage;
import Pages.RegistrationPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyProfileTests extends BaseTest {
    private MyProfilePage myProfilePage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    String currentPassword= "kisulea";
    String newPassword = "kisulea12345";
    String confirmNewPassword ="kisulea12345";
    String email ="buquxahu@cars2.club";
    @BeforeClass
    public void BeforeTest(){
        myProfilePage = new MyProfilePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }
    @Test
    public void TestChangePassword(){
        loginPage.setUserLogin(email);
        loginPage.setPasswordLogin(currentPassword);
        loginPage.clickLoginButton();
        loginPage.clickUserIcon();
        myProfilePage.clickMyProfileLink();
        myProfilePage.clickChangePasswordLink();
        myProfilePage.setCurrentPassword(currentPassword);
        myProfilePage.setNewPassword(newPassword);
        myProfilePage.setConfirmNewPassword(confirmNewPassword);
        myProfilePage.clickUpdatePassword();
    }
}
