package com.sergeev.task1.entity;

import com.sergeev.task1.exception.IntArrayWrapperException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class IntArrayWrapperTest {

    IntArrayWrapper intArrayWrapper;

    @BeforeMethod
    public void setUp() throws IntArrayWrapperException {
        intArrayWrapper = new IntArrayWrapper(new int[]{1, 2, 4});
    }

    @Test
    public void testGet() throws IntArrayWrapperException {
        int actual = intArrayWrapper.get(0);
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testGetInvalidIndexIntArrWrapExc() throws IntArrayWrapperException {
        intArrayWrapper.get(8);
    }

    @Test
    public void testGetCloneArray() throws IntArrayWrapperException {
        int[] actual = intArrayWrapper.getCloneArray();
        int[] expected = new int[]{1, 2, 4};
        assertEquals(actual, expected);
    }


    @Test
    public void testEqualsPositive() throws IntArrayWrapperException {
        IntArrayWrapper intArrayWrapperToEqual = new IntArrayWrapper(new int[]{1, 2, 4});
        boolean actual = intArrayWrapper.equals(intArrayWrapperToEqual);
        assertTrue(actual);
    }

    @Test
    public void testEqualsNegative() throws IntArrayWrapperException {
        IntArrayWrapper intArrayWrapperToEqual = new IntArrayWrapper(new int[]{1, 3, 4});
        boolean actual = intArrayWrapper.equals(intArrayWrapperToEqual);
        assertFalse(actual);
    }

    @Test
    public void testConstructorWithList() throws IntArrayWrapperException {
        ArrayList ints = new ArrayList<Integer>();
        ints.add(2);
        IntArrayWrapper actual = new IntArrayWrapper(ints);
        IntArrayWrapper expected = new IntArrayWrapper(new int[]{2});
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testConstructorWithEmptyListIntArrWrapExc() throws IntArrayWrapperException {
        ArrayList ints = new ArrayList<Integer>();
        new IntArrayWrapper(ints);
    }

    @Test
    public void testConstructorWithLenght() throws IntArrayWrapperException {
        IntArrayWrapper actual = new IntArrayWrapper(5);
        IntArrayWrapper expected = new IntArrayWrapper(new int[5]);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testConstructorWithIncorrectLength() throws IntArrayWrapperException {
        new IntArrayWrapper(0);
    }
}
