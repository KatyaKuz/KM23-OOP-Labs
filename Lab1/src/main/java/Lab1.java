import java.util.Scanner;
public class Lab1 {

    public static void main(String[] args) {
        StringCalculator strcal = new StringCalculator();
        Scanner scan=new Scanner(System.in);
        System.out.println("Введіть вираз для розрахунку, використовуючи роздільники [,] та [\\n], або вкажіть свій у форматі //[delimiter]\\n[numbers...]: ");
        String s=scan.nextLine().replace("\\n", "\n");
        try {
            System.out.println("Результат: "+strcal.add(s));
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }

}