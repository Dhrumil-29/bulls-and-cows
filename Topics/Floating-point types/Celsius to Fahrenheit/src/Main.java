import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        Double cel = scanner.nextDouble();

        Double fah = cel * 1.8 + 32;

        System.out.println(fah);
    }
}