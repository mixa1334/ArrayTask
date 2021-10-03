package edu.epam.arraytask.services.impl;

import edu.epam.arraytask.customarray.CustomArray;
import edu.epam.arraytask.services.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;

public class Service implements AverageValueDeterminant, ElementsCounter,
        MinMaxValueFinder, ValueAdder, ValueChanger {

    public static final Logger logger = LogManager.getLogger();

    @Override
    public OptionalDouble calculateAverageValue(CustomArray array) {
        if (array.size() <= 0) {
            logger.log(Level.INFO, " empty array ");
            return OptionalDouble.empty();
        }

        double size = array.size();
        double result = calculateSum(array) / size;
        logger.log(Level.INFO, " average value in " + array + ": " + result);
        return OptionalDouble.of(result);
    }

    @Override
    public long calculateCountOfPositiveNumbers(CustomArray array) {
        long count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.getElement(i) > 0) {
                count++;
            }
        }
        logger.log(Level.INFO, " positive numbers count in " + array + ": " + count);
        return count;
    }

    @Override
    public long calculateCountOfNegativeNumbers(CustomArray array) {
        long count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.getElement(i) < 0) {
                count++;
            }
        }
        logger.log(Level.INFO, " positive numbers count in " + array + ": " + count);
        return count;
    }

    @Override
    public OptionalInt max(CustomArray array) {
        if (array.size() <= 0) {
            logger.log(Level.INFO, " empty array ");
            return OptionalInt.empty();
        }

        int max = Integer.MIN_VALUE;
        int valueOfArray;
        for (int i = 0; i < array.size(); i++) {
            valueOfArray = array.getElement(i);
            if (valueOfArray > max) {
                max = valueOfArray;
            }
        }
        logger.log(Level.INFO, " max value in " + array + ": " + max);
        return OptionalInt.of(max);
    }

    @Override
    public OptionalInt min(CustomArray array) {
        if (array.size() <= 0) {
            logger.log(Level.INFO, " empty array ");
            return OptionalInt.empty();
        }

        int min = Integer.MAX_VALUE;
        int valueOfArray;
        for (int i = 0; i < array.size(); i++) {
            valueOfArray = array.getElement(i);
            if (valueOfArray < min) {
                min = valueOfArray;
            }
        }
        logger.log(Level.INFO, " max value in " + array + ": " + min);
        return OptionalInt.of(min);
    }

    @Override
    public int calculateSum(CustomArray array) {
        int result = 0;
        for (int i = 0; i < array.size(); i++) {
            result += array.getElement(i);
        }
        logger.log(Level.INFO, " sum of values in " + array + ": " + result);
        return result;
    }

    @Override
    public void changeValues(CustomArray array, IntPredicate predicate, IntFunction<Integer> function) {
        String oldArray = array.toString();
        int valueOfArray;
        for (int i = 0; i < array.size(); i++) {
            valueOfArray = array.getElement(i);
            if (predicate.test(valueOfArray)) {
                array.setElement(i, function.apply(valueOfArray));
            }
        }
        logger.log(Level.INFO, " before changes: " + oldArray + ", after changes: " + array);
    }
}