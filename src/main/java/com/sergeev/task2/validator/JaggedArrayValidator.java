package com.sergeev.task2.validator;

import com.sergeev.task2.exception.JaggedArrayException;
import com.sergeev.task2.service.CompareArrayService;

public class JaggedArrayValidator {

    public void isArraysValid(int[] firstArray, int[] secondArray) throws JaggedArrayException {
        if (firstArray == null || secondArray == null) {
            throw new JaggedArrayException("One of array's is null");
        }
    }

    public void isMatrixAndServiceValid(int[][] matrix, CompareArrayService compareArrayService) throws JaggedArrayException {
        if (matrix == null || compareArrayService == null) {
            throw new JaggedArrayException("Matrix is empty");
        }
    }
}
