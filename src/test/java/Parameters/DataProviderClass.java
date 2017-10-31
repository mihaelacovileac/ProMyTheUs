package Parameters;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name = "passwordChange")
    public static Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"buquxahu@cars2.club","kisulea","kisulea"},
                {"buquxahu@cars2.club","kisulea","kisulea"}

        };
    }
}
