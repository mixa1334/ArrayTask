package edu.epam.arraytask.service;

import edu.epam.arraytask.customarray.CustomArray;

import java.util.OptionalInt;

public interface MinMaxValueFinder {
    OptionalInt max(CustomArray array);

    OptionalInt min(CustomArray array);
}
