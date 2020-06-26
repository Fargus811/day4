package com.sergeev.day4_2.entity;

import com.sergeev.day4_2.exception.JaggedArrayException;
import com.sergeev.day4_2.service.CompareArray;

public class JaggedArray {

    private int[][] matrix;
    private CompareArray compareArray;


    public JaggedArray(int[][] matrix, CompareArray compareArray) {
        this.matrix = matrix;
        this.compareArray = compareArray;
    }

    public int[][] sortingAscending() throws JaggedArrayException {
        if (matrix == null && compareArray == null) {
            throw new JaggedArrayException("Matrix is empty");
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int nextRow = 0; nextRow < matrix.length; nextRow++) {
                if (compareArray.compare(matrix[row], matrix[nextRow]) < 0) {
                    jaggedRowSwapper(matrix, row, nextRow);
                }
            }
        }
        return matrix;
    }

    public int[][] sortingDescending() throws JaggedArrayException {
        if (matrix == null && compareArray == null) {
            throw new JaggedArrayException("Matrix is empty");
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int nextRow = 0; nextRow < matrix.length; nextRow++) {
                if (compareArray.compare(matrix[row], matrix[nextRow]) > 0) {
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

