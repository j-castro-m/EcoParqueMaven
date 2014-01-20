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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.TextChange;
import com.googlecode.androidannotations.annotations.ViewById;
import com.joelcastro.introduccionandroid.R;

@EActivity(R.layout.activity_typeandquantity)
public class TypeAndQuantityActivity extends Activity {


     @ViewById(R.id.textWeightCData2) EditText peso;
     @ViewById(R.id.textCIFCData2) EditText cif;

     @ViewById(R.id.button_deposite) Button button;

     @ViewById(R.id.checkBoxIT) CheckBox checkBoxIT;
     @ViewById(R.id.checkBoxFridge) CheckBox checkBoxFridge;
     @ViewById(R.id.checkBoxOil) CheckBox checkBoxOil;

     Bundle extra;

        @AfterViews
        void setDataonView(){
        extra = this.getIntent().getExtras();
        cif.setText(extra.getString("cif"));
        }

        @Click(value={R.id.checkBoxIT,R.id.checkBoxFridge,R.id.checkBoxOil})
        void onClickCehackBox(){
            checkMarkers(checkBoxIT, checkBoxFridge, checkBoxOil, button, peso);
        }


         @TextChange(value=R.id.textWeightCData2)
         void onWeightTextChange(TextView tv, CharSequence text) {
             checkMarkers(checkBoxIT, checkBoxFridge, checkBoxOil,button,peso);
         }


       @Click(value=R.id.button_deposite)
       void onClickDeposite(){
           Intent intent = new Intent(getBaseContext(), ResultsActivity_.class);
           intent.putExtra("cif",cif.getText().toString());
           intent.putExtra("ITmat", checkBoxIT.isChecked());
           intent.putExtra("Fridge", checkBoxFridge.isChecked());
           intent.putExtra("Oil", checkBoxOil.isChecked());
           intent.putExtra("Peso",peso.getText().toString());
           intent.putExtra("company",extra.getBoolean("company"));
           intent.putExtra("email",extra.getString("email"));
           startActivity(intent);
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

    public void checkMarkers(CheckBox cbit, CheckBox cbfg, CheckBox cboil, Button button, EditText et){

        if(cbit.isChecked()||cbfg.isChecked()||cboil.isChecked())
        {
            et.setEnabled(true);
        }
        else
        {
            et.setEnabled(false);
        }

        if(et.isEnabled()&&(et.getText().toString().length()>0))
        {
            button.setEnabled(true);
        }
        else
        {
            button.setEnabled(false);
        }
    }
}
