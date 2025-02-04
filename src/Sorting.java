package src;

// import java.util.Arrays;

public class Sorting {
    public static void insertionSort(int[] arr) {
        sort(arr);
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // QuickSort:
    private static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);

        }
    }

    private static int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1;
        while (i <= fim) {
            if (vetor[i] <= pivo)
                i++;
            else if (pivo < vetor[fim])
                fim--;
            else {
                int troca = vetor[i];
                vetor[i] = vetor[fim];
                vetor[fim] = troca;
                i++;
                fim--;
            }
        }
        vetor[inicio] = vetor[fim];
        vetor[fim] = pivo;
        return fim;
    }

    // InsertionSort:

    static void sort(int arr[]) {
        for (int i = 1, j; i < arr.length; i++) {
            int temp = arr[i];
            for (j = i; j > 0 && temp < arr[j - 1]; j--)
                arr[j] = arr[j - 1];
            arr[j] = temp;
        }
    }

}