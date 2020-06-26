package com.sergeev.day4_1.creator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayConsoleCreatorTest {

    private ArrayConsoleCreator arrayConsoleCreator;

    @BeforeMethod
    public void setUp() {
        arrayConsoleCreator = new ArrayConsoleCreator();
    }

    @Test
    public void testCreateArrayFromConsole() {
    }
}
