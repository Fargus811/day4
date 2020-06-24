package com.sergeev.day4.creator;

import com.sergeev.day4.entity.CustomArray;
import com.sergeev.day4.validator.CustomArrayValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ArrayConsoleCreator {

    private static final CustomArrayValidator validator = new CustomArrayValidator();

    public Optional<CustomArray> createArrayFromConsole() {
        CustomArray customArray = null;
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = new ArrayList<>();
        System.out.print("Enter integers separated by spaces. To end, type \"exit\": ");
        while (true) {
            String number = scanner.next();
            int digit = -1000;
            if (number.equals("exit")) {
                break;
            } else {
                try {
                    digit = Integer.parseInt(number);
                } catch (NumberFormatException e) {
                    System.out.print("Invalid format. Repeat entry: ");
                }
                if (validator.isValid(digit)) {
                    integerList.add(digit);
                }
            }
        }
        int[] arrayToSet = integerList.stream().mapToInt(i -> i).toArray();
        if (arrayToSet.length != 0) {
            customArray = new CustomArray(arrayToSet);
        }
        return Optional.of(customArray);
    }
}
