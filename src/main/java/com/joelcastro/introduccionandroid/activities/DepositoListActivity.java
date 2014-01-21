package com.joelcastro.introduccionandroid.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ItemClick;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;
import com.joelcastro.introduccionandroid.R;
import com.joelcastro.introduccionandroid.daos.DAOFactory;
import com.joelcastro.introduccionandroid.daos.DepositoDAO;
import com.joelcastro.introduccionandroid.daos.fake.DepositoFakeDAO;
import com.joelcastro.introduccionandroid.models.Deposito;
import com.joelcastro.introduccionandroid.models.EcoParque;
import com.joelcastro.introduccionandroid.utils.ArrayAdapterDeposito;
import com.joelcastro.introduccionandroid.utils.ArrayAdapterEcoParque;
import com.joelcastro.introduccionandroid.utils.MyPrefs_;

import java.util.List;

@EActivity(R.layout.activity_depositos_list)
public class DepositoListActivity extends Activity {

    @ViewById(R.id.listDepositView) ListView listViewItems;
    @Pref
    MyPrefs_ myPrefs;

    DAOFactory daoFactory = new DAOFactory();
    @Bean(DepositoFakeDAO.class)
    DepositoDAO depositoDAO = daoFactory.getDepositosDAO();

    ArrayAdapterDeposito adapter;


    @AfterViews
    void fillAdapterList(){
        adapter = new ArrayAdapterDeposito(this, R.layout.deposito_item_layout, (depositoDAO.getAllDeposites()));
        listViewItems.setAdapter(adapter);
    }

    @ItemClick(R.id.listDepositView)
    void onDepositoClick(int position)
    {
        Intent intent = new Intent().setClass(this, ResultsActivity_.class);
        intent.putExtra("deposito", depositoDAO.getAllDeposites().get(position));
        //objectItemData[position].getId()
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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
