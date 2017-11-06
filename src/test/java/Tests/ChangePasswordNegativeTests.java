package Tests;

import ExcelAndData.ExcelApiTest;
import Pages.LoginPage;
import Pages.MyProfilePage;
import Pages.RegistrationPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class ChangePasswordNegativeTests extends BaseTest {
    private MyProfilePage myProfilePage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    String loginPassword= "phillipa12345";
    String email ="filllipa12345@yahoo.com";
    @BeforeClass
    public void BeforeClass1(){
        myProfilePage = new MyProfilePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);

    }

    @Test(dataProvider = "changePasswordNegative", enabled = false)
    public  void TestChangePasswordErrorMessages(String currentPassword, String newPassword, String confirmNewPassword, String errorMessage){
        loginPage.setUserLogin(email);
        loginPage.setPasswordLogin(loginPassword);
        loginPage.clickLoginButton();
        loginPage.clickUserIcon();
        myProfilePage.clickMyProfileLink();
        myProfilePage.clickChangePasswordLink();
        myProfilePage.setCurrentPassword(currentPassword);
        myProfilePage.setNewPassword(newPassword);
        myProfilePage.setConfirmNewPassword(confirmNewPassword);
        myProfilePage.clickUpdatePassword();

        //assert that user get right error message
        //All error message available for change password field functionality

        //Need to fix and put all code inside pages and leave only methods here
        if(driver.findElement(By.xpath("//span[contains(.,'The passwords do not match.')]")).isDisplayed()){
            String message1= myProfilePage.getErrorPasswordNotMatch();
            System.out.println(message1 +", CurrentPassword: "+ currentPassword+ ", NewPassword: "+newPassword + ", ConfirmNewPassword: "+confirmNewPassword);
            Assert.assertEquals(message1,errorMessage);
        }
        else if (driver.findElement(By.xpath("//span[contains(.,'This value is too long. It should have 255 characters or fewer.')]")).isDisplayed()){
            String message2= myProfilePage.getErrorValueIsToLong();
            System.out.println(message2+", CurrentPassword: "+ currentPassword+ ", NewPassword: "+newPassword + ", ConfirmNewPassword: "+confirmNewPassword);
            Assert.assertEquals(message2,errorMessage);
        }
        else if (driver.findElement(By.xpath("//span[contains(.,'Current password is wrong.')]")).isDisplayed()){
            String message3= myProfilePage.getErrorCurrentPasswordWrong();
            System.out.println(message3+", CurrentPassword: "+ currentPassword+ ", NewPassword: "+newPassword + ", ConfirmNewPassword: "+confirmNewPassword);
            Assert.assertEquals(message3, errorMessage);
        }
        else if(driver.findElement(By.xpath("//span[contains(.,'This value is too short. It should have 6 characters or more.')]")).isDisplayed()) {
            String message4= myProfilePage.getErrorValueIsToShort();
            System.out.println(message4+", CurrentPassword: "+ currentPassword+ ", NewPassword: "+newPassword + ", ConfirmNewPassword: "+confirmNewPassword);
            Assert.assertEquals(message4, errorMessage);
        }
        else {
            String message5= myProfilePage.getErrorTextRequiredField();
            System.out.println(message5+", CurrentPassword: "+ currentPassword+ ", NewPassword: "+newPassword + ", ConfirmNewPassword: "+confirmNewPassword);
            Assert.assertEquals(message5, errorMessage);
        }

        //If any pop-up windows are displayed need to be closed
        try {
            if (driver.findElement(By.xpath("//div[@class='sweet-alert showSweetAlert visible']")).isDisplayed()) {
                String popUpText = driver.findElement(By.xpath("//p[@style='display: block;']")).getText();
                System.out.println("PopUp window was displayed: " + popUpText);
                driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
            }
        }catch (Exception e){
            System.out.println("PopUp window is not displayed");
        }
        loginPage.clickUserIcon();
        loginPage.clickSignOut();

    }

    @Test
    public void TestEmptyFields(){
        loginPage.setUserLogin(email);
        loginPage.setPasswordLogin(loginPassword);
        loginPage.clickLoginButton();
        loginPage.clickUserIcon();
        myProfilePage.clickMyProfileLink();
        myProfilePage.clickChangePasswordLink();
        myProfilePage.setCurrentPassword("");
        myProfilePage.setNewPassword("");
        myProfilePage.setConfirmNewPassword("");
        myProfilePage.clickUpdatePassword();
        //Assert that all fields have error message
        String messageEmpty= myProfilePage.getErrorTextRequiredField();
        Assert.assertEquals(messageEmpty, "This value is required.");
        //need to fix how to check 3 assertion for each field if are displayed error messages
    }
    //code below is for data provider from excel file


    @DataProvider(name = "userPass")
    public Object[][] userFormatData()throws Exception{
        ExcelApiTest eat = new ExcelApiTest("projectInputData.xlsx");
        Object[][] data = eat.testData("userPass");
        return data;
    }
    @DataProvider(name = "changePasswordNegative")
    public Object[][] userFormatData2()throws Exception{
        ExcelApiTest eat = new ExcelApiTest("projectInputData.xlsx");
        Object[][] data = eat.testData("changePasswordNegative");
        return data;
    }

}
