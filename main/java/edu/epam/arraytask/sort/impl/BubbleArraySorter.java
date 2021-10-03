package edu.epam.arraytask.sort.impl;

import edu.epam.arraytask.sort.ArraySorter;
import edu.epam.arraytask.customarray.CustomArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BubbleArraySorter implements ArraySorter {
    public static final Logger logger = LogManager.getLogger();

    @Override
    public void sort(CustomArray array) {
        int n = array.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array.getElement(j) > array.getElement(j + 1)) {
                    int temp = array.getElement(j);
                    array.setElement(j, array.getElement(j + 1));
                    array.setElement(j + 1, temp);
                }
            }
        }
        logger.log(Level.INFO, "after bubble sort: " + array);
    }
}
