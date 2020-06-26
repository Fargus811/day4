package com.sergeev.day4_1.creator;

import com.sergeev.day4_1.entity.IntArrayWrapper;
import com.sergeev.day4_1.exception.IntArrayWrapperException;
import com.sergeev.day4_1.validator.IntArrayWrapperValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ArrayConsoleCreator {

    private static final IntArrayWrapperValidator validator = new IntArrayWrapperValidator();

    public Optional<IntArrayWrapper> createArrayFromConsole() throws IntArrayWrapperException {
        IntArrayWrapper intArrayWrapper = null;
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
            intArrayWrapper = new IntArrayWrapper(arrayToSet);
        }
        return Optional.of(intArrayWrapper);
    }
}
