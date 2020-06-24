package com.sergeev.day4.creator;

import com.sergeev.day4.entity.CustomArray;
import com.sergeev.day4.exception.CustomArrayException;
import com.sergeev.day4.validator.CustomArrayValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ArrayConsoleCreator {

    private static final CustomArrayValidator validator = new CustomArrayValidator();

    public static void main(String[] args) throws CustomArrayException{
        System.out.println(createArrayFromConsole());
    }

    public static Optional<CustomArray> createArrayFromConsole() throws CustomArrayException {
        CustomArray customArray = null;
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = new ArrayList<>();
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            if (validator.isValid(number)) {
                integerList.add(number);
            }
            integerList.add(number);
        }
        int[] arrayToSet = integerList.stream().mapToInt(i -> i).toArray();
        customArray.setNumbers(arrayToSet);
        return Optional.of(customArray);
    }
}
