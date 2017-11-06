package ExcelAndData;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.naming.Name;
import java.util.Random;

public class DataProviders {

    @Test(dataProvider = "userData") public void fillUserForm(String userName, String passWord)
    {
        System.out.println("UserName: "+ userName);
        System.out.println("PassWord: "+ passWord);
        System.out.println("*********************");
    }
    @DataProvider(name="userData")
    public Object[][] userFormData() throws Exception
    {
        ExcelApiTest eat = new ExcelApiTest("projectInputData.xlsx");
        Object[][] data = eat.testData("loginInfo");
        return data;
    }

    @DataProvider(name = "passwordChange")
    public static Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"filllipa12345@yahoo.com","phillipa12345","phillipa"},
                {"filllipa12345@yahoo.com","phillipa","phillipa12345"}

        };
    }
    @DataProvider(name = "LoginWithBlankEmailAndPass_TestDataProvider")
    public static Object[][] getBlankEmailAndPass()
    {
        Object[][] data = new Object[1][2];
        data[0][0] = "";  //email
        data[0][1] = ""; //password
        return data;
    }
    @DataProvider(name = "newTalentTestDataInput")
    public static Object[][] newTalentData(){
        Object[][] data = new Object[1][25];
        data[0][0] = RandomStringUtils.randomAlphabetic(5).toLowerCase();//first name
        data[0][1] = RandomStringUtils.randomAlphabetic(2).toLowerCase();//middleName
        data[0][2] = RandomStringUtils.randomAlphabetic(6).toLowerCase();//lastName
        data[0][3] = "02241979";//dob
        data[0][4] = RandomStringUtils.randomAlphabetic(6).toLowerCase();//placeOfBirth
        data[0][5] = RandomStringUtils.randomNumeric(4)+RandomStringUtils.randomAlphabetic(7) + "St.";//address
        data[0][6] = RandomStringUtils.randomAlphabetic(7).toLowerCase() + "@getnada.com";//newEmail
        data[0][7] = RandomStringUtils.randomNumeric(3)+ RandomStringUtils.randomNumeric(3) + RandomStringUtils.randomNumeric(4); //phone
        data[0][8] = "facebook.com/" + RandomStringUtils.randomAlphabetic(6).toLowerCase(); //socialAccount
        data[0][9] = RandomStringUtils.randomNumeric(3); //height
        data[0][10] = RandomStringUtils.randomNumeric(2); //weight
        data[0][11] = RandomStringUtils.randomAlphabetic(10); //college
        data[0][12] = RandomStringUtils.randomAlphabetic(5); //successLevel
        data[0][13] = RandomStringUtils.randomAlphanumeric( 500); //evidence
        data[0][14] = RandomStringUtils.randomAlphanumeric( 255); //workProduct
        data[0][15] = RandomStringUtils.randomNumeric(6); //income
        data[0][16] = RandomStringUtils.randomAlphanumeric( 500); //headline
        data[0][17] = RandomStringUtils.randomNumeric(2); //years
        data[0][18] = RandomStringUtils.randomAlphabetic( 500); //gutFeel
        data[0][19] = RandomStringUtils.randomAlphabetic( 500); //rationale
        data[0][20] = RandomStringUtils.randomAlphabetic( 100); //score
        data[0][21] = RandomStringUtils.randomAlphabetic( 100); //rank
        data[0][22] = RandomStringUtils.randomNumeric( 1); //talentTrait1
        data[0][23] = RandomStringUtils.randomAlphabetic( 1); //talentTrait2
        data[0][24] = RandomStringUtils.randomAlphabetic( 1); //talentTrait3
        return data;
    }

}
