package test.edu.epam.arraytask.parser;

import edu.epam.arraytask.customarray.CustomArray;
import edu.epam.arraytask.customarray.impl.CustomArrayImpl;
import edu.epam.arraytask.exceptions.ArrayException;
import edu.epam.arraytask.parser.ArrayParser;
import edu.epam.arraytask.parser.impl.ArrayParserImpl;
import edu.epam.arraytask.validator.impl.ArrayValidatorImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayParserImplTest {
    ArrayParser arrayParser;
    String[] positiveInput;
    String[] negativeInput;
    int[] defaultArrayExpected;

    @BeforeMethod

    public void setUp() {
        arrayParser = new ArrayParserImpl(new ArrayValidatorImpl());
        positiveInput = new String[]{"50", "-9", "60", "0"};
        defaultArrayExpected = new int[]{50, -9, 60, 0};
        negativeInput = new String[]{"0", "89", "1f1", "-5"};
    }

    @Test
    public void testParseToCustomArrayPositiveOutcome() throws ArrayException {
        int[] actual = arrayParser.parseToDefaultArray(positiveInput);
        assertEquals(actual, defaultArrayExpected);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void testParseToCustomArrayNegativeOutcome() throws ArrayException {
        int[] actual = arrayParser.parseToDefaultArray(negativeInput);
    }

    @Test
    public void testParseToDefaultArrayPositiveOutcome() throws ArrayException {
        CustomArray expected = new CustomArrayImpl(defaultArrayExpected);
        CustomArray actual = arrayParser.parseToCustomArray(positiveInput);

        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ArrayException.class)
    public void testParseToDefaultArrayNegativeOutcome() throws ArrayException {
        CustomArray actual = arrayParser.parseToCustomArray(negativeInput);
    }
}