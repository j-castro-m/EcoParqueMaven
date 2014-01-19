package com.joelcastro.introduccionandroid.activities;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.TextChange;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;
import com.joelcastro.introduccionandroid.R;
import com.joelcastro.introduccionandroid.utils.MyPrefs_;

@EActivity(R.layout.activity_main)
public class LoginActivity extends Activity {


    @Pref MyPrefs_ myPrefs;
    @ViewById(R.id.textUserMain) EditText tusuario;
    @ViewById(R.id.textPassMain) EditText tpass;
    @ViewById(R.id.buttonEnterMain) Button button;

    @AfterViews
    void addTextValues() {
        tusuario.setText(myPrefs.user().get());
        tpass.setText(myPrefs.pass().get());
    }


    @TextChange({R.id.textUserMain,R.id.textPassMain})
    void onUserTextChange(TextView tv, CharSequence text) {
        if((tpass.getText().length()>0)&&(tusuario.getText().length()>0))
        {
            button.setEnabled(true);
        }
        else
        {
            button.setEnabled(false);
        }

    }

    @Click(value = R.id.buttonEnterMain)
    void doButtonEnter() {
        if((tusuario.getText().toString().equals("user"))&&(tpass.getText().toString().equals("pass")))
        {
            myPrefs.user().put( tusuario.getText().toString());
            myPrefs.pass().put( tpass.getText().toString());
            DepositListActivity_.intent(getBaseContext()).flags(Intent.FLAG_ACTIVITY_NEW_TASK).start();
            //startActivity(new Intent(this, DepositListActivity_.class));
            //finish();
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = getString(R.string.bad_login);
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            tusuario.setText("");
            tpass.setText("");
        }

    }





}

