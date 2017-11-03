package ExcelExport;

public class dataProviderMainMethodCall {
    public static void main(String[] args){
        Data_ProviderReadXL dp = new Data_ProviderReadXL();
        dp.dataProviderRead("projectInputData.xlsx", "loginInfo");
    }
}
