package com.sergeev.day4.service;

import com.sergeev.day4.CustomArray.CustomArray;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayService {

    public int findMax(CustomArray customArray) {
        int[] array = customArray.getNumbers();
        int max = array[0];
        int maxIndex = 0;
        for (int index = 0; index < array.length; index++) {
            if (array[index] > max) {
                maxIndex = index;
            }
        }
        return array[maxIndex];
    }

    public int findMin(CustomArray customArray) {
        int[] array = customArray.getNumbers();
        int max = array[0];
        int minIndex = 0;
        for (int index = 0; index < array.length; index++) {
            if (array[index] < max) {
                minIndex = index;
            }
        }
        return array[minIndex];
    }


    public List<Integer> findSimpleNumbers(CustomArray customArray) {
        int[] array = customArray.getNumbers();
        List<Integer> simpleNumbers = new ArrayList<Integer>();
        for (int a : array
        ) {
            if (a == 2) {
                simpleNumbers.add(a);
            }
            if (validateSimpleNumber(a)) {
                simpleNumbers.add(a);
            }
        }
        return simpleNumbers;
    }

    private boolean validateSimpleNumber(int number) {
        boolean isSimple = true;
        if (number < 0) {
            isSimple = false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isSimple = false;
                }
            }
        }
        return isSimple;
    }

    public int binarySearch(int[] sortedArray, int key) {
        int low = 0;
        int high = sortedArray.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public void bubbleSort(CustomArray customArray) {
        int[] array = customArray.getNumbers();
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public void selectionSort(CustomArray customArray) {
        int[] array = customArray.getNumbers();
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

    public void shakerSort(CustomArray customArray) {
        int[] array = customArray.getNumbers();
        int temp;
        int leftSide = 0;
        int rightSide = array.length - 1;
        do {
            for (int i = leftSide; i < rightSide; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            rightSide--;
            for (int i = rightSide; i > leftSide; i--) {
                if (array[i] < array[i - 1]) {
                    temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
            leftSide++;
        } while (leftSide < rightSide);
    }
}
