package iovu.mihaela;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    part1();
    }

    private static void part1() {
        System.out.println("=== part one ===");
        List<String> stringList = readFile("input.txt");
        int treesFound = 0;
        int rowLength = stringList.get(0).length();
        int x = 0;
        for (int y = 1; y < stringList.size(); y++) {
            x = (x + 3) % rowLength;
            char c = stringList.get(y).charAt(x);
            if (c == '#') {
                treesFound++;
            }
        }
        System.out.println(treesFound);
    }


    private static List<String> readFile(String filename) {
        List<String> stringList = new ArrayList<>();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stringList.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return stringList;
    }
}
