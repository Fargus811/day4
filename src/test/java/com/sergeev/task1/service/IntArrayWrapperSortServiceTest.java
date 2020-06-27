package com.sergeev.task1.service;

import com.sergeev.task1.entity.IntArrayWrapper;
import com.sergeev.task1.exception.IntArrayWrapperException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class IntArrayWrapperSortServiceTest {

    private IntArrayWrapperSortService intArrayWrapperSortService;
    private IntArrayWrapper intArrayWrapper;

    @BeforeMethod
    public void setUp() {
        intArrayWrapperSortService = new IntArrayWrapperSortService();
    }

    @Test
    public void testBubbleSort() throws IntArrayWrapperException {
        intArrayWrapper = new IntArrayWrapper(new int[]{5, 8, 7});
        IntArrayWrapper actual = intArrayWrapperSortService.bubbleSort(intArrayWrapper);
        IntArrayWrapper expected = new IntArrayWrapper(new int[]{5, 7, 8});
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testBubbleSortInZeroArrayIntArrayIntArrWrapExc() throws IntArrayWrapperException {
        intArrayWrapperSortService.bubbleSort(new IntArrayWrapper(new int[0]));
    }

    @Test
    public void testSelectionSort() throws IntArrayWrapperException {
        intArrayWrapper = new IntArrayWrapper(new int[]{5, 8, 7});
        IntArrayWrapper actual = intArrayWrapperSortService.selectionSort(intArrayWrapper);
        IntArrayWrapper expected = new IntArrayWrapper(new int[]{5, 7, 8});
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testSelectionSortInEmptyArrayIntArrayIntArrWrapExc() throws IntArrayWrapperException {
        intArrayWrapperSortService.selectionSort(new IntArrayWrapper(new int[0]));
    }

    @Test
    public void testShakerSort() throws IntArrayWrapperException {
        intArrayWrapper = new IntArrayWrapper(new int[]{5, 8, 7});
        IntArrayWrapper actual = intArrayWrapperSortService.shakerSort(intArrayWrapper);
        IntArrayWrapper expected = new IntArrayWrapper(new int[]{5, 7, 8});
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testShakerSortInEmptyArrayIntArrayIntArrWrapExc() throws IntArrayWrapperException {
        intArrayWrapperSortService.shakerSort(new IntArrayWrapper(new int[0]));
    }
}
