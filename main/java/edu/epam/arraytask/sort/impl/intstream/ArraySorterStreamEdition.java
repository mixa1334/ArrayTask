package edu.epam.arraytask.sort.impl.intstream;

import edu.epam.arraytask.customarray.CustomArray;
import edu.epam.arraytask.sort.ArraySorter;

import java.util.stream.IntStream;

public class ArraySorterStreamEdition implements ArraySorter {
    @Override
    public void sort(CustomArray array) {
        int[] beforeSort = array.getArray();
        int[] afterSort = IntStream.of(beforeSort)
                .sorted().toArray();

        array.setArray(afterSort);
    }
}
