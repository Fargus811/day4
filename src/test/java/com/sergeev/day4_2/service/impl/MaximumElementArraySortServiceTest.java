package com.sergeev.day4_2.service.impl;

import com.sergeev.day4_2.exception.JaggedArrayException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MaximumElementArraySortServiceTest {

    private MaximumElementArrayServiceSortService maximumElementArraySortService;

    @BeforeMethod
    public void setUp() {
        maximumElementArraySortService = new MaximumElementArrayServiceSortService();
    }

    @Test
    public void testCompareFirstArrayMore() throws JaggedArrayException {
        int[] firstArray = {100, 11, 11};
        int[] secondArray = {10, 11, 11};
        int actual = maximumElementArraySortService.compare(firstArray, secondArray);
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void testCompareSecondArrayMore() throws JaggedArrayException {
        int[] firstArray = {100, 11, 11};
        int[] secondArray = {1000, 11, 11};
        int actual = maximumElementArraySortService.compare(firstArray, secondArray);
        int expected = -1;
        assertEquals(actual, expected);
    }

    @Test
    public void testCompareFirstAndSecondArrayEqual() throws JaggedArrayException {
        int[] firstArray = {100, 11, 11};
        int[] secondArray = {100, 11, 11};
        int actual = maximumElementArraySortService.compare(firstArray, secondArray);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = JaggedArrayException.class)
    public void testCompareFirstAndSecondArrayNullJagArrExc() throws JaggedArrayException {
        int[] firstArray = null;
        int[] secondArray = null;
        maximumElementArraySortService.compare(firstArray, secondArray);
    }

    @Test(expectedExceptions = JaggedArrayException.class)
    public void testCompareFirstArrayNullJagArrExc() throws JaggedArrayException {
        int[] firstArray = null;
        int[] secondArray = {100, 11, 11};
        maximumElementArraySortService.compare(firstArray, secondArray);
    }

    @Test(expectedExceptions = JaggedArrayException.class)
    public void testCompareSecondArrayNullJagArrExc() throws JaggedArrayException {
        int[] firstArray = {100, 11, 11};
        int[] secondArray = null;
        maximumElementArraySortService.compare(firstArray, secondArray);
    }
}
