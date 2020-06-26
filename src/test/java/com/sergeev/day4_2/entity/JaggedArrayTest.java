package com.sergeev.day4_2.entity;

import com.sergeev.day4_2.exception.JaggedArrayException;
import com.sergeev.day4_2.service.impl.MaximumElementArrayServiceSortService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JaggedArrayTest {

    JaggedArray sortJagArrByMaxEl;
    MaximumElementArrayServiceSortService maximumElementArraySortService;

    @BeforeMethod
    public void setUp() {
        int[][] jagged = {
                {1, 10, 2},
                {9, 8, 12, 25},
                {11, 2, 1, 4},
                {100, 2, 0}
        };
        maximumElementArraySortService = new MaximumElementArrayServiceSortService();
        sortJagArrByMaxEl = new JaggedArray(jagged, maximumElementArraySortService);
    }

    @Test
    public void testSortingAscendingByMaxElement() throws JaggedArrayException{
        int[][] actual = sortJagArrByMaxEl.sortAscending();
        int[][] expected = {
                {1, 10, 2},
                {11, 2, 1, 4},
                {9, 8, 12, 25},
                {100, 2, 0},
        };
        assertEquals(actual,expected);
    }

    @Test
    public void testSortingDescendingByMaxElement() throws JaggedArrayException {
        int[][] actual = sortJagArrByMaxEl.sortDescending();
        int[][] expected = {
                {100, 2, 0},
                {9, 8, 12, 25},
                {11, 2, 1, 4},
                {1, 10, 2},
        };
        assertEquals(actual,expected);
    }
    @Test(expectedExceptions = JaggedArrayException.class)
    public void testSortingAscendingNullMatrixJagArrExc() throws JaggedArrayException{
        JaggedArray jaggedArray = new JaggedArray(null, maximumElementArraySortService);
        jaggedArray.sortAscending();
    }


}
