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
    private String[] MySplitArray(String s, String[] r){
        ArrayList<String> rez=new ArrayList<>();
        String wrk="";
        boolean is_reg=false;
        if(r.length>0){
            for (int i=0; i<s.length(); i++){
                is_reg=false;
                for (int j=0; j<r.length; j++){
                    if (r[j].length()==0){
                        throw new IllegalArgumentException("Довжина роздільника нуль.");
                    }
                    if ((s.length()-i)>=r[j].length()){
                        if (s.substring(i,i+r[j].length()).equals(r[j])){
                            rez.add(wrk);
                            wrk="";
                            i=i+r[j].length()-1;
                            is_reg=true;
                            break;
                        }
                    }
                }
                if (!is_reg){
                    wrk=wrk+s.charAt(i);
                }
            }
        }
        else{
            throw new IllegalArgumentException("Кількість роздільників нуль.");
        }
        rez.add(wrk);
        String[] ret =  rez.toArray(new String[0]);
        return ret;
    }
    public int add(String numbers) throws IllegalArgumentException{
        String er_regex="Помилковий формат роздільників.\n Правильний формат: //<delimiter>\\n<numbers...>\n Третій символ роздільник, четвертий символ нової строки," +
                "\nабо //[delimiter]\\n<numbers...>, наприклад //[***]\\n1***2***3 ";
        int ret_num=0;
        int array_num;
        int num;
        int i_n;
        String serr="";
        boolean err=false;
        boolean long_regex=false;
        String regex=",\n";
        //ArrayList<String> regex_list=new ArrayList<>();
        String[] regex_list=new String[0];
        String numbers2;
        if (numbers.length()<4){
            numbers2=numbers;
        }
        else{
            i_n=numbers.indexOf("]\n");
            if ((numbers.substring(0,3).equals("//[")) && i_n>0){
                regex=numbers.substring(3,i_n);
                numbers2=numbers.substring(i_n+2);
                if(regex.length()!=1){
                    regex_list=MySplitArray(numbers.substring(3,i_n), new String[]{"]["});
                    long_regex=true;
                }
            } else {
                if (numbers.substring(0,2).equals("//")){
                    if(numbers.substring(3,4).equals("\n")){
                        regex=numbers.substring(2,3);
                        numbers2=numbers.substring(4);
                    }
                    else{
                        throw new IllegalArgumentException(er_regex);
                    }
                }
                else{
                    numbers2=numbers;
                }
            }
        }
        String[] dod;
        if (long_regex){
            dod=MySplitArray(numbers2, regex_list);
        }
        else{
            dod=MySplit(numbers2, regex);
        }
        if (numbers2.length()>0){
            array_num=dod.length;
            for (int i=0; i<array_num; i++){
                if (dod[i].length()>0) {
                    try {
                        num=Integer.parseInt(dod[i]);
                        if (num<0){
                            err=true;
                            if (serr.length()>0){
                                serr=serr+", ";
                            }
                            serr=serr+dod[i];
                        }
                        else{
                            if (!err){
                                if(num<=1000) {
                                    ret_num = ret_num + num;
                                }
                            }
                        }
                    } catch (NumberFormatException ex) {
                        throw new IllegalArgumentException("Аргумент " + (i + 1) + " помилкове значення \"" + dod[i] + "\"");
                    }
                }
                else{
                    throw new IllegalArgumentException("Аргумент " + (i + 1) + " помилкове значення \"\" - пусте значення");
                }
            }
            if (err){
                throw new IllegalArgumentException("Недозволені від'ємні числа: " + serr);
            }
        }
        return ret_num;
    }
}
