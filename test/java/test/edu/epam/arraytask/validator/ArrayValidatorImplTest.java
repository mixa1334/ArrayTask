package test.edu.epam.arraytask.validator;

import edu.epam.arraytask.validator.ArrayValidator;
import edu.epam.arraytask.validator.impl.ArrayValidatorImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayValidatorImplTest {
    ArrayValidator arrayValidator;

    @BeforeMethod
    public void setUp() {
        arrayValidator = new ArrayValidatorImpl();
    }

    @Test
    public void PositiveOutcome() {
        String[] input = {"-99", "-5", "6", "0", "77777"};

        assertTrue(arrayValidator.validateArray(input));
    }

    @Test
    public void FirstNegativeOutcome() {
        String[] input = {"-99", "5", " 0"};

        assertFalse(arrayValidator.validateArray(input));
    }

    @Test
    public void SecondNegativeOutcome() {
        String[] input = {"-99", "5", "5p"};

        assertFalse(arrayValidator.validateArray(input));
    }
}