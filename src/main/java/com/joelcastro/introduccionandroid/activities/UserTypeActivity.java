package com.joelcastro.introduccionandroid.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.TextChange;
import com.googlecode.androidannotations.annotations.ViewById;
import com.joelcastro.introduccionandroid.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@EActivity(R.layout.activity_usertype)
public class UserTypeActivity extends Activity {

    @ViewById(R.id.userTypeCIF) EditText cif;
    @ViewById(R.id.button_deposito) Button button;
    @ViewById(R.id.rbuttonCompany) RadioButton radioButtonCompany;
    @ViewById(R.id.rbuttonCiudadano) RadioButton radioButtonUser;

    Bundle extra;

    @AfterViews
    void getData(){
        extra = this.getIntent().getExtras();

    }

    @Click(value = R.id.rbuttonCompany)
    public void onCompanyClick() {
        cif.setHint("CIF");
    }


    @Click(value = R.id.rbuttonCiudadano)
    public void onCitizenClick() {
                cif.setHint("NIF");
    }

    @Click(value = R.id.button_deposito)
    public void inSubmitClick(){
        if(((RadioButton) findViewById(R.id.rbuttonCompany)).isChecked())
        {
            Intent intent = new Intent(this, CompanyDataActivity_.class);
            intent.putExtra("cif",cif.getText().toString());
            intent.putExtra("company",true);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(this, TypeAndQuantityActivity_.class);
            intent.putExtra("cif",cif.getText().toString());
            intent.putExtra("company",false);
            startActivity(intent);
        }
    }




        @TextChange({R.id.userTypeCIF})
        void onUserTextChange(TextView tv, CharSequence text) {
                if (valid(cif)) {
                    button.setEnabled(true);
                } else {
                    button.setEnabled(false);
                }
            }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.selection_place, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_desconectar:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(getString(R.string.textSalir))
                        .setCancelable(false)
                        .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new  Intent(getBaseContext(), LoginActivity_.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();}})
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();}});

                AlertDialog alert = builder.create();
                alert.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public boolean valid(TextView tv)
    {

        if(tv.getText().toString().length()==0)
        {
            return false;
        }
        else
        {
            Pattern p2 = Pattern.compile("^[0-9]{8}[a-zA-Z]{1}$");
            Matcher m2 = p2.matcher(tv.getText().toString());
            return m2.matches();
        }


    }

}
