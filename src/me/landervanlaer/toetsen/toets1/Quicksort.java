package me.landervanlaer.toetsen.toets1;

import java.util.Arrays;

public class Quicksort {
    public static void sort(int[] arr, int bI, int eI) {
        if(bI < eI) {
            final int i = partition(arr, bI, eI);
            sort(arr, bI, i - 1);
            sort(arr, i + 1, eI);
        }
    }

    public static int partition(int[] arr, int bI, int eI) {
        final int pivo = arr[eI];
        int i = bI;
        for(int j = bI; j <= eI; j++) {
            if(arr[j] <= pivo) {
                final int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        return i - 1;
    }
}
