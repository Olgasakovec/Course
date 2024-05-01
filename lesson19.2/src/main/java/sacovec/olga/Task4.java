package sacovec.olga;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task4 {
    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{
                {"testing"},
                {"test"},
                {"tested"}
        };
    }

    @Test(dataProvider = "testData")
    public void testStringNotEmpty(String inputString) {
        Assertions.assertFalse(inputString.isEmpty(), "Строка не пустая: " + inputString);
    }
}