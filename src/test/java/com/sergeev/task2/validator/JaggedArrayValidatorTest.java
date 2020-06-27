package com.sergeev.task2.validator;

import com.sergeev.task2.exception.JaggedArrayException;
import com.sergeev.task2.service.CompareArrayService;
import com.sergeev.task2.service.impl.MaximumElementArrayServiceSortService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JaggedArrayValidatorTest {

    private JaggedArrayValidator jaggedArrayValidator;
    private CompareArrayService compareArrayService;

    @BeforeMethod
    public void setUp() {
        jaggedArrayValidator = new JaggedArrayValidator();
        compareArrayService = new MaximumElementArrayServiceSortService();
    }

    @Test
    public void testIsArraysValidPositive() throws JaggedArrayException {
        int[] correctFirstArray = {1, 10, 2};
        int[] correctSecondArray = {11, 2, 1, 4};
        jaggedArrayValidator.isArraysValid(correctFirstArray, correctSecondArray);
    }

    @Test(expectedExceptions = JaggedArrayException.class)
    public void testIsArraysValidNullFirstArrayJaggArrExc() throws JaggedArrayException {
        int[] correctFirstArray = null;
        int[] correctSecondArray = {11, 2, 1, 4};
        jaggedArrayValidator.isArraysValid(correctFirstArray, correctSecondArray);
    }

    @Test
    public void testIsMatrixAndServiceValidPositive() throws JaggedArrayException {
        int[][] correctMatrix = {
                {1, 10, 2},
                {11, 2, 1, 4},
                {9, 8, 12, 25},
                {100, 2, 0},
        };
        jaggedArrayValidator.isMatrixAndServiceValid(correctMatrix, compareArrayService);
    }

    @Test(expectedExceptions = JaggedArrayException.class)
    public void testIsMatrixAndServiceValidNullMatrix() throws JaggedArrayException {
        int[][] correctMatrix = null;
        jaggedArrayValidator.isMatrixAndServiceValid(correctMatrix, compareArrayService);
    }
}
