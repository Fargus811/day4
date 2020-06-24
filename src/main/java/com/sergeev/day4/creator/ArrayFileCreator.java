package com.sergeev.day4.creator;

import com.sergeev.day4.entity.CustomArray;
import com.sergeev.day4.exception.CustomArrayException;
import com.sergeev.day4.validator.CustomArrayValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayFileCreator {

    private static final String RELATIVE_PATH_TO_FILE = "src/main/resources/dataArray";

    private static final CustomArrayValidator validator = new CustomArrayValidator();


    public Optional<CustomArray> createArrayFromFile() throws CustomArrayException {
        String numbers = readLineFromFile(RELATIVE_PATH_TO_FILE);
        CustomArray customArray = null;
        List<Integer> integerList = new ArrayList<>();
        String[] numbersToValidate = numbers.split(" ");
        for (String digit : numbersToValidate) {
            int number;
            try {
                number = Integer.parseInt(digit);
            } catch (NumberFormatException e) {
                throw new CustomArrayException("Number is not correct");
            }
            if (validator.isValid(number)) {
                integerList.add(number);
            }
        }
        int[] arrayToSet = integerList.stream().mapToInt(i -> i).toArray();
        customArray = new CustomArray(arrayToSet);
        return Optional.of(customArray);
    }

    private static String readLineFromFile(String pathToFile) throws CustomArrayException {
        String result;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {
            try {
                result = bufferedReader.readLine();
            } catch (IOException e) {
                throw new CustomArrayException("Line in file is empty");
            }
        } catch (IOException e) {
            throw new CustomArrayException("File not found");
        }
        return result;
    }
}

