import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        Double a = scanner.nextDouble();
        Double b = scanner.nextDouble();
        Double c = scanner.nextDouble();

        Double p = (a + b + c) / 2;

        Double ans = p * (p - a) * (p - b) * (p - c);
        ans = Math.sqrt(ans);

        System.out.println(ans);
    }
}