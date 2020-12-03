package iovu.mihaela;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        System.out.println("=== Part 1 ===");
        List<PasswordInfo> passwordInfos = parseFile("input.txt");
        int validPasswords = 0;

        for (PasswordInfo passwordInfo : passwordInfos) {
            if (isValidPasswordPart1(passwordInfo)) {
                validPasswords++;
            }
        }
        System.out.println(validPasswords);
    }

    private static void part2() {
        System.out.println("=== Part 2 ===");
        List<PasswordInfo> passwordInfos = parseFile("input.txt");
        int validPasswords = 0;

        for (PasswordInfo passwordInfo : passwordInfos) {
            if (isValidPasswordPart2(passwordInfo)) {
                validPasswords++;
            }
        }
        System.out.println(validPasswords);
    }

    private static boolean isValidPasswordPart1(PasswordInfo passwordInfo) {
        long count = passwordInfo.getPassword().chars().filter(ch -> ch == passwordInfo.getLetter()).count();
        if (passwordInfo.getFirstNumber() > count) {
            return false;
        }
        return passwordInfo.getSecondNumber() >= count;
    }

    private static boolean isValidPasswordPart2(PasswordInfo passwordInfo) {
        char firstChar = passwordInfo.getPassword().charAt(passwordInfo.getFirstNumber() - 1);
        char secondChar = passwordInfo.getPassword().charAt(passwordInfo.getSecondNumber() - 1);
        if ((passwordInfo.getLetter() == firstChar) ^ (passwordInfo.getLetter() == secondChar)) {
            return true;
        }
        return false;
    }

    private static List<PasswordInfo> parseFile(String filename) {
        List<PasswordInfo> passwordList = new ArrayList<>();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                passwordList.add(parsePasswordInfo(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return passwordList;
    }

    private static PasswordInfo parsePasswordInfo(String s) {
        String[] splitted = s.split(" ");
        String password = splitted[2];
        char letter = splitted[1].charAt(0);
        String[] numberSplit = splitted[0].split("-");
        int firstNumber = Integer.parseInt(numberSplit[0]);
        int secondNumber = Integer.parseInt(numberSplit[1]);
        return new PasswordInfo(firstNumber, secondNumber, letter, password);
    }
}
