package com.sergeev.task2.entity;

import com.sergeev.task2.exception.JaggedArrayException;
import com.sergeev.task2.service.impl.MaximumElementArrayServiceSortService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JaggedArrayTest {

    private JaggedArray sortJagArrByMaxEl;
    private MaximumElementArrayServiceSortService maximumElementArraySortService;

    @BeforeMethod
    public void setUp() throws JaggedArrayException {
        maximumElementArraySortService = new MaximumElementArrayServiceSortService();
    }

    @Test
    public void testSortingAscendingByMaxElement() throws JaggedArrayException {
        int[][] jagged = {
                {1, 10, 2},
                {9, 8, 12, 25},
                {11, 2, 1, 4},
                {100, 2, 0}
        };
        sortJagArrByMaxEl = new JaggedArray(jagged, maximumElementArraySortService);
        int[][] actual = sortJagArrByMaxEl.sortByAscOrDesc(true);
        int[][] expected = {
                {1, 10, 2},
                {11, 2, 1, 4},
                {9, 8, 12, 25},
                {100, 2, 0},
        };
        assertEquals(actual, expected);
    }

    @Test
    public void testSortingDescendingByMaxElement() throws JaggedArrayException {
        int[][] jagged = {
                {1, 10, 2},
                {9, 8, 12, 25},
                {11, 2, 1, 4},
                {100, 2, 0}
        };
        sortJagArrByMaxEl = new JaggedArray(jagged, maximumElementArraySortService);
        int[][] actual = sortJagArrByMaxEl.sortByAscOrDesc(false);
        int[][] expected = {
                {100, 2, 0},
                {9, 8, 12, 25},
                {11, 2, 1, 4},
                {1, 10, 2},
        };
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = JaggedArrayException.class)
    public void testSortingAscendingNullMatrixJagArrExc() throws JaggedArrayException {
        int[][] matrixNull = null;
        JaggedArray jaggedArray = new JaggedArray(matrixNull, maximumElementArraySortService);
        jaggedArray.sortByAscOrDesc(false);
    }

}
