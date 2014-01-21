package com.joelcastro.introduccionandroid.daos.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.joelcastro.introduccionandroid.daos.EcoParqueDAO;
import com.joelcastro.introduccionandroid.models.EcoParque;
import com.joelcastro.introduccionandroid.models.Material;

import java.util.ArrayList;
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
        SQLiteDatabase db = openHelper.getReadableDatabase();
        Cursor query = db.query(openHelper.ECOPARQUE_TABLE_NAME,null,null,null,null,null,null);
        List<EcoParque> ecoparques = new ArrayList<EcoParque>();

        while (!query.isLast()){
            EcoParque ecoParque = buildEcoParqueFromCursor(query);
            ecoparques.add(ecoParque);
            query.moveToNext();
        }
        query.close();
        db.close();
        return ecoparques;
    }

    @Override
    public EcoParque getEcoParque(int idEcoParque) {
        SQLiteDatabase db = openHelper.getReadableDatabase();
        Cursor query = db.rawQuery("SELECT * FROM "+openHelper.ECOPARQUE_TABLE_NAME+" WHERE id="+idEcoParque,null);
        EcoParque ecoParque = buildEcoParqueFromCursor(query);
        query.close();
        db.close();
        return ecoParque;
    }

    public static EcoParque buildEcoParqueFromCursor(Cursor query) {
        EcoParque ecoParque = new EcoParque();
        ecoParque.setId((int) query.getInt(query.getColumnIndex("id")));
        ecoParque.setImage(query.getString(query.getColumnIndex("image")));
        ecoParque.setLugar(query.getString(query.getColumnIndex("lugar")));
        return ecoParque;
    }
}
