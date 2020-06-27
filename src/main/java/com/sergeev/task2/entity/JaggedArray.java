package com.sergeev.task2.entity;

import com.sergeev.task2.exception.JaggedArrayException;
import com.sergeev.task2.service.CompareArrayService;
import com.sergeev.task2.validator.JaggedArrayValidator;

public class JaggedArray {

    private static final JaggedArrayValidator jaggedValidator = new JaggedArrayValidator();
    private int[][] matrix;
    private CompareArrayService compareArrayService;

    public JaggedArray(int[][] matrix, CompareArrayService compareArrayService) throws JaggedArrayException {
        jaggedValidator.isMatrixAndServiceValid(matrix, compareArrayService);
        this.matrix = matrix;
        this.compareArrayService = compareArrayService;
    }

    public int[][] sortByAscOrDesc(boolean isAscending) throws JaggedArrayException {
        jaggedValidator.isMatrixAndServiceValid(matrix, compareArrayService);
        for (int row = 0; row < matrix.length; row++) {
            for (int nextRow = 0; nextRow < matrix.length; nextRow++) {
                if (compareArrayService.compare(matrix[row], matrix[nextRow]) * typeSort(isAscending) < 0) {
                    rowSwapper(matrix, row, nextRow);
                }
            }
        }
        return matrix;
    }

    private int typeSort(boolean isAscending) {
        if (!isAscending) {
            return -1;
        }
        return 1;
    }

    private void rowSwapper(int[][] jagged, int rowLength, int nextRowLength) {
        int[] jaggedArrayRowSwap = jagged[nextRowLength];
        jagged[nextRowLength] = jagged[rowLength];
        jagged[rowLength] = jaggedArrayRowSwap;
    }
}

