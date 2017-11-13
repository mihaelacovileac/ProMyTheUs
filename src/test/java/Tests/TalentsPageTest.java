package Tests;

import ExcelAndData.DataProviders;
import Pages.CategoryPage;
import Pages.NewTalentsPage;
import Pages.TalentsDashboardPage;
import Pages.TalentsMenuLinks;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class TalentsPageTest extends LoginBaseTest {
    //private LoginPage loginPage;
    private TalentsDashboardPage talentsDashboardPage;
    private CategoryPage categoryPage;
    private TalentsMenuLinks talentsMenuLinks;
    private NewTalentsPage newTalentsPage;

    @BeforeClass
    public void BeforeClass() {
       // loginPage = new LoginPage(driver);
        talentsDashboardPage = new TalentsDashboardPage(driver);
        categoryPage = new CategoryPage(driver);
        talentsMenuLinks = new TalentsMenuLinks(driver);
        newTalentsPage = new NewTalentsPage(driver);

    }
//Have to write all pages first
    @Test(priority = 2, dataProvider = "newTalentTestDataInput", dataProviderClass = DataProviders.class)
    public void testCategorySelect(String firs, String middle,String last,String dob, String placeofBirth,
    String address, String city, String state, String zip,String email,String phone, String social,String facebookAccount,
                                   String height,String weight) throws InterruptedException {
        talentsDashboardPage.clickButtonNew();
        //select category
        categoryPage.clickEnterCategory();
        categoryPage.clickSelectedCategory();
        Thread.sleep(1000);
        categoryPage.clickNextBtn();
        //personal info page
        //talentsMenuLinks.clickPersonalLink(); //don't need to click on menu link.Next button moves to personal page
        newTalentsPage.setFirstNameField(firs);
        newTalentsPage.setMiddleName(middle);
        newTalentsPage.setLastName(last);
        newTalentsPage.setDOB(dob);
        newTalentsPage.setPlaceOfBirth(placeofBirth);
        newTalentsPage.setAddress(address);
        newTalentsPage.setcityField(city);
        newTalentsPage.setStateField(state);
        newTalentsPage.setzipField(zip);
        newTalentsPage.chooseLocation();
        newTalentsPage.selectPrivileged();
        newTalentsPage.setTalentEmail(email);
        newTalentsPage.setPhone(phone);
        newTalentsPage.addSocialAccount();
        newTalentsPage.selectSocial(social);
        newTalentsPage.setFacebookAccount(facebookAccount);
        newTalentsPage.setHeight(height);
        newTalentsPage.setWeight(weight);
        //next btn
        categoryPage.clickNextBtn();
        //talent traits page
        int[] numbers = new int[20];
        //Generates 10 Random Numbers in the range 1 - 10
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 10 + 1);
        }
//        System.out.print(Arrays.toString(numbers));

        // insert random numbers to scales
        List<WebElement> rows = newTalentsPage.getNrOfRowsInputFields();
        Iterator<WebElement> itr = rows.iterator();
        int i = 0;
        while(itr.hasNext()) {
            itr.next().sendKeys(Integer.toString(numbers[i]));
            i++;

        }
        categoryPage.clickNextBtn();

        //Have to continue next pages before assertion

    }
}
