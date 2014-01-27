package com.joelcastro.introduccionandroid;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by alu03009 on 24/01/14.
 */
public class ecoparque extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        Parse.initialize(this, "odRjmri5FhKQFi2dQyh6hR8t4dyzRpRbEpTEae62", "NbaLF6n1NVUu01Zp4jnmRFumjMejXao5d92QQTCA");
    }
}
