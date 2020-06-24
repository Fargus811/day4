package com.sergeev.day4.validator;

public class CustomArrayValidator {

    public static final int MAX_VALUE = 999;
    public static final int MIN_VALUE = -999;

    public boolean isValid(int number) {
        return number <= MAX_VALUE && number >= MIN_VALUE;
    }
}
