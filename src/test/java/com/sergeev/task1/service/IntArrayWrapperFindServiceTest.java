package com.sergeev.task1.service;

import com.sergeev.task1.entity.IntArrayWrapper;
import com.sergeev.task1.exception.IntArrayWrapperException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IntArrayWrapperFindServiceTest {

    private IntArrayWrapperFindService intArrayWrapperFindService;
    private IntArrayWrapper intArrayWrapper;

    @BeforeMethod
    public void setUp() {
        intArrayWrapperFindService = new IntArrayWrapperFindService();
    }

    @Test
    public void testFindMax() throws IntArrayWrapperException {
        intArrayWrapper = new IntArrayWrapper(new int[]{5, 6, 7});
        int actual = intArrayWrapperFindService.findMax(intArrayWrapper);
        int expected = 7;
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testFindMaxInNullArrayIntArrWrapExc() throws IntArrayWrapperException {
        int[] array = null;
        intArrayWrapperFindService.findMax(new IntArrayWrapper(array));
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testFindMaxInArrayWithLengthZero() throws IntArrayWrapperException {
        intArrayWrapperFindService.findMax(new IntArrayWrapper(new int[0]));
    }

    @Test
    public void testFindMin() throws IntArrayWrapperException {
        intArrayWrapper = new IntArrayWrapper(new int[]{5, 6, 7});
        int actual = intArrayWrapperFindService.findMin(intArrayWrapper);
        int expected = 5;
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testFindMixInNullArrayIntArrWrapExc() throws IntArrayWrapperException {
        int[] array = null;
        intArrayWrapperFindService.findMax(new IntArrayWrapper(array));
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testFindMixInArrayWithEmptyArrayIntArrWrapExc() throws IntArrayWrapperException {
        intArrayWrapperFindService.findMax(new IntArrayWrapper(new int[0]));
    }

    @Test
    public void testFindSimpleNumbersPositive() throws IntArrayWrapperException {
        intArrayWrapper = new IntArrayWrapper(new int[]{5, 6, 7, 11});
        Integer[] actual = intArrayWrapperFindService.findSimpleNumbers(intArrayWrapper).get();
        Integer[] expected = {5, 7, 11};
        assertEquals(actual, expected);
    }

    @Test
    public void testFindSimpleNumbersNegative() throws IntArrayWrapperException {
        intArrayWrapper = new IntArrayWrapper(new int[]{4, 6});
        Integer[] actual = intArrayWrapperFindService.findSimpleNumbers(intArrayWrapper).get();
        Integer[] expected = {};
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testFindSimpleNumbersInArrayWithEmptyArray() throws IntArrayWrapperException {
        intArrayWrapperFindService.findSimpleNumbers(new IntArrayWrapper(new int[0]));
    }


    @Test
    public void testBinarySearch() throws IntArrayWrapperException {
        int[] sortedArray = new int[]{1, 2, 3, 4};
        int actualIndex = intArrayWrapperFindService.binarySearch(sortedArray, 2);
        int expectedIndex = 1;
        assertEquals(actualIndex, expectedIndex);
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testBinarySearchInNullArrayIntArrWrapExc() throws IntArrayWrapperException {
        intArrayWrapperFindService.binarySearch(null, 0);
    }

    @Test
    public void testFindFibonacciNumbersPositive() throws IntArrayWrapperException {
        intArrayWrapper = new IntArrayWrapper(new int[]{3, 5, 4, 6});
        Integer[] actual = intArrayWrapperFindService.findFibonacciNumbers(intArrayWrapper).get();
        Integer[] expected = {3, 5};
        assertEquals(actual, expected);
    }

    @Test
    public void testFindFibonacciNumbersNegative() throws IntArrayWrapperException {
        intArrayWrapper = new IntArrayWrapper(new int[]{4, 6});
        Integer[] actual = intArrayWrapperFindService.findFibonacciNumbers(intArrayWrapper).get();
        Integer[] expected = {};
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testFindFibonacciNumbersWithEmptyArrayIntArrWrapExc() throws IntArrayWrapperException {
        intArrayWrapperFindService.findFibonacciNumbers(new IntArrayWrapper(new int[0]));
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testFindFibonacciNumbersInNullArrayIntArrWrapExc() throws IntArrayWrapperException {
        int[] array = null;
        intArrayWrapperFindService.findFibonacciNumbers(new IntArrayWrapper(array));
    }

    @Test
    public void testFindNumbersWithThreeDifferentDigits() throws IntArrayWrapperException {
        intArrayWrapper = new IntArrayWrapper(new int[]{123, 222, 323, 2, 4});
        Integer[] actual = intArrayWrapperFindService.findNumbersWithThreeDifferentDigits(intArrayWrapper).get();
        Integer[] expected = {123};
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testFindNumbersWithThreeDifferentDigitsInEmptyArrayIntArrWrapExc() throws IntArrayWrapperException {
        intArrayWrapperFindService.findNumbersWithThreeDifferentDigits(new IntArrayWrapper(new int[0]));
    }
}
