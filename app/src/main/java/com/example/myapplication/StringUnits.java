package com.example.myapplication;

import java.util.Arrays;


public class StringUnits {
    String songInfo="";

    public StringUnits() {
    }


    public String[] stringbybyte(String songInfor){
//        String songInfor="5b00000001006a000ce4bda0e79a84e8838ce58c850000000" +
//                "2006a0009e99988e5a595e8bf8500000003006a00115370656369616c20" +
//                "5468616e6b7320546f00000007006a00063233373932335d";
        if(songInfor==null||songInfor.equals( "" )){
            return null;
        }

        String[] si=new String[songInfor.length()/2];

        int j=0;
        for(int i=0;i<songInfor.length();i=i+2 ){
            String subStr=songInfor.substring( i,i+2 );

            si[j]="0x"+subStr;
            System.out.println(subStr);
            j++;
        }
        String str = "5b";

        int a = Integer.parseInt(str,16);
        System.out.println( Arrays.toString( si ));
        return si;
    }
}
