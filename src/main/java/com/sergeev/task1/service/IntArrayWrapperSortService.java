package com.sergeev.task1.service;

import com.sergeev.task1.entity.IntArrayWrapper;
import com.sergeev.task1.exception.IntArrayWrapperException;
import com.sergeev.task1.validator.IntArrayWrapperValidator;

import java.util.Optional;

public class IntArrayWrapperSortService {

    private static final IntArrayWrapperValidator validator = new IntArrayWrapperValidator();

    public IntArrayWrapper bubbleSort(IntArrayWrapper intArrayWrapper) throws IntArrayWrapperException {
        validator.isArrayValid(intArrayWrapper);
        int[] array = intArrayWrapper.getCloneArray();
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return new IntArrayWrapper(array);
    }

    public IntArrayWrapper selectionSort(IntArrayWrapper intArrayWrapper) throws IntArrayWrapperException {
        validator.isArrayValid(intArrayWrapper);
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
        return new IntArrayWrapper(array);
    }

    public IntArrayWrapper shakerSort(IntArrayWrapper intArrayWrapper) throws IntArrayWrapperException {
        validator.isArrayValid(intArrayWrapper);
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
        return new IntArrayWrapper(array);
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
