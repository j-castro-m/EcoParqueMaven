package com.joelcastro.introduccionandroid.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.joelcastro.introduccionandroid.utils.ArrayAdapterItem;
import com.joelcastro.introduccionandroid.utils.ItemListParada;
import com.joelcastro.introduccionandroid.utils.OnItemClickListenerListViewItem;
import com.joelcastro.introduccionandroid.R;

@EActivity(R.layout.activity_selectionplace)
public class DepositListActivity extends Activity {

    @ViewById(R.id.listView) ListView listViewItems;

    ItemListParada[] ObjectItemData = new ItemListParada[4];
    ArrayAdapterItem adapter;


    @AfterViews
    void fillAdapterList(){


        ObjectItemData[0] = new ItemListParada(1, "San Jose - Las Fuentes",getString(R.string.urlimagen));
        ObjectItemData[1] = new ItemListParada(2, "Cogullada",getString(R.string.urlimagen));
        ObjectItemData[2] = new ItemListParada(4, "Universidad - Delicias",getString(R.string.urlimagen));
        ObjectItemData[3] = new ItemListParada(3, "Valdespartera",getString(R.string.urlimagen));
        adapter = new ArrayAdapterItem(this, R.layout.place_item_layout, ObjectItemData);
        listViewItems.setAdapter(adapter);
        listViewItems.setOnItemClickListener(new OnItemClickListenerListViewItem());


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
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
