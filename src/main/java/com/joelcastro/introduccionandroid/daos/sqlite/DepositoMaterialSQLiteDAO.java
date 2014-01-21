package com.joelcastro.introduccionandroid.daos.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.googlecode.androidannotations.api.Scope;
import com.joelcastro.introduccionandroid.daos.DepositoMaterialDAO;
import com.joelcastro.introduccionandroid.models.Deposito;
import com.joelcastro.introduccionandroid.models.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alu03009 on 21/01/14.
 */
@EBean(scope = Scope.Singleton)
public class DepositoMaterialSQLiteDAO implements DepositoMaterialDAO {

    EcoparqueSQliteOpenHelper openHelper;

    @RootContext
    Context context;

    @AfterInject
    void initOpenHelper(){
        openHelper = new EcoparqueSQliteOpenHelper(context);
    }
    @Override
    public List<Integer> getMateriales(Deposito deposito) {
        SQLiteDatabase db = openHelper.getReadableDatabase();
        Cursor query = db.rawQuery("SELECT * FROM "+EcoparqueSQliteOpenHelper.DEPOSITOSMATERIAL_TABLE_NAME+" WHERE iddeposito="+deposito.getId()+";",null);
        List<Integer> materiales = new ArrayList<Integer>();
        query.moveToFirst();
        for(int i=0;i<query.getCount();i++){
            Integer material = MaterialesSQLiteDAO.buildMaterialFromCursor(query).getId();
            materiales.add(material);
            query.moveToNext();
        }
        query.close();
        db.close();
        return materiales;
    }

    @Override
    public void addDepositoMaterial(int idMaterial, int idDeposito) {
        SQLiteDatabase db = openHelper.getReadableDatabase();
        db.execSQL("INSERT INTO "+EcoparqueSQliteOpenHelper.DEPOSITOSMATERIAL_TABLE_NAME+" VALUES("+idMaterial+","+idDeposito+");");
        db.close();
    }

    @Override
    public void deleteDepositoMaterial(int idMaterial, int idDeposito) {
        SQLiteDatabase db = openHelper.getReadableDatabase();
        db.execSQL("DELETE "+EcoparqueSQliteOpenHelper.DEPOSITOSMATERIAL_TABLE_NAME+" WHERE idmaterial="+idMaterial+" AND iddeposito="+idDeposito+";");
        db.close();
    }
}
