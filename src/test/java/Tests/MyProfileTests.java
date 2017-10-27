package Tests;

import Pages.LoginPage;
import Pages.MyProfilePage;
import Pages.RegistrationPage;
import javafx.scene.control.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

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
        loginPage.setUserLogin(email);
        loginPage.setPasswordLogin(currentPassword);
        loginPage.clickLoginButton();
        loginPage.clickUserIcon();
        myProfilePage.clickMyProfileLink();
    }
    @Test(enabled = false)
    //Positive test case
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

        //need to fix the error.Is not saving password.Pop up window it's closing wihout clicking on ok button
        assertTrue(myProfilePage.getPopUpLogo().isDisplayed());
        //String message = myProfilePage.getPasswordChangeSuccessfully();
        //assertEquals(message, "Password changed successfully.");

    }
    @Test
    public void TeestWrongCurentPassword(){
        myProfilePage.clickChangePasswordLink();
        myProfilePage.setCurrentPassword("Masha");
        myProfilePage.setNewPassword(newPassword);
        myProfilePage.setConfirmNewPassword(confirmNewPassword);
        myProfilePage.clickUpdatePassword();
        String errorMessage = myProfilePage.getErrorCurrentPasswordWrong();
        assertEquals(errorMessage, "Current password is wrong.");
        // need to find why actual result is empty
    }
}
