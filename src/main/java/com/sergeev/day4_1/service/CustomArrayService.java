package com.sergeev.day4_1.service;

import com.sergeev.day4_1.entity.CustomArray;
import com.sergeev.day4_1.exception.CustomArrayException;

public interface CustomArrayService {

    default int[] getArray(CustomArray customArray) throws CustomArrayException {
        int[] array = new int[customArray.getSize()];
        for (int i = 0; i <customArray.getSize() ; i++) {
            array[i] = customArray.get(i);
        }
        return array;
    }
}
