package Tests;

import Pages.CategoryPage;
import Pages.LoginPage;
import Pages.TalentsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TalentsPageTest extends LoginBaseTest {
    //private LoginPage loginPage;
    private TalentsPage talentsPage;
    private CategoryPage categoryPage;

    @BeforeClass
    public void BeforeClass() {
       // loginPage = new LoginPage(driver);
        talentsPage = new TalentsPage(driver);
        categoryPage = new CategoryPage(driver);

    }
//Have to write all pages first
    @Test(priority = 2)
    public void testCategorySelect()  {
        talentsPage.clickButtonNew();
        categoryPage.clickEnterCategory("Music");
        //categoryPage.clickSelectedCategory("Math");
    }
}
