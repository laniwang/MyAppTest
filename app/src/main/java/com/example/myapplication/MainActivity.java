package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    StringUnits mStringUnits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        String songInfor="5b00000001006a000ce4bda0e79a84e8838ce58c850000000" +
        "2006a0009e99988e5a595e8bf8500000003006a00115370656369616c20" +
        "5468616e6b7320546f00000007006a00063233373932335d";
        mStringUnits=new StringUnits();
        mStringUnits.stringbybyte(songInfor);
    }
}
