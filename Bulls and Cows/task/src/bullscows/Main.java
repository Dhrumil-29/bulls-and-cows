package bullscows;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class BullCow {
    public Integer bulls, cows;

    public BullCow(Integer bulls, Integer cows) {
        this.bulls = bulls;
        this.cows = cows;
    }
}

class Game {
    private String secretCode;
    BullCow bullCow;
    boolean[] digit;

    public Game() {
        this.digit = new boolean[10];
        Arrays.fill(digit, false);
    }

    public BullCow findBullAndCow(String guessCode) {
        int bulls = 0, cows = 0;
        for (int i = 0; i < guessCode.length(); i++) {
            int index = secretCode.indexOf(guessCode.charAt(i));
            if (index != -1) {
                if (index == i) {
                    bulls++;
                } else {
                    cows++;
                }
            }
        }

        return new BullCow(bulls, cows);
    }

    public void print(BullCow bullCow) {
        if (bullCow.bulls != 0 && bullCow.cows != 0) {
            System.out.println("Grade: " + bullCow.bulls + " bulls and " + bullCow.cows + " cows");
        } else if (bullCow.bulls == 0 && bullCow.cows != 0) {
            System.out.println("Grade: " + bullCow.cows + " cows");
        } else if (bullCow.bulls != 0) {
            System.out.println("Grade: " + bullCow.bulls + " bulls");
        } else {
            System.out.println("Grade: None");
        }
    }

    public void printErrorMessage() {
        System.out.println("Error: secret length cannot be greater than 10");
    }

    private void trimZeros(StringBuilder s) {
        while (s.charAt(0) == '0') {
            s.deleteCharAt(0);
        }
    }

    public StringBuilder uniqueDigit(StringBuilder s, int unique) {
        int i = 0;
        while (i < s.length() && unique != 0) {
            if (!digit[s.charAt(i) - '0']) {
                digit[s.charAt(i) - '0'] = true;
                i++;
                unique--;
            } else {
                s.deleteCharAt(i);
            }
        }
        if (unique == 0) {
            s.delete(i, s.length());
        }

        return s;
    }

    private StringBuilder generateSecreteCode(int unique) {
        StringBuilder code = new StringBuilder();

        while (code.length() != unique) {

            Random random = new Random();
            long randomNumber = random.nextLong((long) (9 * Math.pow(10, unique))) + (long) Math.pow(10, unique);
            StringBuilder s = new StringBuilder(String.valueOf(randomNumber));
            trimZeros(s);
            code.append(uniqueDigit(s, unique));

        }
        return code;
    }

    private int getSecreteLength() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        return scanner.nextInt();
    }

    private String guess() {
        return new Scanner(System.in).next();
    }

    public void play() {

        int turn = 1;
        String guessCode;
        int len = getSecreteLength();

        while (len > 10) {
            printErrorMessage();
            len = getSecreteLength();
        }

        this.secretCode = generateSecreteCode(len).toString();
        System.out.println("Okay, let's start a game!");

        do {
            System.out.println("Turn " + (turn++) + ":");
            guessCode = guess();
            bullCow = findBullAndCow(guessCode);
            print(bullCow);
        } while (!guessCode.equals(secretCode));

        System.out.println("Congratulations! You guessed the secret code.");
    }
}

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        game.play();
    }
}