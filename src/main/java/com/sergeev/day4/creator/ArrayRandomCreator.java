package com.sergeev.day4.creator;

import com.sergeev.day4.entity.CustomArray;

import java.util.Random;

public class ArrayRandomCreator {

    private static final Random random = new Random();

    public CustomArray createRandomCustomArray() {
        int size = random.nextInt(20);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return new CustomArray(array);
    }
}
