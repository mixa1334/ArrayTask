package edu.epam.arraytask.parser.impl;

import edu.epam.arraytask.customarray.CustomArray;
import edu.epam.arraytask.customarray.impl.CustomArrayImpl;
import edu.epam.arraytask.exception.ArrayException;
import edu.epam.arraytask.parser.ArrayParser;
import edu.epam.arraytask.validator.ArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayParserImpl implements ArrayParser {
    public static final Logger logger = LogManager.getLogger();
    private ArrayValidator arrayValidator;

    public ArrayParserImpl(ArrayValidator arrayValidator) {
        this.arrayValidator = arrayValidator;
    }

    @Override
    public CustomArray parseToCustomArray(String[] array) throws ArrayException {
        int[] parsedArray = parseToDefaultArray(array);
        CustomArray result = new CustomArrayImpl(parsedArray);
        logger.log(Level.INFO, "parsed array: " + result);
        return result;
    }

    @Override
    public int[] parseToDefaultArray(String[] array) throws ArrayException {
        if (!arrayValidator.validateArray(array)) {
            String message = "invalid array";
            logger.log(Level.INFO, message);
            throw new ArrayException(message);
        }

        int[] parsedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            parsedArray[i] = Integer.parseInt(array[i]);
        }

        logger.log(Level.INFO, "parsed default array: " + Arrays.toString(parsedArray));
        return parsedArray;
    }
}
