package dataproviders;

import org.testng.annotations.DataProvider;

public class UserDataProvider {

        @DataProvider(name = "userData")
        public Object[][] getUsers() {

            return new Object[][]{

                    {"Kanchan", "SDET"},
                    {"Rahul", "QA"},
                    {"Priya", "Developer"},
                    {"Sneha", "Tester"}
            };

        }
}
