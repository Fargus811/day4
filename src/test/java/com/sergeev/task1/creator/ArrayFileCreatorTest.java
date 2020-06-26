package com.sergeev.task1.creator;

import com.sergeev.task1.entity.IntArrayWrapper;
import com.sergeev.task1.exception.IntArrayWrapperException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayFileCreatorTest {

    private static final String RELATIVE_PATH_TO_FILE = "src/main/resources/dataArray";
    private ArrayFileCreator arrayFileCreator;

    @BeforeMethod
    public void setUp() {
        arrayFileCreator = new ArrayFileCreator();
    }

    @Test
    public void testCreateArrayFromFilePositive() throws IntArrayWrapperException {
        IntArrayWrapper expected = new IntArrayWrapper(new int[]{1, 2, 3, 4, 5});
        IntArrayWrapper actual = arrayFileCreator.createArrayFromFile(RELATIVE_PATH_TO_FILE).get();
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = IntArrayWrapperException.class)
    public void testCreateArrayFromNotFoundFile() throws IntArrayWrapperException {
        arrayFileCreator.createArrayFromFile("data.txt").get();
    }


}
