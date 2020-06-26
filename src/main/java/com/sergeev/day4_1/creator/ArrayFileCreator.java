package com.sergeev.day4_1.creator;

import com.sergeev.day4_1.entity.IntArrayWrapper;
import com.sergeev.day4_1.exception.IntArrayWrapperException;
import com.sergeev.day4_1.validator.IntArrayWrapperValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayFileCreator {

    private static final String RELATIVE_PATH_TO_FILE = "src/main/resources/dataArray";

    private static final IntArrayWrapperValidator validator = new IntArrayWrapperValidator();

    public Optional<IntArrayWrapper> createArrayFromFile() throws IntArrayWrapperException {
        String numbers = readLineFromFile(RELATIVE_PATH_TO_FILE);
        IntArrayWrapper intArrayWrapper = null;
        List<Integer> integerList = new ArrayList<>();
        String[] numbersToValidate = numbers.split(" ");
        for (String digit : numbersToValidate) {
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
        return Optional.of(intArrayWrapper);
    }

    private static String readLineFromFile(String pathToFile) throws IntArrayWrapperException {
        String result;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {
            try {
                result = bufferedReader.readLine();
            } catch (IOException e) {
                throw new IntArrayWrapperException("Line in file is empty");
            }
        } catch (IOException e) {
            throw new IntArrayWrapperException("File not found");
        }
        return result;
    }
}

