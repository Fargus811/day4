package com.sergeev.task1.creator;

import com.sergeev.task1.entity.IntArrayWrapper;
import com.sergeev.task1.exception.IntArrayWrapperException;
import com.sergeev.task1.validator.IntArrayWrapperValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayFileCreator {

    private static final String SEPARATOR = " ";
    private static final IntArrayWrapperValidator validator = new IntArrayWrapperValidator();

    public Optional<IntArrayWrapper> createArrayFromFile(String pathToFile) throws IntArrayWrapperException {
        String numbers = readLineFromFile(pathToFile);
        if (numbers == null) {
            throw new IntArrayWrapperException("Line is empty");
        }
        IntArrayWrapper intArrayWrapper = null;
        List<Integer> integerList = new ArrayList<>();
        String[] numbersLine = numbers.split(SEPARATOR);
        for (String digit : numbersLine) {
            int number;
            try {
                number = Integer.parseInt(digit);
            } catch (NumberFormatException e) {
                throw new IntArrayWrapperException("Number is not correct");
            }
            if (validator.isValid(number)) {
                integerList.add(number);
            }
        }
        int[] arrayToSet = integerList.stream().mapToInt(i -> i).toArray();
        intArrayWrapper = new IntArrayWrapper(arrayToSet);
        return Optional.ofNullable(intArrayWrapper);
    }

    private static String readLineFromFile(String pathToFile) throws IntArrayWrapperException {
        String result;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {
            result = bufferedReader.readLine();
        } catch (IOException e) {
            throw new IntArrayWrapperException("File not found");
        }
        return result;
    }
}

