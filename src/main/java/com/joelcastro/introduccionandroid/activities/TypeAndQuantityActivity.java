package com.joelcastro.introduccionandroid.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.TextChange;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;
import com.joelcastro.introduccionandroid.R;
import com.joelcastro.introduccionandroid.daos.DAOFactory;
import com.joelcastro.introduccionandroid.daos.DepositoMaterialDAO;
import com.joelcastro.introduccionandroid.daos.EcoParqueDAO;
import com.joelcastro.introduccionandroid.daos.fake.EcoParqueFakeDAO;
import com.joelcastro.introduccionandroid.daos.sqlite.DepositoMaterialSQLiteDAO;
import com.joelcastro.introduccionandroid.daos.sqlite.EcoParqueSQLiteDAO;
import com.joelcastro.introduccionandroid.models.Deposito;
import com.joelcastro.introduccionandroid.models.Empresa;
import com.joelcastro.introduccionandroid.utils.MyPrefs_;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_typeandquantity)
public class TypeAndQuantityActivity extends Activity {

    @Pref
    MyPrefs_ myPrefs;
     @ViewById(R.id.textWeightCData2) EditText peso;
     @ViewById(R.id.textCIFCData2) EditText cif;

     @ViewById(R.id.button_deposite) Button button;

     @ViewById(R.id.checkBoxIT) CheckBox checkBoxIT;
     @ViewById(R.id.checkBoxFridge) CheckBox checkBoxFridge;
     @ViewById(R.id.checkBoxOil) CheckBox checkBoxOil;

    @Bean
    DAOFactory daoFactory;
    DepositoMaterialDAO depositoMaterialDAO;

     Bundle extra;
        String fecha;
        Boolean company;
        Empresa empresa;

    @AfterInject
    void initDAO(){
        depositoMaterialDAO = daoFactory.getDepositoMaterialDAO();
    }

        @AfterViews
        void setDataonView(){
        extra = this.getIntent().getExtras();
            if(extra.get("deposito")==null){
                cif.setText(extra.getString("cif"));
                fecha ="";
                company = extra.getBoolean("company");
                if(company){
                    empresa = (Empresa) extra.get("empresa");
                }

            }else
            {
                Deposito deposito = (Deposito)extra.get("deposito");
                fecha = deposito.getFecha();
                cif.setText(deposito.getDepositanteId());
                peso.setText(deposito.getPeso());
                company = deposito.getCompany();
                if(company){
                    empresa = new Empresa(deposito.getDepositanteId(),deposito.getNombre(),deposito.getSector(),deposito.getTelefono(),deposito.getEmail(),deposito.getWeb());
                }

                List<String> materiales = depositoMaterialDAO.getMateriales(deposito);

                if(materiales.contains("1")){
                    checkBoxIT. setChecked(Boolean.TRUE);
                }

                if(materiales.contains("2")){
                    checkBoxFridge.setChecked(Boolean.TRUE);
                }

                if(materiales.contains("3")){
                    checkBoxOil.setChecked(Boolean.TRUE);
                }


            }

        }

        @Click(value={R.id.checkBoxIT,R.id.checkBoxFridge,R.id.checkBoxOil})
        void onClickCheckBox(){
            checkMarkers(checkBoxIT, checkBoxFridge, checkBoxOil, button, peso);
        }


         @TextChange(value=R.id.textWeightCData2)
         void onWeightTextChange(TextView tv, CharSequence text) {
             checkMarkers(checkBoxIT, checkBoxFridge, checkBoxOil,button,peso);
         }


       @Click(value=R.id.button_deposite)
       void onClickDeposite(){
           Intent intent = new Intent(this, ResultsActivity_.class);

            List<String> materiales = new ArrayList<String>();
           if(checkBoxIT.isChecked()){
               materiales.add("1");
           }

           if(checkBoxFridge.isChecked()){
               materiales.add("2");
           }

           if(checkBoxOil.isChecked()){
               materiales.add("3");
           }

            intent.putExtra("materiales", (Serializable) materiales);
           if(extra.get("deposito")==null){
               Log.d("sinDeposito", "sindeposito");
               if(extra.getBoolean("company")){
                   intent.putExtra("deposito",new Deposito("0",myPrefs.idEcoParque().get(),empresa.getCif(),fecha,peso.getText().toString(),empresa));
               }else{
                   intent.putExtra("deposito", new Deposito("0", myPrefs.idEcoParque().get(), extra.getString("cif"), fecha, peso.getText().toString()));
               }

           }
           else
           {
               Deposito deposito = (Deposito)extra.get("deposito");
               if(extra.getBoolean("company")){
                   intent.putExtra("deposito",new Deposito(deposito.getId(),deposito.getIdEcoParque(),deposito.getDepositanteId(),fecha,peso.getText().toString(),empresa));
               }else{
                   intent.putExtra("deposito", new Deposito(deposito.getId(),deposito.getIdEcoParque(), deposito.getDepositanteId(), fecha,peso.getText().toString()));
               }
           }
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
