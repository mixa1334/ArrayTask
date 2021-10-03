package edu.epam.arraytask.services;

import edu.epam.arraytask.customarray.CustomArray;

import java.util.OptionalInt;

public interface MinMaxValueFinder {
    OptionalInt max(CustomArray array);

    OptionalInt min(CustomArray array);
}
