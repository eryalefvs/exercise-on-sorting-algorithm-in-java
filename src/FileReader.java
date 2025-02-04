package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<int[]> readNumbersFromFile(String nomeDoArquivo) {
        List<int[]> numbersList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(nomeDoArquivo));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] numbersString = line.split(":");
                int[] numbers = new int[numbersString.length];

                for (int i = 0; i < numbersString.length; i++) {
                    numbers[i] = Integer.parseInt(numbersString[i].trim());
                }

                numbersList.add(numbers);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return numbersList;
    }
}