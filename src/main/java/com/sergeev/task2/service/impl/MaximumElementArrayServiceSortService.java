package com.sergeev.task2.service.impl;

import com.sergeev.task2.exception.JaggedArrayException;
import com.sergeev.task2.service.CompareArrayService;
import com.sergeev.task2.validator.JaggedArrayValidator;

import java.util.stream.IntStream;

public class MaximumElementArrayServiceSortService implements CompareArrayService {

    private static final JaggedArrayValidator jaggedValidator = new JaggedArrayValidator();

    @Override
    public int compare(int[] firstArray, int[] secondArray) throws JaggedArrayException {
        jaggedValidator.isArraysValid(firstArray, secondArray);
        return Integer.compare(maxValue(firstArray), maxValue(secondArray));
    }

    private int maxValue(int[] array) {
        return IntStream.of(array).max().getAsInt();
    }
}
