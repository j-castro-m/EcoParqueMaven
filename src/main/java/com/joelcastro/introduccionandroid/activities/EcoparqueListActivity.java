package com.joelcastro.introduccionandroid.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ItemClick;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;
import com.joelcastro.introduccionandroid.daos.DAOFactory;
import com.joelcastro.introduccionandroid.daos.DepositoDAO;
import com.joelcastro.introduccionandroid.daos.EcoParqueDAO;
import com.joelcastro.introduccionandroid.daos.fake.EcoParqueFakeDAO;
import com.joelcastro.introduccionandroid.daos.sqlite.EcoParqueSQLiteDAO;
import com.joelcastro.introduccionandroid.utils.ArrayAdapterEcoParque;
import com.joelcastro.introduccionandroid.models.EcoParque;
import com.joelcastro.introduccionandroid.utils.MyPrefs_;
import com.joelcastro.introduccionandroid.R;

@EActivity(R.layout.activity_ecoparque_list)
public class EcoparqueListActivity extends Activity {

    @ViewById(R.id.listView) ListView listViewItems;
    @Pref MyPrefs_ myPrefs;

    @Bean
    DAOFactory daoFactory;
    EcoParqueDAO ecoParqueDAO;



    ArrayAdapterEcoParque adapter;


    @AfterInject
    void initDAO(){
        ecoParqueDAO = daoFactory.getEcoParqueDAO();
    }


    @AfterViews
    void fillAdapterList(){
        adapter = new ArrayAdapterEcoParque(this, R.layout.ecoparque_item_layout, ecoParqueDAO.getAllEcoParques());
        listViewItems.setAdapter(adapter);
    }

    @ItemClick(R.id.listView)
    void onListItemClick(int position)
    {
        Intent intent = new Intent().setClass(this, DepositoMenuActivity_.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        myPrefs.idEcoParque().put(ecoParqueDAO.getAllEcoParques().get(position).getId());
        myPrefs.lugarEcoParque().put(ecoParqueDAO.getAllEcoParques().get(position).getLugar());
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
