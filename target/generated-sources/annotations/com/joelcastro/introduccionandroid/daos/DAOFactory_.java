//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package com.joelcastro.introduccionandroid.daos;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.joelcastro.introduccionandroid.daos.fake.DepositoFakeDAO_;
import com.joelcastro.introduccionandroid.daos.fake.DepositoMaterialFakeDAO_;
import com.joelcastro.introduccionandroid.daos.fake.EcoParqueFakeDAO_;
import com.joelcastro.introduccionandroid.daos.fake.MaterialesFakeDAO_;
import com.joelcastro.introduccionandroid.daos.sqlite.MaterialesSQLiteDAO_;

public final class DAOFactory_
    extends DAOFactory
{

    private Context context_;
    private static DAOFactory_ instance_;

    private DAOFactory_(Context context) {
        context_ = context;
        init_();
    }

    public void afterSetContentView_() {
        if (!(context_ instanceof Activity)) {
            return ;
        }
        ((MaterialesSQLiteDAO_) materialesSQLiteDAO).afterSetContentView_();
        ((DepositoFakeDAO_) depositoFakeDAO).afterSetContentView_();
        ((EcoParqueFakeDAO_) ecoParqueFakeDAO).afterSetContentView_();
        ((DepositoFakeDAO_) depositoSQLiteDAO).afterSetContentView_();
        ((DepositoMaterialFakeDAO_) depositoMaterialSQLiteDAO).afterSetContentView_();
        ((EcoParqueFakeDAO_) ecoParqueSQLiteDAO).afterSetContentView_();
        ((DepositoMaterialFakeDAO_) depositoMaterialFakeDAO).afterSetContentView_();
        ((MaterialesFakeDAO_) materialesFakeDAO).afterSetContentView_();
    }

    /**
     * You should check that context is an activity before calling this method
     * 
     */
    public View findViewById(int id) {
        Activity activity_ = ((Activity) context_);
        return activity_.findViewById(id);
    }

    @SuppressWarnings("all")
    private void init_() {
        if (context_ instanceof Activity) {
            Activity activity = ((Activity) context_);
        }
        materialesSQLiteDAO = MaterialesSQLiteDAO_.getInstance_(context_);
        depositoFakeDAO = DepositoFakeDAO_.getInstance_(context_);
        ecoParqueFakeDAO = EcoParqueFakeDAO_.getInstance_(context_);
        depositoSQLiteDAO = DepositoFakeDAO_.getInstance_(context_);
        depositoMaterialSQLiteDAO = DepositoMaterialFakeDAO_.getInstance_(context_);
        ecoParqueSQLiteDAO = EcoParqueFakeDAO_.getInstance_(context_);
        depositoMaterialFakeDAO = DepositoMaterialFakeDAO_.getInstance_(context_);
        materialesFakeDAO = MaterialesFakeDAO_.getInstance_(context_);
        initDAOs();
    }

    public static DAOFactory_ getInstance_(Context context) {
        if (instance_ == null) {
            instance_ = new DAOFactory_(context.getApplicationContext());
        }
        return instance_;
    }

    public void rebind(Context context) {
    }

}
