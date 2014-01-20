package com.joelcastro.introduccionandroid.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ItemClick;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;
import com.joelcastro.introduccionandroid.utils.ArrayAdapterItem;
import com.joelcastro.introduccionandroid.models.EcoParque;
import com.joelcastro.introduccionandroid.utils.MyPrefs_;
import com.joelcastro.introduccionandroid.utils.OnItemClickListenerListViewItem;
import com.joelcastro.introduccionandroid.R;

@EActivity(R.layout.activity_selectionplace)
public class DepositListActivity extends Activity {

    @ViewById(R.id.listView) ListView listViewItems;
    @Pref MyPrefs_ myPrefs;

    EcoParque[] objectItemData;
    ArrayAdapterItem adapter;


    @AfterViews
    void fillAdapterList(){
        adapter = new ArrayAdapterItem(this, R.layout.place_item_layout, fillWithData());
        listViewItems.setAdapter(adapter);
    }

    @ItemClick(R.id.listView)
    void onListItemClick(int position)
    {
        Intent intent = new Intent().setClass(this, UserTypeActivity_.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        myPrefs.idEcoParque().put(objectItemData[position].getId());
        myPrefs.lugarEcoParque().put(objectItemData[position].getLugar());
        startActivity(intent);
    }

    public EcoParque[] fillWithData(){
        objectItemData = new EcoParque[4];
        objectItemData[0] = new EcoParque(1, "San Jose - Las Fuentes",getString(R.string.urlimagen));
        objectItemData[1] = new EcoParque(2, "Cogullada",getString(R.string.urlimagen));
        objectItemData[2] = new EcoParque(4, "Universidad - Delicias",getString(R.string.urlimagen));
        objectItemData[3] = new EcoParque(3, "Valdespartera",getString(R.string.urlimagen));
        return objectItemData;
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
