package com.sergeev.day4_2.service.impl;

import com.sergeev.day4_2.exception.JaggedArrayException;
import com.sergeev.day4_2.service.CompareArray;

import java.util.function.Predicate;

public class MaximumElementArraySortService implements CompareArray {

    @Override
    public int compare(int[] firstArray, int[] secondArray) throws JaggedArrayException {
        if (firstArray == null || secondArray == null){
            throw new JaggedArrayException("One of array's is null");
        }
        return Integer.compare(largestValue(firstArray), largestValue(secondArray));
    }

    private int largestValue(int[] array) {
        int largestValue = array[0];
        for(int i = 0; i < array.length; i++) {
            if(largestValue < array[i]) {
                largestValue = array[i];
            }
        }
        return largestValue;
    }

}
