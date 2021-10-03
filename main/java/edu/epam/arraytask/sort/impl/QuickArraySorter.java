package edu.epam.arraytask.sort.impl;

import edu.epam.arraytask.sort.ArraySorter;
import edu.epam.arraytask.customarray.CustomArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuickArraySorter implements ArraySorter {
    public static final Logger logger = LogManager.getLogger();

    @Override
    public void sort(CustomArray array) {
        int high = array.size() - 1;
        int[] arr = array.getArray();
        quickSort(arr, 0, high);
        array.setArray(arr);
        logger.log(Level.INFO, "after quick sort: " + array);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int number = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < number) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
