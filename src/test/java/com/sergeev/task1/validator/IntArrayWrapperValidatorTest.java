package com.sergeev.task1.validator;

import com.sergeev.task1.entity.IntArrayWrapper;
import com.sergeev.task1.exception.IntArrayWrapperException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class IntArrayWrapperValidatorTest {

    private IntArrayWrapperValidator intArrayWrapperValidator;

    @BeforeMethod
    public void setUp() {
        intArrayWrapperValidator = new IntArrayWrapperValidator();
    }

    @Test
    public void testIsValidPositive() {
        assertTrue(intArrayWrapperValidator.isValid(100));
    }

    @Test
    public void testIsValidNegative() {
        assertFalse(intArrayWrapperValidator.isValid(1000));
    }

    @Test
    public void testIsArrayValidPositive() throws IntArrayWrapperException {
        IntArrayWrapper intArrayWrapper = new IntArrayWrapper(new int[]{5, 6, 7});
        intArrayWrapperValidator.isArrayValid(intArrayWrapper);
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testIsArrayValidNegative() throws IntArrayWrapperException {
        IntArrayWrapper intArrayWrapper = new IntArrayWrapper(new int[0]);
        intArrayWrapperValidator.isArrayValid(intArrayWrapper);
    }
}
