package Tests;

import Pages.LoginPage;
import Pages.MyProfilePage;
import Pages.RegistrationPage;
import Parameters.DataProviderClass;
import javafx.scene.control.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class ChangePasswordNegativeTests extends BaseTest {
    private MyProfilePage myProfilePage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    String currentPassword= "kisulea12345";
    String newPassword = "kisulea";
    String confirmNewPassword ="kisulea";
    String email ="buquxahu@cars2.club";
    @BeforeClass
    public void BeforeTest(){
        myProfilePage = new MyProfilePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);

    }
    @Test(dataProviderClass = DataProviderClass.class,dataProvider= "passwordChange")
    public void TestChangePassword(String email, String password, String newPassword) throws InterruptedException{
        loginPage.setUserLogin(email);
        loginPage.setPasswordLogin(password);
        loginPage.clickLoginButton();
        loginPage.clickUserIcon();
        myProfilePage.clickMyProfileLink();
        myProfilePage.clickChangePasswordLink();
        myProfilePage.setCurrentPassword(password);
        myProfilePage.setNewPassword(newPassword);
        myProfilePage.setConfirmNewPassword(newPassword);
        myProfilePage.clickUpdatePassword();
        String message= myProfilePage.getPasswordChangeSuccessfully();
        assertEquals(message, "Password changed successfully.");
        myProfilePage.clickOkBtn();
        loginPage.clickUserIcon();
        loginPage.clickSignOut();
        loginPage.setUserLogin(email);
        try {
            loginPage.setPasswordLogin(newPassword);
        }
        catch (Exception e){
            loginPage.setPasswordLogin(password);
        }
        loginPage.clickLoginButton();
        loginPage.clickUserIcon();
        loginPage.clickSignOut();


    }
    @Test(enabled = false)
    public void TeestWrongCurentPassword(){
        loginPage.setUserLogin(email);
        loginPage.setPasswordLogin(currentPassword);
        loginPage.clickLoginButton();
        loginPage.clickUserIcon();
        myProfilePage.clickMyProfileLink();
        myProfilePage.clickChangePasswordLink();
        myProfilePage.setCurrentPassword("Masha");
        myProfilePage.setNewPassword(newPassword);
        myProfilePage.setConfirmNewPassword(confirmNewPassword);
        myProfilePage.clickUpdatePassword();
        String errorMessage = myProfilePage.getErrorCurrentPasswordWrong();
        assertEquals(errorMessage, "Current password is wrong.");
    }
}
