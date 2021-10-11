package edu.epam.arraytask.service.impl.intstream;

import edu.epam.arraytask.customarray.CustomArray;
import edu.epam.arraytask.service.*;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class ServiceStreamEdition implements AverageValueDeterminant, ElementsCounter,
        MinMaxValueFinder, ValueAdder, ValueChanger {

    @Override
    public OptionalDouble calculateAverageValue(CustomArray array) {
        int[] input = array.getArray();
        return IntStream.of(input).average();
    }

    @Override
    public long calculateCountOfPositiveNumbers(CustomArray array) {
        int[] input = array.getArray();
        return IntStream.of(input)
                .filter(number -> number > 0)
                .count();
    }

    @Override
    public long calculateCountOfNegativeNumbers(CustomArray array) {
        int[] input = array.getArray();
        return IntStream.of(input)
                .filter(number -> number < 0)
                .count();
    }

    @Override
    public OptionalInt max(CustomArray array) {
        int[] input = array.getArray();
        return IntStream.of(input).max();
    }

    @Override
    public OptionalInt min(CustomArray array) {
        int[] input = array.getArray();
        return IntStream.of(input).min();
    }

    @Override
    public int calculateSum(CustomArray array) {
        int[] input = array.getArray();
        return IntStream.of(input).sum();
    }

    @Override
    public void changeValues(CustomArray array, IntPredicate predicate, IntFunction<Integer> function) {
        int[] input = array.getArray();
        int[] afterChanges = IntStream.of(input)
                .map(number -> predicate.test(number) ? function.apply(number) : number)
                .toArray();

        array.setArray(afterChanges);
    }
}
