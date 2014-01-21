package com.joelcastro.introduccionandroid.activities;

import android.app.Activity;
import android.content.Intent;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ItemClick;
import com.joelcastro.introduccionandroid.R;

/**
 * Created by alu03009 on 21/01/14.
 */
@EActivity(value = R.layout.activity_deposito_menu)
public class DepositoMenuActivity extends Activity {

    @Click(R.id.menu_deposito_new)
    void onDepositoNewClick()
    {
        Intent intent = new Intent().setClass(this, UserTypeActivity_.class);
        //objectItemData[position].getId()
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Click(R.id.menu_deposito_consult)
    void onConsultClick()
    {
        Intent intent = new Intent().setClass(this, DepositoListActivity_.class);
        //objectItemData[position].getId()
        startActivity(intent);
    }
}
