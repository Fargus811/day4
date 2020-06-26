package com.sergeev.day4_2.service;

import com.sergeev.day4_2.exception.JaggedArrayException;

public interface CompareArray {

    int compare(int[] firstArray, int[] secondArray) throws JaggedArrayException;

}
