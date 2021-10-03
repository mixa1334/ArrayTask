package test.edu.epam.arraytask.arraysort.streamarraysorter;

import edu.epam.arraytask.customarray.CustomArray;
import edu.epam.arraytask.customarray.impl.CustomArrayImpl;
import edu.epam.arraytask.sort.ArraySorter;
import edu.epam.arraytask.sort.impl.intstream.ArraySorterStreamEdition;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySorterStreamEditionTest {

    @Test
    public void testSort() {
        CustomArray actual = new CustomArrayImpl(-5, 10, 99, -60, 2, 0, 0, 3, 7);
        CustomArray expected = new CustomArrayImpl(-60, -5, 0, 0, 2, 3, 7, 10, 99);
        ArraySorter arraySorter = new ArraySorterStreamEdition();

        arraySorter.sort(actual);

        assertEquals(actual, expected);
    }
}