import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    void testCalc12() throws IllegalArgumentException {
        StringCalculator StringCalculator = new StringCalculator();

        Assertions.assertEquals(1,StringCalculator.add("1"));

        Assertions.assertEquals(3,StringCalculator.add("1,2"));

        Assertions.assertEquals(0,StringCalculator.add(""));

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("1,2,3");
        });
        Assertions.assertEquals("Кількість додатків не може бути більше двох",thrown.getMessage());

        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add(",");
        });
        Assertions.assertEquals("Аргумент 1 помилкове значення \"\" - пусте значення",thrown1.getMessage());

        IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("1,a");
        });
        Assertions.assertEquals("Аргумент 2 помилкове значення \"a\"",thrown2.getMessage());

        IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add(",2");
        });
        Assertions.assertEquals("Аргумент 1 помилкове значення \"\" - пусте значення",thrown3.getMessage());

    }


}