package com.sergeev.day4_2.entity;

import com.sergeev.day4_2.exception.JaggedArrayException;
import com.sergeev.day4_2.service.CompareArrayService;

public class JaggedArray {

    private int[][] matrix;
    private CompareArrayService compareArrayService;


    public JaggedArray(int[][] matrix, CompareArrayService compareArrayService) {
        this.matrix = matrix;
        this.compareArrayService = compareArrayService;
    }

    public int[][] sortingAscending() throws JaggedArrayException {
        if (matrix == null && compareArrayService == null) {
            throw new JaggedArrayException("Matrix is empty");
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int nextRow = 0; nextRow < matrix.length; nextRow++) {
                if (compareArrayService.compare(matrix[row], matrix[nextRow]) < 0) {
                    jaggedRowSwapper(matrix, row, nextRow);
                }
            }
        }
        return matrix;
    }

    public int[][] sortingDescending() throws JaggedArrayException {
        if (matrix == null && compareArrayService == null) {
            throw new JaggedArrayException("Matrix is empty");
        }
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

