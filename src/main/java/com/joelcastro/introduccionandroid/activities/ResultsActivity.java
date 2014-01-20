package com.joelcastro.introduccionandroid.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.joelcastro.introduccionandroid.R;

import java.util.Calendar;

@EActivity(R.layout.activity_result)
public class ResultsActivity extends Activity {
    private int mYear;
    private int mMonth;
    private int mDay;
    static final int DATE_DIALOG_ID = 0;

    String emailF;
    String tipos = "";
    String email= new String("");;

    double peso;
    double precio;
    double iva;
    double total;

    @ViewById(R.id.button_sendbymail) Button enviaremail;
    @ViewById(R.id.button_reg_dep) Button fin_reg;

    @ViewById(R.id.GridResult) GridLayout grid;
    @ViewById(R.id.GridResult2) GridLayout grid2;

    @ViewById(R.id.Linea) View linea;

    @ViewById(R.id.result_CIF) TextView cif;
    @ViewById(R.id.result_CIF) TextView tipo_residuo;
    @ViewById(R.id.result_CIF) TextView result_cost_text;
    @ViewById(R.id.result_CIF) TextView textCoste;
    @ViewById(R.id.result_CIF) TextView textPrecio;
    @ViewById(R.id.result_CIF) TextView textIVa;
    @ViewById(R.id.result_CIF) TextView textTotal;
    @ViewById(R.id.result_CIF) TextView textPlace;

    @ViewById(R.id.textDateCData) TextView date;
    @ViewById(R.id.buttonDate) Button edit;


    Bundle extra;

    @AfterViews
    void setDataOnView(){
        extra = this.getIntent().getExtras();

        peso = Double.parseDouble(extra.getString("Peso"));
        precio = peso * 2.5;
        iva = precio * 0.2;
        double total = precio + iva;

        textPlace.setText(extra.getString("nombreParada"));
        textCoste.setText(String.valueOf(peso)+ getString(R.string.kg)+" * 2,5"+getString(R.string.currency)+"/"+getString(R.string.kg));
        textPrecio.setText(String.valueOf(precio)+getString(R.string.currency));
        textIVa.setText(String.valueOf(iva)+getString(R.string.currency));
        textTotal.setText(String.valueOf(total)+getString(R.string.currency));


        if(extra.getBoolean("company"))
        {
            result_cost_text.setVisibility(View.VISIBLE);
            grid.setVisibility(View.VISIBLE);
            grid2.setVisibility(View.VISIBLE);
            linea.setVisibility(View.VISIBLE);
            enviaremail.setVisibility(View.VISIBLE);
            email = extra.getString("email");

        }

        emailF = email;
        cif.setText(extra.getString("cif"));





        if(extra.getBoolean("ITmat"))
        {
            if(tipos.length()>0)
            {
                tipos = tipos+(" ,"+getString(R.string.ITMaterial));
            }
            else
            {
                tipos = tipos+(getString(R.string.ITMaterial));
            }
        }

        if(extra.getBoolean("Fridge"))
        {
            if(tipos.length()>0)
            {
                tipos = tipos+(", "+getString(R.string.Fridge));
            }
            else
            {
                tipos = tipos+(getString(R.string.Fridge));
            }
        }

        if(extra.getBoolean("Oil"))
        {
            if(tipos.length()>0)
            {
                tipos = tipos+(", "+getString(R.string.Oil));
            }
            else
            {
                tipos = tipos+(getString(R.string.Oil));
            }
        }

        tipo_residuo.setText(tipos);
    }


        @Click(value=R.id.button_sendbymail)
        void onSendByMailClick(){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", emailF, null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.asunto_email_result));
            emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.body_email_result)+String.valueOf(total)+"€");
            startActivity(Intent.createChooser(emailIntent, "Enviar email..."));
        }


        @Click(value=R.id.button_reg_dep)
        void onRegistrateDepositClick(){
            Context context = getApplicationContext();
            CharSequence text = getString(R.string.end_toast);
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            Intent intent = new  Intent(getBaseContext(), LoginActivity_.class);
            // Indica que la aplicación debe cerrarse
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }



    @Click(R.id.buttonDate)
    void launchDatePicker()
    {
        DatePickerDialog dialog=new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                final Calendar calendario= Calendar.getInstance();
                mYear=calendario.get(Calendar.YEAR);
                mMonth=calendario.get(Calendar.MONTH);
                mDay=calendario.get(Calendar.DAY_OF_MONTH);
                date.setText(mDay+"/"+mMonth+"/"+mYear);
            }
        },mYear,mMonth,mDay);
        dialog.show();
    }


/*

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener(){
        public void onDateSet(DatePicker view, int year, int month, int day){
            mYear=year;
            mMonth=month;
            mDay=day;
            updateDisplay();
        }
    };

    @Override
    protected Dialog onCreateDialog(int id)
    {
        switch (id){
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener, mYear,mMonth,mDay);
        }
        return null;
    }


    private void updateDisplay(){
        date.setText(new StringBuilder().append(mDay).append("/").append(mMonth+1).append("/").append(mYear));
    }
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.result, menu);
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
}
