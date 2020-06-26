package com.sergeev.day4_1.creator;

import com.sergeev.day4_1.entity.IntArrayWrapper;

import java.util.Random;

public class ArrayRandomCreator {

    private static final int RANDOM_SIZE_OF_ARRAY = 20;
    private static final int RANDOM_NUMBER_OF_ARRAY = 999;
    private static final Random random = new Random();

    public IntArrayWrapper createRandomCustomArray() {
        int size = random.nextInt(RANDOM_SIZE_OF_ARRAY);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(RANDOM_NUMBER_OF_ARRAY);
        }
        return new IntArrayWrapper(array);
    }
}
