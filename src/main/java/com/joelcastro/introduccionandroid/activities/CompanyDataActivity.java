package com.joelcastro.introduccionandroid.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.TextChange;
import com.googlecode.androidannotations.annotations.ViewById;
import com.joelcastro.introduccionandroid.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@EActivity(R.layout.activity_companydata)
public class CompanyDataActivity extends Activity {

    Bundle extra;

    @ViewById(R.id.textCIFCData1) EditText cif;
    @ViewById(R.id.textCNameCData1) EditText name;
    @ViewById(R.id.textPhoneCData1) EditText phone;
    @ViewById(R.id.textEmailCData1) EditText email;
    @ViewById(R.id.textWebCData1) EditText web;

    @ViewById(R.id.button_siguiente) Button button_siguiente;
    @ViewById(R.id.buttonInfoDom) Button button_dominio;
    @ViewById(R.id.buttonPhoneCData1) Button button_phone;
    @ViewById(R.id.buttonEmailCData1) Button button_email;
    @ViewById(R.id.buttonWebCData1) Button button_web;

    @ViewById(R.id.spinner) Spinner spinner;

    @Click(value = R.id.buttonInfoDom)
    void doButtonDominio() {
        Intent intent = new Intent(getBaseContext(), InfoDomActivity_.class);
        intent.putExtra("url", web.getText().toString());
        intent.putExtra("nombreParada",extra.getString("nombreParada"));
        startActivity(intent);
    }

    @Click(value = R.id.button_siguiente)
    void doButtonSiguiente(){
        Intent intent = new Intent(getBaseContext(), TypeAndQuantityActivity_.class);
        intent.putExtra("company",extra.getBoolean("company"));
        intent.putExtra("email",email.getText().toString());
        intent.putExtra("nombreParada",extra.getString("nombreParada"));
        startActivity(intent);
    }


    @Click(value = R.id.buttonPhoneCData1)
    void doButtonPhoneData(){
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone.getText().toString()));
        startActivity(intent);
    }

    @Click(value = R.id.buttonEmailCData1)
    void doButtonEmail(){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",email.getText().toString(), null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Asunto");
        startActivity(Intent.createChooser(emailIntent, "Enviar email..."));

    }
    @Click(value = R.id.buttonWebCData1)
    void doButtonWeb(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(web.getText().toString()));
        startActivity(browserIntent);
    }


    @AfterViews
    void setDataOnViews(){
        extra = this.getIntent().getExtras();
        cif.setText(extra.getString("cif"));

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sectores_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }






    @TextChange({R.id.textCIFCData1,R.id.textCNameCData1,R.id.textPhoneCData1,R.id.textEmailCData1,R.id.textWebCData1})
        public void enableButton(){
            Boolean bomail = correctMail(email,button_email);
            Boolean bophone = correctPhone(phone,button_phone);
            Boolean boweb = correctWeb(web,button_web);

            button_dominio.setEnabled(boweb);

            if (valid(cif)&&bomail&&bophone&&boweb&&name.getText().toString().length()>0) {
                button_siguiente.setEnabled(true);
            } else {
                button_siguiente.setEnabled(false);
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


    public boolean correctMail(EditText et, Button b){
        String c = et.getText().toString();
        //asignamos la expresion
        Pattern p = Pattern.compile("^[-a-zA-Z0-9+_.]{2,15}@[a-zA-Z0-9_-]{2,15}.[a-zA-Z]{2,4}(.[a-zA-Z]{2,4})?$");
        //comparamos con nuestro valor
        Matcher m = p.matcher(c);
        //si el correo es correcto devuelve TRUE o de lo contrario FALSE
        if(m.matches())
        {
            b.setEnabled(true);
            return true;
        }
        else
        {
            b.setEnabled(false);
            return false;
        }
    }

    public boolean correctPhone(EditText et, Button b){
        String c = et.getText().toString();
        //asignamos la expresion
        Pattern p = Pattern.compile("^[0-9]{9}$");
        //comparamos con nuestro valor
        Matcher m = p.matcher(c);
        if(m.matches())
        {
            b.setEnabled(true);
            return true;
        }
        else
        {
            b.setEnabled(false);
            return false;
        }
    }

    public boolean correctWeb(EditText et, Button b){
        String c = et.getText().toString();
        //asignamos la expresion
        Pattern p = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
        //comparamos con nuestro valor
        Matcher m = p.matcher(c);
        if(m.matches())
        {
            b.setEnabled(true);
            return true;
        }
        else
        {
            b.setEnabled(false);
            return false;
        }
    }


}
