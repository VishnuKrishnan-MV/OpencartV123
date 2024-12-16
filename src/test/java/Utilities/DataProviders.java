package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    // DataProvider 1
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {
        String path = "./testData/Opencart_LoginData.xlsx"; // taking xl file from testData

        ExcelUtility xlutil = new ExcelUtility(path); // creating an object for XLUtility

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        String loginData[][] = new String[totalrows][totalcols]; // created for two dimension array which can

        for (int i = 1; i <= totalrows; i++) { // read the data from xl storing in two dimensional array
            for (int j = 0; j < totalcols; j++) {
                loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // 1,0
            }
        }

        return loginData; // returning two dimension array
    }
}
