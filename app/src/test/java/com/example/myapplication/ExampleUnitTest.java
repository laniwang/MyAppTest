package com.example.myapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private StringUnits stringUnits;

    @Before
    public void setUp() throws Exception {
        stringUnits=new StringUnits();

    }

    @After
    public void tearDown() throws Exception {
        stringUnits=null;

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return null;
    }

    @Test
    public void addition_isCorrect() {
        assertEquals( 4, 2 + 2 );
    }

    @Test
    public void testStringbyyte() {

    }


}