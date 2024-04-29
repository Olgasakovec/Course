package sacovec.olga;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task5 {
    @Test(dataProvider = "numberData")
    public void testNumbersNotEqual(int num1, int num2) {
        Assertions.assertNotEquals(num1, num2, "Numbers are equal: " + num1 + " and " + num2);
    }

    @DataProvider(name = "numberData")
    public Object[][] numberData() {
        return new Object[][] { { 10, 20 }, { 20, 10 } };
    }
}
