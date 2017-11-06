package Tests;

import ExcelAndData.DataProviders;
import Pages.LoginPage;
import Pages.MyProfilePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ChangePasswordPozitive extends LoginBaseTest {
    private MyProfilePage myProfilePage;
    private LoginPage loginPage;
    @BeforeClass
    public void BeforeClass(){
        myProfilePage = new MyProfilePage(driver);
        loginPage =new LoginPage(driver);
    }
    @DataProvider(name = "passwordFromSameClass")
    public Object[][] getDataFromDataProvider1(){
        return new Object[][]{
                {"filllipa12345@yahoo.com","phillipa12345","phillipa"},
                {"filllipa12345@yahoo.com","phillipa","phillipa12345"}

        };
    }
    @Test(priority = 2,dataProvider = "passwordFromSameClass")
    public  void testChangePassword(String email, String password, String newPassword){
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

    }

    @Test(dataProviderClass = DataProviders.class,dataProvider= "passwordChange", enabled = false)
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

}
