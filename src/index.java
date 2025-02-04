package src;

import java.util.List;

import java.util.Arrays;

public class index {
    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) {
            String fileName = "files/random_numbers_10000.txt";
            List<int[]> numbersList = FileReader.readNumbersFromFile(fileName);

            int[][] copiedNumbers = copyList(numbersList);

            for (int j = 0; j < copiedNumbers.length; j++) {
                int[] numbers = copiedNumbers[j];
                System.out.println("Arquivo " + i);
                System.out.println("InsertionSort Times:");
                impressaoDoTempo(numbers, Sorting::insertionSort);

                System.out.println("QuickSort Times:");
                impressaoDoTempo(numbers, Sorting::quickSort);
            }
            System.out.println();
        }
    }

    private static void impressaoDoTempo(int[] numbers, SortingAlgorithm sortingAlgorithm) {
        for (int k = 0; k < 30; k++) {
            long tempoInicial = System.nanoTime();
            sortingAlgorithm.sort(Arrays.copyOf(numbers, numbers.length));
            long tempoFinal = System.nanoTime();
            long tempoCalculado = tempoFinal - tempoInicial;
            System.out.println(" - " + tempoCalculado + " nanossegundos");
        }
    }

    private static int[][] copyList(List<int[]> original) {
        int[][] copy = new int[original.size()][];
        for (int i = 0; i < original.size(); i++) {
            int[] arr = original.get(i);
            copy[i] = Arrays.copyOf(arr, arr.length);
        }
        return copy;
    }

    interface SortingAlgorithm {
        void sort(int[] array);
    }
}