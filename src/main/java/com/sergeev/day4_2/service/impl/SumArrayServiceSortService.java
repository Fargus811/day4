package com.sergeev.day4_2.service.impl;

import com.sergeev.day4_2.exception.JaggedArrayException;
import com.sergeev.day4_2.service.CompareArrayService;

import java.util.stream.IntStream;

public class SumArrayServiceSortService implements CompareArrayService {

    @Override
    public int compare(int[] firstArray, int[] secondArray)throws JaggedArrayException {
        if (firstArray == null || secondArray == null){
            throw new JaggedArrayException("One of array's is null");
        }
        return Integer.compare(sumOfArray(firstArray), sumOfArray(secondArray));
    }

    private int sumOfArray(int[] array) {
        return IntStream.of(array).sum();
    }
}
