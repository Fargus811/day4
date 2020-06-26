package com.sergeev.task1.creator;

import com.sergeev.task1.entity.IntArrayWrapper;
import com.sergeev.task1.exception.IntArrayWrapperException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class ArrayConsoleCreatorTest {

    private ArrayConsoleCreator arrayConsoleCreator;
    private IntArrayWrapper intArrayWrapper;

    @BeforeMethod
    public void setUp() {
        arrayConsoleCreator = new ArrayConsoleCreator();
    }

    @Test
    public void testCreateArrayFromConsolePositive() throws IntArrayWrapperException {
        ByteArrayInputStream in = new ByteArrayInputStream("5 5 5 exit".getBytes());
        System.setIn(in);
        int[] expected = {5, 5, 5};
        intArrayWrapper = new IntArrayWrapper(expected);
        IntArrayWrapper actual = arrayConsoleCreator.createArrayFromConsole().get();
        assertEquals(actual, intArrayWrapper);
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testCreateArrayFromConsoleWrongInputExc() throws IntArrayWrapperException {
        ByteArrayInputStream in = new ByteArrayInputStream("f f f exit".getBytes());
        System.setIn(in);
        arrayConsoleCreator.createArrayFromConsole();
    }

    @Test
    public void testCreateArrayFromConsoleWithWrongNumbers() throws IntArrayWrapperException {
        ByteArrayInputStream in = new ByteArrayInputStream("50000 500000 500000 exit".getBytes());
        System.setIn(in);
        assertFalse(arrayConsoleCreator.createArrayFromConsole().isPresent());
    }
}
