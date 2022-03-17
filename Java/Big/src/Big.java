import java.math.BigInteger;
import java.util.Scanner;

public class Big {
    public static void main(String[] args) throws Exception {
        /*
        int input;
        Scanner sc = new Scanner(System.in);
        System.out.println("What number do you want the factorial off? ");
        input = sc.nextInt();
        sc.close();
        System.out.println("The result is: " + factorial(input));
        */
        for (int i = 0; i <= 30; i++) {

            System.out.println(i + "! = " + factorial(i));
            
        }
    }

    public static BigInteger factorial(int num) {
        BigInteger result = BigInteger.valueOf(num);
        for (int i = num - 1; i > 0; i--) {
            result = BigInteger.valueOf(i).multiply(result);
        }
        return result;
    }
}
