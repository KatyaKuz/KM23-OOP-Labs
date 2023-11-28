import java.util.ArrayList;
public class StringCalculator {
    private String[] MySplit(String s, String r){
        ArrayList<String> rez=new ArrayList<>();
        String wrk="";
        for (int i=0; i<s.length(); i++){
            if(r.contains(s.substring(i, i+1))){
                rez.add(wrk);
                wrk="";
            }
            else{
                wrk=wrk+s.charAt(i);
            }
        }
        rez.add(wrk);
        String[] ret =  rez.toArray(new String[0]);
        return ret;
    }
    public int add(String numbers) throws IllegalArgumentException{
        int ret_num=0;
        int array_num;
        String regex=",\n";
        String numbers2;
        if (numbers.length()<4){
            numbers2=numbers;
        }
        else{
            if (numbers.substring(0,2).equals("//")){
                if(numbers.substring(3,4).equals("\n")){
                    regex=numbers.substring(2,3);
                    numbers2=numbers.substring(4);
                }
                else{
                    throw new IllegalArgumentException("Помилковий формат роздільників.\n Правильний формат: //[delimiter]\\n[numbers...]\n Третій символ роздільник, четвертий символ нової строки. ");
                }
            }
            else{
                numbers2=numbers;
            }
        }
        String[] dod=MySplit(numbers2, regex);
        if (numbers2.length()>0){
            array_num=dod.length;
            for (int i=0; i<array_num; i++){
                if (dod[i].length()>0) {
                    try {
                        ret_num = ret_num + Integer.parseInt(dod[i]);
                    } catch (NumberFormatException ex) {
                        throw new IllegalArgumentException("Аргумент " + (i + 1) + " помилкове значення \"" + dod[i] + "\"");
                    }
                }
                else{
                    throw new IllegalArgumentException("Аргумент " + (i + 1) + " помилкове значення \"\" - пусте значення");
                }
            }
        }
        return ret_num;
    }
}
