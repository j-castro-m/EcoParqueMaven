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
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
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

    @Click(value = R.id.buttonEnterMain)
    void doButtonEnter() {
        if((tusuario.getText().toString().equals("user"))&&(tpass.getText().toString().equals("pass")))
        {
            myPrefs.user().put( tusuario.getText().toString());
            myPrefs.pass().put( tpass.getText().toString());
            Intent intent = new Intent(getBaseContext(), DepositListActivity_.class);
            startActivity(intent);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);


        String user = myPrefs.user().get();
        String pass = myPrefs.pass().get();

        tusuario.setText(user);
        tpass.setText(pass);


 /*       button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if((tusuario.getText().toString().equals("user"))&&(tpass.getText().toString().equals("pass")))
                {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("usuario", tusuario.getText().toString());
                    editor.putString("pass", tpass.getText().toString());
                    editor.commit();
                    Intent intent = new Intent(getBaseContext(), DepositListActivity_.class);
                    startActivity(intent);
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
        });*/


        tusuario.addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if((tpass.getText().length()>0)&&(tusuario.getText().length()>0))
                    {
                        button.setEnabled(true);
                    }
                    else
                    {
                        button.setEnabled(false);
                    }

                }
            }
            );


        tpass.addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if((tpass.getText().length()>0)&&(tusuario.getText().length()>0))
                    {
                        button.setEnabled(true);
                    }
                    else
                    {
                        button.setEnabled(false);
                    }

                }
            }
            );



        }
};
