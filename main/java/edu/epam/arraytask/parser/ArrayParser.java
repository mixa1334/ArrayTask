package edu.epam.arraytask.parser;

import edu.epam.arraytask.customarray.CustomArray;
import edu.epam.arraytask.exception.ArrayException;

public interface ArrayParser {
    CustomArray parseToCustomArray(String[] array) throws ArrayException;

    int[] parseToDefaultArray(String[] array) throws ArrayException;
}
