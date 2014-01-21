package com.joelcastro.introduccionandroid.daos.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.googlecode.androidannotations.api.Scope;
import com.joelcastro.introduccionandroid.daos.EcoParqueDAO;
import com.joelcastro.introduccionandroid.models.EcoParque;
import com.joelcastro.introduccionandroid.models.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alu03009 on 21/01/14.
 */
@EBean(scope = Scope.Singleton)
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
        SQLiteDatabase db = openHelper.getReadableDatabase();
        Cursor query = db.query(openHelper.ECOPARQUE_TABLE_NAME,null,null,null,null,null,null);
        List<EcoParque> ecoparques = new ArrayList<EcoParque>();
        query.moveToFirst();
        for(int i=0;i<query.getCount();i++){
            EcoParque ecoParque = buildEcoParqueFromCursor(query);
            ecoparques.add(ecoParque);
            query.moveToNext();
        }
        query.close();
        //db.close();
        return ecoparques;
    }

    @Override
    public EcoParque getEcoParque(String idEcoParque) {
        SQLiteDatabase db = openHelper.getReadableDatabase();
        Cursor query = db.rawQuery("SELECT * FROM "+openHelper.ECOPARQUE_TABLE_NAME+" WHERE id_ecoparque='"+idEcoParque+"'",null);
        query.moveToFirst();
        EcoParque ecoParque = buildEcoParqueFromCursor(query);
        query.close();
        //db.close();
        return ecoParque;
    }

    public static EcoParque buildEcoParqueFromCursor(Cursor query) {
        EcoParque ecoParque = new EcoParque();

        ecoParque.setId(query.getString(query.getColumnIndex("id_ecoparque")));
        ecoParque.setImage(query.getString(query.getColumnIndex("image")));
        ecoParque.setLugar(query.getString(query.getColumnIndex("lugar")));
        return ecoParque;
    }
}
