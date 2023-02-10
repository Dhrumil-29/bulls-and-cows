import java.util.Scanner;

public class Main {

    public static long factorial(long n) {
        // write your code here
        if(n == 0)
            return 1;

        long ans = 1;
        for(int i = 2;i <= n;i++){
            ans *= i;
        }
        return ans;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine().trim());
        System.out.println(factorial(n));
    }
}