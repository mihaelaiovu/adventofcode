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
        System.out.println("=== part one ===");
        List<Integer> numberList = parseFile("input.txt");

        for (int i = 0; i < numberList.size(); i++) {
            for (int j = i + 1; j < numberList.size(); j++) {
                Integer number0 = numberList.get(i);
                Integer number1 = numberList.get(j);
                if (number0 + number1 == 2020) {
                    int product = number0 * number1;
                    System.out.println(product);
                    return;
                }
            }
        }
    }

    private static void part2() {
        System.out.println("=== part two ===");
        List<Integer> numberList = parseFile("input.txt");

        for (int i = 0; i < numberList.size(); i++) {
            for (int j = i + 1; j < numberList.size(); j++) {
                for (int k = j +1; k < numberList.size(); k++) {
                    Integer number0 = numberList.get(i);
                    Integer number1 = numberList.get(j);
                    Integer number2 = numberList.get(k);
                    if (number0 + number1 + number2 == 2020) {
                        int product = number0 * number1 * number2;
                        System.out.println(product);
                        return;
                    }
                }
            }
        }
    }

    private static List<Integer> parseFile(String filename) {
        List<Integer> numberList = new ArrayList<>();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int number = Integer.parseInt(data);
                numberList.add(number);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return numberList;
    }
}
