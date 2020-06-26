package com.sergeev.day4_2.service.impl;

import com.sergeev.day4_2.exception.JaggedArrayException;
import com.sergeev.day4_2.service.CompareArray;

public class MinimalElementArraySortService implements CompareArray {
    @Override
    public int compare(int[] firstArray, int[] secondArray)throws JaggedArrayException {
        if (firstArray == null || secondArray == null){
            throw new JaggedArrayException("One of array's is null");
        }
        return Integer.compare(minimalValue(firstArray), minimalValue(secondArray));
    }

    private int minimalValue(int[] array) {
        int smallestValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (smallestValue > array[i]) {
                smallestValue = array[i];
            }
        }
        return smallestValue;
    }


}
