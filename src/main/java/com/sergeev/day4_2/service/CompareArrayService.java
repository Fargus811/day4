package com.sergeev.day4_2.service;

import com.sergeev.day4_2.exception.JaggedArrayException;

public interface CompareArrayService {

    int compare(int[] firstArray, int[] secondArray) throws JaggedArrayException;

}
