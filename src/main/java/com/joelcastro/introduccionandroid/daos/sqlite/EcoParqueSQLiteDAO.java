package com.joelcastro.introduccionandroid.daos.sqlite;

import android.content.Context;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.joelcastro.introduccionandroid.daos.EcoParqueDAO;
import com.joelcastro.introduccionandroid.models.EcoParque;

import java.util.List;

/**
 * Created by alu03009 on 21/01/14.
 */
@EBean
public class EcoParqueSQLiteDAO implements EcoParqueDAO {
    EcoparqueSQliteOpenHelper openHelper;

    @RootContext
    Context context;

    @AfterInject
    void initOpenHelper(){
        openHelper = new EcoparqueSQliteOpenHelper(context);
    }

    @Override
    public List<EcoParque> getAllEcoParques() {
        return null;
    }

    @Override
    public EcoParque getEcoParque(int idEcoParque) {
        return null;
    }
}
