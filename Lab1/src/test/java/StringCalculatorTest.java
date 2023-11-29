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

        IllegalArgumentException thrown10 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//\n1,2");
        });
        Assertions.assertEquals("Помилковий формат роздільників.\n Правильний формат: //<delimiter>\\n<numbers...>\n Третій символ роздільник, четвертий символ нової строки," +
                "\nабо //[delimiter]\\n<numbers...>, наприклад //[***]\\n1***2***3 ",thrown10.getMessage());

        IllegalArgumentException thrown11 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//;.\n1;2");
        });
        Assertions.assertEquals("Помилковий формат роздільників.\n Правильний формат: //<delimiter>\\n<numbers...>\n Третій символ роздільник, четвертий символ нової строки," +
                "\nабо //[delimiter]\\n<numbers...>, наприклад //[***]\\n1***2***3 ",thrown11.getMessage());

        IllegalArgumentException thrown12 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//;1;2");
        });
        Assertions.assertEquals("Помилковий формат роздільників.\n Правильний формат: //<delimiter>\\n<numbers...>\n Третій символ роздільник, четвертий символ нової строки," +
                "\nабо //[delimiter]\\n<numbers...>, наприклад //[***]\\n1***2***3 ",thrown12.getMessage());

        IllegalArgumentException thrown13 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("/;\n1;2");
        });
        Assertions.assertEquals("Аргумент 1 помилкове значення \"/;\"",thrown13.getMessage());

        IllegalArgumentException thrown14 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("\\;\n1;2");
        });
        Assertions.assertEquals("Аргумент 1 помилкове значення \"\\;\"",thrown14.getMessage());

        IllegalArgumentException thrown15 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//;\n1,2");
        });
        Assertions.assertEquals("Аргумент 1 помилкове значення \"1,2\"",thrown15.getMessage());

        IllegalArgumentException thrown16 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//;\n1;2\n3");
        });
        Assertions.assertEquals("Аргумент 2 помилкове значення \"2\n3\"",thrown16.getMessage());

        IllegalArgumentException thrown17 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//;");
        });
        Assertions.assertEquals("Аргумент 1 помилкове значення \"//;\"",thrown17.getMessage());

        Assertions.assertEquals(0,StringCalculator.add("//;\n"));

        Assertions.assertEquals(1,StringCalculator.add("//;\n1"));

        IllegalArgumentException thrown18 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//;\n1;");
        });
        Assertions.assertEquals("Аргумент 2 помилкове значення \"\" - пусте значення",thrown18.getMessage());

        IllegalArgumentException thrown19 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//;\n;");
        });
        Assertions.assertEquals("Аргумент 1 помилкове значення \"\" - пусте значення",thrown19.getMessage());

        IllegalArgumentException thrown20 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("1,-2,3,-4,-5,6");
        });
        Assertions.assertEquals("Недозволені від'ємні числа: -2, -4, -5",thrown20.getMessage());

        IllegalArgumentException thrown21 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("1\n-2,3,-4,-5,6");
        });
        Assertions.assertEquals("Недозволені від'ємні числа: -2, -4, -5",thrown21.getMessage());

        IllegalArgumentException thrown22 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//;\n1;-2;3;-4;-5;6");
        });
        Assertions.assertEquals("Недозволені від'ємні числа: -2, -4, -5",thrown22.getMessage());

        Assertions.assertEquals(1999,StringCalculator.add("1000,999,1001"));

        Assertions.assertEquals(0,StringCalculator.add("1200,1999,1001"));

        Assertions.assertEquals(1999,StringCalculator.add("//;\n1000;999;1001"));

        Assertions.assertEquals(0,StringCalculator.add("//;\n1200;1999;1001"));

        Assertions.assertEquals(6,StringCalculator.add("//[\n1[2[3"));

        Assertions.assertEquals(6,StringCalculator.add("//]\n1]2]3"));

        Assertions.assertEquals(6,StringCalculator.add("//[***]\n1***2***3"));

        Assertions.assertEquals(7,StringCalculator.add("//[abc]\n1abc2abc4"));

        Assertions.assertEquals(6,StringCalculator.add("//[*]\n1*2*3"));

        IllegalArgumentException thrown23 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//[]\n1,2");
        });
        Assertions.assertEquals("Довжина роздільника нуль.",thrown23.getMessage());

        IllegalArgumentException thrown24 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//[***]\n1**2");
        });
        Assertions.assertEquals("Аргумент 1 помилкове значення \"1**2\"",thrown24.getMessage());

        IllegalArgumentException thrown25 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//[***]\n1***2***");
        });
        Assertions.assertEquals("Аргумент 3 помилкове значення \"\" - пусте значення",thrown25.getMessage());

        IllegalArgumentException thrown26 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//[***]\\n1***2");
        });
        Assertions.assertEquals("Помилковий формат роздільників.\n" +
                " Правильний формат: //<delimiter>\\n<numbers...>\n" +
                " Третій символ роздільник, четвертий символ нової строки,\n" +
                "або //[delimiter]\\n<numbers...>, наприклад //[***]\\n1***2***3 ",thrown26.getMessage());

        IllegalArgumentException thrown27 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//[**]\n1***2");
        });
        Assertions.assertEquals("Аргумент 2 помилкове значення \"*2\"",thrown27.getMessage());

        IllegalArgumentException thrown28 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//[**]\n1****2");
        });
        Assertions.assertEquals("Аргумент 2 помилкове значення \"\" - пусте значення",thrown28.getMessage());

        Assertions.assertEquals(6,StringCalculator.add("//[*\n]\n1*\n2*\n3"));

        Assertions.assertEquals(6,StringCalculator.add("//[\n]\n1\n2\n3"));

        Assertions.assertEquals(10,StringCalculator.add("//[,][;][.]\n1.2,3;4"));

        IllegalArgumentException thrown29 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//[,][;][.]\n1.2,;4");
        });
        Assertions.assertEquals("Аргумент 3 помилкове значення \"\" - пусте значення",thrown29.getMessage());

        IllegalArgumentException thrown30 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//[,][][;][.]\n1.2,3;4");
        });
        Assertions.assertEquals("Довжина роздільника нуль.",thrown30.getMessage());

        IllegalArgumentException thrown31 = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            StringCalculator.add("//[,][;]\n1.2,3;4");
        });
        Assertions.assertEquals("Аргумент 1 помилкове значення \"1.2\"",thrown31.getMessage());

        Assertions.assertEquals(10,StringCalculator.add("//[,][;][]]\n1]2,3;4"));

        Assertions.assertEquals(10,StringCalculator.add("//[,][;][[]\n1[2,3;4"));


    }


}