package com.sergeev.task2.service.impl;

import com.sergeev.task2.exception.JaggedArrayException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MinimalElementArraySortServiceTest {

    private MinimalElementArrayServiceSortService minimalElementArraySortService;

    @BeforeMethod
    public void setUp() {
        minimalElementArraySortService = new MinimalElementArrayServiceSortService();
    }

    @Test
    public void testCompareFirstArrayLess() throws JaggedArrayException {
        int[] firstArray = {100,11,11,1};
        int[] secondArray = {10,11,11};
        int actual = minimalElementArraySortService.compare(firstArray,secondArray);
        int expected =-1;
        assertEquals(actual,expected);
    }
    @Test
    public void testCompareSecondArrayMin() throws JaggedArrayException {
        int[] firstArray = {100,11,11};
        int[] secondArray = {1000,11,11,1};
        int actual = minimalElementArraySortService.compare(firstArray,secondArray);
        int expected = 1;
        assertEquals(actual,expected);
    }
    @Test
    public void testCompareFirstAndSecondArrayEqual() throws JaggedArrayException {
        int[] firstArray = {100,11,11};
        int[] secondArray = {100,11,11};
        int actual = minimalElementArraySortService.compare(firstArray,secondArray);
        int expected = 0;
        assertEquals(actual,expected);
    }

    @Test(expectedExceptions = JaggedArrayException.class)
    public void testCompareFirstAndSecondArrayNullJagArrExc() throws JaggedArrayException {
        int[] firstArray = null;
        int[] secondArray = null;
        minimalElementArraySortService.compare(firstArray,secondArray);
    }

    @Test(expectedExceptions = JaggedArrayException.class)
    public void testCompareFirstArrayNullJagArrExc() throws JaggedArrayException {
        int[] firstArray = null;
        int[] secondArray = {100,11,11};
        minimalElementArraySortService.compare(firstArray,secondArray);
    }

    @Test(expectedExceptions = JaggedArrayException.class)
    public void testCompareSecondArrayNullJagArrExc() throws JaggedArrayException {
        int[] firstArray = {100,11,11};
        int[] secondArray = null;
        minimalElementArraySortService.compare(firstArray,secondArray);
    }


}
