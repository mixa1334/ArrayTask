package test.edu.epam.arraytask.reader;

import edu.epam.arraytask.exceptions.ArrayException;
import edu.epam.arraytask.reader.ArrayReader;
import edu.epam.arraytask.reader.impl.ArrayReaderImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ArrayReaderImplTest {
    ArrayReader arrayReader;
    List<List<String>> expected;

    @BeforeMethod
    public void setUp() {
        arrayReader = new ArrayReaderImpl();
        expected = new ArrayList<>(3);
        expected.add(Arrays.asList("1f", "2,", "5", "10"));
        expected.add(Arrays.asList("1", "2", "3", "6", "5", "4"));
        expected.add(Arrays.asList("t", "85t.", ",.", "11\\8"));
    }

    @Test
    public void testReadArraysFromFilePositiveOutcome() throws ArrayException {
        String path = "test.txt";
        List<List<String>> actual = arrayReader.readArraysFromFile(path);

        assertEquals(actual.toString(), expected.toString());
    }

    @Test(expectedExceptions = ArrayException.class)
    public void testReadArraysFromFileNegativeOutcome() throws ArrayException {
        String path = "input.xt";

        arrayReader.readArraysFromFile(path);
    }
}