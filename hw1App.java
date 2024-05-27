package gr.aueb.cf.ch9;

import java.io.*;
import java.util.*;

public class hw1App {

    public static void main(String[] args) {
        String inputFile = "C:/Users/gfkst/IdeaProjects/Idea1023/integers.txt";
        String outputFile = "C:/Users/gfkst/IdeaProjects/Idea1023/filteredCombinations.txt";

        try {
            // Read integers from file
            List<Integer> numbers = readIntegersFromFile(inputFile);

            if (numbers.size() < 6 || numbers.size() > 49) {
                System.out.println("Το αρχείο πρέπει να περιέχει από 6 έως 49 ακέραιους αριθμούς.");
                return;
            }

            Collections.sort(numbers);

            List<int[]> validCombinations = generateAndFilterCombinations(numbers);

            writeCombinationsToFile(validCombinations, outputFile);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static List<Integer> readIntegersFromFile(String inputFile) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                for (String part : parts) {
                    int number = Integer.parseInt(part);
                    if (number >= 1 && number <= 49) {
                        numbers.add(number);
                    }
                }
            }
        }
        return numbers;
    }

    private static List<int[]> generateAndFilterCombinations(List<Integer> numbers) {
        List<int[]> validCombinations = new ArrayList<>();
        int[] combination = new int[6];
        generateCombinations(numbers, combination, 0, 0, validCombinations);
        return validCombinations;
    }

    private static void generateCombinations(List<Integer> numbers, int[] combination, int start, int index, List<int[]> validCombinations) {
        if (index == 6) {
            if (isValidCombination(combination)) {
                validCombinations.add(combination.clone());
            }
            return;
        }

        for (int i = start; i < numbers.size(); i++) {
            combination[index] = numbers.get(i);
            generateCombinations(numbers, combination, i + 1, index + 1, validCombinations);
        }
    }

    private static boolean isValidCombination(int[] combination) {
        return !exceedsEvenCount(combination) &&
                !exceedsOddCount(combination) &&
                !exceedsContiguousCount(combination) &&
                !exceedsSameEndingCount(combination) &&
                !exceedsSameTenCount(combination);
    }

    private static boolean exceedsEvenCount(int[] combination) {
        int count = 0;
        for (int num : combination) {
            if (num % 2 == 0) count++;
        }
        return count > 4;
    }

    private static boolean exceedsOddCount(int[] combination) {
        int count = 0;
        for (int num : combination) {
            if (num % 2 != 0) count++;
        }
        return count > 4;
    }

    private static boolean exceedsContiguousCount(int[] combination) {
        int count = 1;
        for (int i = 1; i < combination.length; i++) {
            if (combination[i] == combination[i - 1] + 1) {
                count++;
                if (count > 2) return true;
            } else {
                count = 1;
            }
        }
        return false;
    }

    private static boolean exceedsSameEndingCount(int[] combination) {
        int[] endings = new int[10];
        for (int num : combination) {
            endings[num % 10]++;
        }
        for (int count : endings) {
            if (count > 3) return true;
        }
        return false;
    }

    private static boolean exceedsSameTenCount(int[] combination) {
        int[] tens = new int[5];
        for (int num : combination) {
            tens[num / 10]++;
        }
        for (int count : tens) {
            if (count > 3) return true;
        }
        return false;
    }

    private static void writeCombinationsToFile(List<int[]> combinations, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (int[] combination : combinations) {
                writer.write(Arrays.toString(combination));
                writer.newLine();
            }
        }
    }
}
