package com.joelcastro.introduccionandroid.utils;

import com.googlecode.androidannotations.annotations.sharedpreferences.DefaultInt;
import com.googlecode.androidannotations.annotations.sharedpreferences.DefaultString;
import com.googlecode.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by alu03009 on 18/01/14.
 */
@SharedPref
public interface MyPrefs {

    // The field name will have default value "John"
    @DefaultString("")
    String user();

    // The field age will have default value 42
    @DefaultString("")
    String pass();

    // The field lastUpdated will have default value 0
    long lastUpdated();

}