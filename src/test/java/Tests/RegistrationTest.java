package Tests;

import ExcelExport.ExcelApiTest;
import Pages.LoginPage;
import Pages.MyProfilePage;
import Pages.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private MyProfilePage myProfilePage;

    @BeforeClass
    public void BeforeTest(){

        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        myProfilePage = new MyProfilePage(driver);

    }
    @Test(enabled = true, dataProvider = "registrationInfo")
    public void TestRegistrationNewUser(String First, String Middle,String Last,String Email, String Phone,String country,
                                        String Address, String Apartment, String City, String State,
                                        String PostalCode, String password,String Retype) throws InterruptedException {
        String[] testData = {First,Middle,Last,Email,Phone,country,Address,Apartment,City,State,PostalCode};
        String[] resultTestData = new String[11];

        registrationPage.clickRegisterBtn();
        registrationPage.userTypeCheckBox();
        registrationPage.setFirstName(First);
        registrationPage.setMiddleNameInitial(Middle);
        registrationPage.setLastName(Last);
        registrationPage.setRegistrationEmail(Email);
        registrationPage.setPhoneNumber(Phone);
        registrationPage.clickCountryField();
        registrationPage.clickSelectedCountry(country);
        registrationPage.setAddress(Address);
        registrationPage.setAddressApartment(Apartment);
        registrationPage.setCity(City);
        registrationPage.setState(State);
        registrationPage.setTypeZipCode(PostalCode);
        registrationPage.setPassword(password);
        registrationPage.setRetypePassword(Retype);
        registrationPage.clickCreateAccount();
        String verification = registrationPage.getVerificationRegistration();
        Assert.assertEquals("",verification);
        loginPage.setUserLogin(Email);
        loginPage.setPasswordLogin(password);
        loginPage.clickLoginButton();
        loginPage.clickUserIcon();
        myProfilePage.clickMyProfileLink();

        //Assert That all fields contain data from excel used for registration
        resultTestData[0] = myProfilePage.getFirstName();
        resultTestData[1] = myProfilePage.getMiddleName();
        resultTestData[2] = myProfilePage.getLastName();
        resultTestData[3] = myProfilePage.getEmail();
        resultTestData[4] = myProfilePage.getPhone();
        Thread.sleep(4000);
        resultTestData[5] = myProfilePage.getCountry();
        Thread.sleep(3000);
        resultTestData[6] = myProfilePage.getAddress();
        resultTestData[7] = myProfilePage.getAddress2();
        resultTestData[8] = myProfilePage.getCity();
        resultTestData[9] = myProfilePage.getState();
        resultTestData[10] = myProfilePage.getZip();
        for(int i = 0; i<resultTestData.length; i++){
            System.out.println("This is what i expect: "+ testData[i]  + " and this is what i received: "+ resultTestData[i]);
            Assert.assertEquals(resultTestData[i], testData[i]);
        }
        loginPage.clickUserIcon();
        loginPage.clickSignOut();
        System.out.println("******************");



    }
    @Test(enabled = false, dataProvider = "verifyRegistration")
    public  void TestNewAccountVerification(String email,String pass, String country){
        loginPage.setUserLogin(email);
        loginPage.setPasswordLogin(pass);
        loginPage.clickLoginButton();
        loginPage.clickUserIcon();
        myProfilePage.clickMyProfileLink();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ui-select-match-text pull-left']")));
        String actualCountry = driver.findElement(By.xpath("//span[@class='ui-select-match-text pull-left']")).getText();
        Assert.assertEquals(actualCountry, country);
        loginPage.clickUserIcon();
        loginPage.clickSignOut();


    }
    @DataProvider(name = "verifyRegistration")
    public Object[][] userFormatData1()throws Exception{
        Object[][] data = testData("projectInputData.xlsx","verifyRegistration");
        return data;
    }

    String xlFilePath = "projectInputData.xlsx";
    String sheetName = "registrationInfo";
    ExcelApiTest eat = null;
    @DataProvider(name = "registrationInfo")
    public Object[][] userFormatData()throws Exception{
        Object[][] data = testData(xlFilePath,sheetName);
        return data;
    }
    public Object[][] testData(String xlFilePath, String sheetName) throws Exception{
        Object[][] excelData = null;
        eat = new ExcelApiTest(xlFilePath);
        int rows =eat.getRowCount(sheetName);
        int columns = eat.getColumnCount(sheetName);
        excelData = new Object[rows-1][columns];
        for(int i=1;i<rows; i++){
            for(int j=0; j<columns; j++){
                excelData[i-1][j]=eat.getCellData(sheetName, j, i);
            }
        }
        return excelData;
    }

}
