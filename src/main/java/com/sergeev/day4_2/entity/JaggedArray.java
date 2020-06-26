package com.sergeev.day4_2.entity;

import com.sergeev.day4_2.exception.JaggedArrayException;
import com.sergeev.day4_2.service.CompareArrayService;
import com.sergeev.day4_2.validator.JaggedArrayValidator;

public class JaggedArray {

    private static final JaggedArrayValidator jaggedValidator = new JaggedArrayValidator();
    private int[][] matrix;
    private CompareArrayService compareArrayService;


    public JaggedArray(int[][] matrix, CompareArrayService compareArrayService) {
        this.matrix = matrix;
        this.compareArrayService = compareArrayService;
    }

    public int[][] sortAscending() throws JaggedArrayException {
        jaggedValidator.isMatrixAndServiceValid(matrix, compareArrayService);
        for (int row = 0; row < matrix.length; row++) {
            for (int nextRow = 0; nextRow < matrix.length; nextRow++) {
                if (compareArrayService.compare(matrix[row], matrix[nextRow]) < 0) {
                    jaggedRowSwapper(matrix, row, nextRow);
                }
            }
        }
        return matrix;
    }

    public int[][] sortDescending() throws JaggedArrayException {
        jaggedValidator.isMatrixAndServiceValid(matrix, compareArrayService);
        for (int row = 0; row < matrix.length; row++) {
            for (int nextRow = 0; nextRow < matrix.length; nextRow++) {
                if (compareArrayService.compare(matrix[row], matrix[nextRow]) > 0) {
                    jaggedRowSwapper(matrix, row, nextRow);
                }
            }
        }
        return matrix;
    }

    private void jaggedRowSwapper(int[][] jagged, int rowLength, int nextRowLength) {
        int[] jaggedArrayRowSwap = jagged[nextRowLength];
        jagged[nextRowLength] = jagged[rowLength];
        jagged[rowLength] = jaggedArrayRowSwap;
    }

}

