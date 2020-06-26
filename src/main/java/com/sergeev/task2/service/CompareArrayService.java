package com.sergeev.task2.service;

import com.sergeev.task2.exception.JaggedArrayException;

public interface CompareArrayService {

    int compare(int[] firstArray, int[] secondArray) throws JaggedArrayException;

}
