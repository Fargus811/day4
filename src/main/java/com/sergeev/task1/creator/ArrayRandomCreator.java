package com.sergeev.task1.creator;

import com.sergeev.task1.entity.IntArrayWrapper;
import com.sergeev.task1.exception.IntArrayWrapperException;

import java.util.Random;

public class ArrayRandomCreator {

    private static final int RANDOM_NUMBER_OF_ARRAY = 900;
    private static final Random random = new Random();

    public IntArrayWrapper createRandomIntArrayWrapper(int maxSizeOfArray) throws IntArrayWrapperException {
        if (maxSizeOfArray < 1) {
            throw new IntArrayWrapperException("Invalid size");
        }
        int length = random.nextInt(maxSizeOfArray);
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(RANDOM_NUMBER_OF_ARRAY);
        }
        return new IntArrayWrapper(array);
    }
}
