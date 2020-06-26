package com.sergeev.day4_1.validator;

public class CustomArrayValidator {

    private static final int MAX_VALUE = 999;
    private static final int MIN_VALUE = -999;

    public boolean isValid(int number) {
        return number <= MAX_VALUE && number >= MIN_VALUE;
    }
}
