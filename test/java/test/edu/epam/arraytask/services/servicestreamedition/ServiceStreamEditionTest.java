package test.edu.epam.arraytask.services.servicestreamedition;

import edu.epam.arraytask.customarray.CustomArray;
import edu.epam.arraytask.customarray.impl.CustomArrayImpl;
import edu.epam.arraytask.services.impl.intstream.ServiceStreamEdition;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import static org.testng.Assert.*;

public class ServiceStreamEditionTest {
    CustomArray customArray;
    ServiceStreamEdition customArrayService;

    @BeforeMethod
    public void setUp() {
        customArray = new CustomArrayImpl(-9, 1, 0, 5, 10, 20);
        customArrayService = new ServiceStreamEdition();
    }

    @Test
    public void testCalculateAverageValue() {
        OptionalDouble output = customArrayService.calculateAverageValue(customArray);
        double actual = output.getAsDouble();
        double expected = 4.5;

        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateCountOfPositiveNumbers() {
        long actual = customArrayService.calculateCountOfPositiveNumbers(customArray);
        long expected = 4;

        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateCountOfNegativeNumbers() {
        long actual = customArrayService.calculateCountOfNegativeNumbers(customArray);
        long expected = 1;

        assertEquals(actual, expected);
    }

    @Test
    public void testMax() {
        OptionalInt output = customArrayService.max(customArray);
        int actual = output.getAsInt();
        int expected = 20;

        assertEquals(actual, expected);
    }

    @Test
    public void testMin() {
        OptionalInt output = customArrayService.min(customArray);
        int actual = output.getAsInt();
        int expected = -9;

        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateSum() {
        int actual = customArrayService.calculateSum(customArray);
        int expected = 27;

        assertEquals(actual, expected);
    }

    @Test
    public void testChangeValues() {
        CustomArray actual = new CustomArrayImpl(customArray.getArray());
        customArrayService.changeValues(actual, number -> number % 10 == 0, number -> 33 * 2 + 3);
        CustomArray expected = new CustomArrayImpl(-9, 1, 69, 5, 69, 69);

        assertEquals(actual, expected);
    }
}