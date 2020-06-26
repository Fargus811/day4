package com.sergeev.day4_1.service;

import com.sergeev.day4_1.entity.IntArrayWrapper;
import com.sergeev.day4_1.exception.IntArrayWrapperException;

public class IntArrayWrapperSortService {

    public void bubbleSort(IntArrayWrapper intArrayWrapper) throws IntArrayWrapperException {
        int[] array = intArrayWrapper.getCloneArray();
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public void selectionSort(IntArrayWrapper intArrayWrapper) throws IntArrayWrapperException {
        int[] array = intArrayWrapper.getCloneArray();
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;
        }
    }

    public void shakerSort(IntArrayWrapper intArrayWrapper) throws IntArrayWrapperException {
        int[] array = intArrayWrapper.getCloneArray();
        int temp;
        int leftSide = 0;
        int rightSide = array.length - 1;
        do {
            for (int i = leftSide; i < rightSide; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
            rightSide--;
            for (int i = rightSide; i > leftSide; i--) {
                if (array[i] < array[i - 1]) {
                    swap(array, array[i], array[i - 1]);
                }
            }
            leftSide++;
        } while (leftSide < rightSide);
    }

    private void swap(int[] array, int firstIndex, int secondIndex) throws IntArrayWrapperException {
        if (array.length < 1) {
                throw new IntArrayWrapperException("Array is incorrect");
        }
        int tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }
}
