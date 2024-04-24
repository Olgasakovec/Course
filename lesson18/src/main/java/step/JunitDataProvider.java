package step;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class JunitDataProvider {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    public void testNumberMoreThanZero(int number){
        Assertions.assertTrue(number> 0, "Number should be bigger than 0: " + number);
    }
}
