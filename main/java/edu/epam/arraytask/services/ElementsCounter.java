package edu.epam.arraytask.services;

import edu.epam.arraytask.customarray.CustomArray;

public interface ElementsCounter {
    long calculateCountOfPositiveNumbers(CustomArray array);

    long calculateCountOfNegativeNumbers(CustomArray array);
}
