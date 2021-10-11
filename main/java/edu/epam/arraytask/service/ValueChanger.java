package edu.epam.arraytask.service;

import edu.epam.arraytask.customarray.CustomArray;

import java.util.function.IntFunction;
import java.util.function.IntPredicate;

public interface ValueChanger {
    void changeValues(CustomArray array, IntPredicate predicate, IntFunction<Integer> function);
}
