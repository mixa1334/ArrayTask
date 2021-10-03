package test.edu.epam.arraytask.arraysort.quickarraysorter;

import edu.epam.arraytask.sort.ArraySorter;
import edu.epam.arraytask.sort.impl.QuickArraySorter;
import edu.epam.arraytask.customarray.CustomArray;
import edu.epam.arraytask.customarray.impl.CustomArrayImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class QuickArraySorterTest {

    @Test
    public void testSort() {
        CustomArray actual = new CustomArrayImpl(-5, 10, 99, -60, 2, 0, 0, 3, 7);
        CustomArray expected = new CustomArrayImpl(-60, -5, 0, 0, 2, 3, 7, 10, 99);
        ArraySorter arraySorter = new QuickArraySorter();

        arraySorter.sort(actual);

        assertEquals(actual, expected);
    }
}