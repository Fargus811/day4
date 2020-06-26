package com.sergeev.day4_2.service.impl;

import com.sergeev.day4_2.exception.JaggedArrayException;
import com.sergeev.day4_2.service.CompareArrayService;
import com.sergeev.day4_2.validator.JaggedArrayValidator;

import java.util.stream.IntStream;

public class SumArrayServiceSortService implements CompareArrayService {

    private static final JaggedArrayValidator jaggedValidator = new JaggedArrayValidator();

    @Override
    public int compare(int[] firstArray, int[] secondArray) throws JaggedArrayException {
        jaggedValidator.isArraysValid(firstArray, secondArray);
        return Integer.compare(sumOfArray(firstArray), sumOfArray(secondArray));
    }

    private int sumOfArray(int[] array) {
        return IntStream.of(array).sum();
    }
}
