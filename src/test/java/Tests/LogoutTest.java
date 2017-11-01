package Tests;

import ExcelExport.ExcelApiTest;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
    private LoginPage loginPage;

    @BeforeClass
    public void BeforeTest(){

        loginPage = new LoginPage(driver);
    }
    @Test(dataProvider = "userData")
    public void TestLogOut(String userName, String passWord){
        loginPage.setUserLogin(userName);
        loginPage.setPasswordLogin(passWord);
        loginPage.clickLoginButton();
        loginPage.clickUserIcon();
        loginPage.clickSignOut();

        String message = "Back to LogIn Page";
        Assert.assertTrue(loginPage.getLoginText().isDisplayed(),message);
    }
    String xlFilePath = "projectInputData.xlsx";
    String sheetName = "loginInfo";
    ExcelApiTest eat = null;
    @DataProvider(name = "userData")
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

//    @DataProvider(name = "excelFile")
//    public Object[][] getData(){
//        Data_ProviderReadXL data = new Data_ProviderReadXL();
//        Object[][] arraylist = data.dataProviderRead("projectInputData.xlsx", "Sheet1");
//        return arraylist;
//    }
}

