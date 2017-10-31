package Tests;

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
    @Test(priority = 2,dataProvider = "passwordChange")
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
       // loginPage.clickUserIcon();
        //loginPage.clickSignOut();

    }
    @DataProvider(name = "passwordChange")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"buquxahu@cars2.club","kisulea","kisulea"},
                {"buquxahu@cars2.club","kisulea","kisulea"}

        };
    }

}
