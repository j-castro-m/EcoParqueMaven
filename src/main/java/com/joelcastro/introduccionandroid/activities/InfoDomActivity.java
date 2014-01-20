package com.joelcastro.introduccionandroid.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.joelcastro.introduccionandroid.R;
import com.joelcastro.introduccionandroid.utils.objectJSON;
@EActivity(R.layout.activity_infodom)
public class InfoDomActivity extends Activity {
    @ViewById(R.id.info_dom_url) TextView urlView;
    @ViewById(R.id.info_dom_ip) TextView textIP;
    @ViewById(R.id.info_dom_city) TextView textCity;
    @ViewById(R.id.info_dom_country) TextView textCountry;
    @ViewById(R.id.info_dom_gps) TextView textGps;
    Bundle extra;
    GoogleMap mMap;



        @AfterViews
        void setDataOnView(){
        extra = this.getIntent().getExtras();
        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        urlView.setText(extra.getString("url"));
        objectJSON json = new objectJSON(this,textIP,textCity,textCountry,textGps,mMap);
        json.execute(extra.getString("url"));
        String gps = json.getGps();

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


}
