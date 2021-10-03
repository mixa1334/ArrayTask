package edu.epam.arraytask.sort.impl;

import edu.epam.arraytask.sort.ArraySorter;
import edu.epam.arraytask.customarray.CustomArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectionArraySorter implements ArraySorter {
    public static final Logger logger = LogManager.getLogger();

    @Override
    public void sort(CustomArray array) {
        int n = array.size();
        int[] arr = array.getArray();

        for (int i = 0; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }

        array.setArray(arr);
        logger.log(Level.INFO, "after selection sort: " + array);
    }
}
