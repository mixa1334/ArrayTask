package edu.epam.arraytask.validator.impl;

import edu.epam.arraytask.validator.ArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayValidatorImpl implements ArrayValidator {
    public static final Logger logger = LogManager.getLogger();
    public static final String REGEX_VALID_VALUE = "^-?([0-9]{1,10})$";

    @Override
    public final boolean validateArray(String[] array) {
        for (String number : array) {
            if (!number.matches(REGEX_VALID_VALUE)) {
                logger.log(Level.INFO, " invalid value in array: " + Arrays.toString(array) + " ---> " + number);
                return false;
            }
        }
        logger.log(Level.INFO, " array passed validation: " + Arrays.toString(array));
        return true;
    }
}
