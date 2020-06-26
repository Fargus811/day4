package com.sergeev.task1.validator;

import com.sergeev.task1.entity.IntArrayWrapper;
import com.sergeev.task1.exception.IntArrayWrapperException;

public class IntArrayWrapperValidator {

    private static final int MAX_VALUE = 999;
    private static final int MIN_VALUE = -999;

    public boolean isValid(int number) {
        return number <= MAX_VALUE && number >= MIN_VALUE;
    }

    public void isArrayValid(IntArrayWrapper intArrayWrapper) throws IntArrayWrapperException {
        if (intArrayWrapper.getCloneArray().length <= 0) {
            throw new IntArrayWrapperException("Array is empty");
        }
    }
}
