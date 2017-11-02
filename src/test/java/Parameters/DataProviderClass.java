package Parameters;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "passwordChange")
    public static Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"filllipa12345@yahoo.com","phillipa12345","phillipa"},
                {"filllipa12345@yahoo.com","phillipa","phillipa12345"}

        };
    }
}
