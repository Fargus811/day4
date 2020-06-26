package com.sergeev.day4_2.service.impl;

import com.sergeev.day4_2.exception.JaggedArrayException;
import com.sergeev.day4_2.service.CompareArrayService;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MaximumElementArrayServiceSortService implements CompareArrayService {

    @Override
    public int compare(int[] firstArray, int[] secondArray) throws JaggedArrayException {
        if (firstArray == null || secondArray == null){
            throw new JaggedArrayException("One of array's is null");
        }
        return Integer.compare(largestValue(firstArray), largestValue(secondArray));
    }

    private int largestValue(int[] array) {
       OptionalInt maxValue = IntStream.of(array).max();
        return maxValue.getAsInt();
    }

}
