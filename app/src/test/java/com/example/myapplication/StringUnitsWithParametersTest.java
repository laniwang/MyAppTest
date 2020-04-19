package com.example.myapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class StringUnitsWithParametersTest {

    private static String infoTest="5b00000001006a000ce4bda0e79a84e8838ce58c850000000" +
                "2006a0009e99988e5a595e8bf8500000003006a00115370656369616c20" +
                "5468616e6b7320546f00000007006a00063233373932335d";
    private final String infoStr;


    public String stringinfos; //用data()中索引为0的数据初始化，注意
    private final String[] expectResult;
    private StringUnits stringUnits;


    public StringUnitsWithParametersTest(String strInfo, String[] expectResult) {
        this.infoStr=strInfo;
        this.expectResult=expectResult;
    }

    @Before
    public void setUp() throws Exception {
        stringUnits=new StringUnits();
    }

    @Test
    public void testStringbyByte() {
        String[] otp=stringUnits.stringbybyte(stringinfos);
        System.out.println(otp);
        assertEquals(expectResult,otp);

    }

    @After
    public void tearDown() throws Exception {
        stringUnits=null;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data(){
        return Arrays.asList(new Object[][]{
            {"5b5d",null},
                {"",null},
                {"5b00000001006a000ce4bda0e79a84e8838ce58c850000000","e4bda0e79a84e8838ce58c8"},
        });
    }
}
