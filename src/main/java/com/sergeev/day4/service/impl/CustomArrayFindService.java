package com.sergeev.day4.service.impl;

import com.sergeev.day4.entity.CustomArray;
import com.sergeev.day4.exception.CustomArrayException;
import com.sergeev.day4.service.CustomArrayService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomArrayFindService implements CustomArrayService {


    public int findMax(CustomArray customArray) throws CustomArrayException {
        int[] array = getArray(customArray);
        int max = array[0];
        int maxIndex = 0;
        for (int index = 0; index < array.length; index++) {
            if (array[index] > max) {
                maxIndex = index;
            }
        }
        return array[maxIndex];
    }

    public int findMin(CustomArray customArray) throws CustomArrayException {
        int[] array = getArray(customArray);
        int max = array[0];
        int minIndex = 0;
        for (int index = 0; index < array.length; index++) {
            if (array[index] < max) {
                minIndex = index;
            }
        }
        return array[minIndex];
    }

    public Optional<Integer[]> findSimpleNumbers(CustomArray customArray) throws CustomArrayException {
        int[] array = getArray(customArray);
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
        Integer[] simpleNumbersArray = simpleNumbers.stream().toArray(Integer[]::new);
        return Optional.ofNullable(simpleNumbersArray);
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

    public Optional<Integer[]> findFibonacciNumbers(CustomArray customArray) throws CustomArrayException {
        int[] array = getArray(customArray);
        List<Integer> fibonacciNumbers = new ArrayList<Integer>();
        for (int a : array
        ) {
            if (isFibonacciNumber(a)) {
                fibonacciNumbers.add(a);
            }
        }
        Integer[] simpleNumbersArray = fibonacciNumbers.stream().toArray(Integer[]::new);
        return Optional.ofNullable(simpleNumbersArray);
    }

    private Optional<Integer[]> findNumbersWithThreeDifferentDigits(CustomArray customArray) throws CustomArrayException{
        int[] array = getArray(customArray);
        String number;
        List<Integer> threeDifferentDigitsList = new ArrayList<Integer>();
        for (Integer sourceNumber : array) {
            number = sourceNumber.toString();
            if (number.length() == 3 && number.charAt(0) != number.charAt(1)
                    && number.charAt(1) != number.charAt(2)
                    && number.charAt(0) != number.charAt(2)) {
                threeDifferentDigitsList.add(sourceNumber);
            }
        }
        Integer[] differentDigitsList = threeDifferentDigitsList.stream().toArray(Integer[]::new);
        return Optional.ofNullable(differentDigitsList);
    }

    private boolean isFibonacciNumber(int number) {
        ArrayList<Integer> fibonacciList = createFibonacciNumbers(number);
        return fibonacciList.indexOf(number) != -1;
    }

    private ArrayList<Integer> createFibonacciNumbers(int number) {
        ArrayList<Integer> fibonacciList = new ArrayList<>();
        int sum = 1;
        int nextNumber;
        if (number > 0) {
            nextNumber = 1;
        } else nextNumber = -1;
        fibonacciList.add(0);
        fibonacciList.add(nextNumber);
        for (int i = 2; sum < Math.abs(number); i++) {
            sum = Math.abs(fibonacciList.get(i - 2) +
                    fibonacciList.get(i - 1));
            fibonacciList.add(sum * nextNumber);
        }
        return fibonacciList;
    }
}
