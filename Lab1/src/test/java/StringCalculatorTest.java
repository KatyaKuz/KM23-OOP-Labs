import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    void testCalc12() throws IllegalArgumentException {
        StringCalculator StringCalculator = new StringCalculator();

        Assertions.assertEquals(1,StringCalculator.add("1"));

        Assertions.assertEquals(3,StringCalculator.add("1,2"));

        Assertions.assertEquals(0,StringCalculator.add(""));

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

        IllegalArgumentException thrown4 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("1\\n2,3,5");
        });
        Assertions.assertEquals("Аргумент 1 помилкове значення \"1\\n2\"",thrown4.getMessage());

        IllegalArgumentException thrown5 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("1,\n");
        });
        Assertions.assertEquals("Аргумент 2 помилкове значення \"\" - пусте значення",thrown5.getMessage());

        IllegalArgumentException thrown6 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("1,,");
        });
        Assertions.assertEquals("Аргумент 2 помилкове значення \"\" - пусте значення",thrown6.getMessage());

        IllegalArgumentException thrown7 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("1,n");
        });
        Assertions.assertEquals("Аргумент 2 помилкове значення \"n\"",thrown7.getMessage());

        IllegalArgumentException thrown8 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("1\n");
        });
        Assertions.assertEquals("Аргумент 2 помилкове значення \"\" - пусте значення",thrown8.getMessage());

        Assertions.assertEquals(13,StringCalculator.add("1,12"));

        IllegalArgumentException thrown9 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("1/n2");
        });
        Assertions.assertEquals("Аргумент 1 помилкове значення \"1/n2\"",thrown9.getMessage());
    }


}