package Tests;

import ExcelExport.ExcelApiTest;
import Pages.LoginPage;
import Pages.MyProfilePage;
import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private MyProfilePage myProfilePage;
      String pass = "phillipa12345";
      String email = "filllipa12345@yahoo.com";

    @BeforeClass
    public void BeforeTest(){

        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        myProfilePage = new MyProfilePage(driver);

    }
    @Test(dataProvider = "registrationInfo")
    public void TestRegistrationNewUser(String First, String Middle,String Last,String Email, String Phone,
                                        String Address, String Apartment, String City, String State,
                                        String PostalCode, String password,String Retype){

        registrationPage.clickRegisterBtn();
        registrationPage.userTypeCheckBox();
        registrationPage.setFirstName(First);
        registrationPage.setMiddleNameInitial(Middle);
        registrationPage.setLastName(Last);
        registrationPage.setRegistrationEmail(Email);
        registrationPage.setPhoneNumber(Phone);
        //set country
        registrationPage.clickCountryField();
        registrationPage.clickSelectedCountry();
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
    }
    @Test(enabled = false)
    public  void TestNewAccountVerification(){
        loginPage.setUserLogin(email);
        loginPage.setPasswordLogin(pass);
        loginPage.clickLoginButton();
        loginPage.clickUserIcon();
        myProfilePage.clickMyProfileLink();
        String country = registrationPage.getTextCountry();

        Assert.assertEquals("Albania", country);

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
