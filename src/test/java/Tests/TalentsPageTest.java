package Tests;

import Pages.CategoryPage;
import Pages.TalentsDashboardPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TalentsPageTest extends LoginBaseTest {
    //private LoginPage loginPage;
    private TalentsDashboardPage talentsDashboardPage;
    private CategoryPage categoryPage;

    @BeforeClass
    public void BeforeClass() {
       // loginPage = new LoginPage(driver);
        talentsDashboardPage = new TalentsDashboardPage(driver);
        categoryPage = new CategoryPage(driver);

    }
//Have to write all pages first
    @Test(priority = 2)
    public void testCategorySelect()  {
        talentsDashboardPage.clickButtonNew();
        categoryPage.clickEnterCategory();
        categoryPage.clickSelectedCategory();
        //categoryPage.clickSelectedCategory("Math");
    }
}
