package com.sergeev.task1.service;

import com.sergeev.task1.entity.IntArrayWrapper;
import com.sergeev.task1.exception.IntArrayWrapperException;
import com.sergeev.task1.validator.IntArrayWrapperValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class IntArrayWrapperFindService {

    private static final IntArrayWrapperValidator validator = new IntArrayWrapperValidator();

    public int findMax(IntArrayWrapper intArrayWrapper) throws IntArrayWrapperException {
        validator.isArrayValid(intArrayWrapper);
        int[] array = intArrayWrapper.getCloneArray();
        return IntStream.of(array).max().getAsInt();
    }

    public int findMin(IntArrayWrapper intArrayWrapper) throws IntArrayWrapperException {
        validator.isArrayValid(intArrayWrapper);
        int[] array = intArrayWrapper.getCloneArray();
        return IntStream.of(array).min().getAsInt();
    }

    public Optional<Integer[]> findSimpleNumbers(IntArrayWrapper intArrayWrapper) throws IntArrayWrapperException {
        validator.isArrayValid(intArrayWrapper);
        int[] array = intArrayWrapper.getCloneArray();
        List<Integer> simpleNumbers = new ArrayList<Integer>();
        for (int a : array) {
            if (a == 2) {
                simpleNumbers.add(a);
            }
            if (isSimpleNumber(a)) {
                simpleNumbers.add(a);
            }
        }
        Integer[] simpleNumbersArray = simpleNumbers.stream().toArray(Integer[]::new);
        return Optional.ofNullable(simpleNumbersArray);
    }

    private boolean isSimpleNumber(int number) {
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

    public int binarySearch(int[] sortedArray, int key) throws IntArrayWrapperException {
        if (sortedArray == null) {
            throw new IntArrayWrapperException("Sorted Array is null");
        }
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

    public Optional<Integer[]> findFibonacciNumbers(IntArrayWrapper intArrayWrapper) throws IntArrayWrapperException {
        validator.isArrayValid(intArrayWrapper);
        int[] array = intArrayWrapper.getCloneArray();
        List<Integer> fibonacciNumbers = new ArrayList<Integer>();
        for (int a : array) {
            if (isFibonacciNumber(a)) {
                fibonacciNumbers.add(a);
            }
        }
        Integer[] simpleNumbersArray = fibonacciNumbers.stream().toArray(Integer[]::new);
        return Optional.ofNullable(simpleNumbersArray);
    }

    public Optional<Integer[]> findNumbersWithThreeDifferentDigits(IntArrayWrapper intArrayWrapper) throws IntArrayWrapperException {
        validator.isArrayValid(intArrayWrapper);
        int[] array = intArrayWrapper.getCloneArray();
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

    //The natural number N is the Fibonacci number when 5 * N ^ 2 + 4 or 5 * N ^ 2 + 4 is the square
    private boolean isFibonacciNumber(int number) {
        long resultFirst = (long) (5 * Math.pow(number, 2) + 4);
        long resultSecond = (long) (5 * Math.pow(number, 2) - 4);
        return isPerfectSquare(resultFirst) || isPerfectSquare(resultSecond);
    }

    private boolean isPerfectSquare(long number) {
        if (number < 0) {
            return false;
        }
        long squareRoot = (long) (Math.sqrt(number) + 0.5);
        return squareRoot * squareRoot == number;
    }
}
