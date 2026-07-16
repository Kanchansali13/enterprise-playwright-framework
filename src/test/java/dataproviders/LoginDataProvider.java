package dataproviders;

import com.kanchansali.utilities.ExcelUtils;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        ExcelUtils excel =
                new ExcelUtils(
                        "testdata/LoginData.xlsx",
                        "LoginData");

        int rows = excel.getRowCount();

        Object[][] data = new Object[rows][3];

        for (int i = 1; i <= rows; i++) {

            data[i - 1][0] = excel.getCellData(i, 0);

            data[i - 1][1] = excel.getCellData(i, 1);

            data[i - 1][2] = excel.getCellData(i, 2);

        }

        return data;

    }

}