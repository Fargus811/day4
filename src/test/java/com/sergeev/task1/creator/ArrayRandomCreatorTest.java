package com.sergeev.task1.creator;

import com.sergeev.task1.entity.IntArrayWrapper;
import com.sergeev.task1.exception.IntArrayWrapperException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayRandomCreatorTest {

    private ArrayRandomCreator arrayRandomCreator;

    @BeforeMethod
    public void setUp() {
        arrayRandomCreator = new ArrayRandomCreator();
    }

    @Test
    public void testCreateRandomIntArrayWrapper() throws IntArrayWrapperException {
        IntArrayWrapper expected = new IntArrayWrapper(new int[5]);
        IntArrayWrapper actual = arrayRandomCreator.createRandomIntArrayWrapper(5);
        assertEquals(actual.getLength(), expected.getLength(), 4);
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testCreateRandomIntArrayWrapperIntArrWrapExc() throws IntArrayWrapperException {
        arrayRandomCreator.createRandomIntArrayWrapper(0);
    }
}
