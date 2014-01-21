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
import com.joelcastro.introduccionandroid.models.DepositoMaterial;
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
    public List<String> getMateriales(Deposito deposito) {
        SQLiteDatabase db = openHelper.getReadableDatabase();
        Cursor query = db.rawQuery("SELECT * FROM "+EcoparqueSQliteOpenHelper.DEPOSITOSMATERIAL_TABLE_NAME+" WHERE id_deposito='"+deposito.getId()+"'",null);
        List<String > materiales = new ArrayList<String>();
        query.moveToFirst();
        for(int i=0;i<query.getCount();i++){
            String material = buildDepositoMaterialFromCursor(query).getIdMaterial();
            materiales.add(material);
            query.moveToNext();
        }
        query.close();
        return materiales;
    }

    @Override
    public void addDepositoMaterial(String idMaterial, String idDeposito) {
        SQLiteDatabase db = openHelper.getReadableDatabase();
        db.execSQL("INSERT INTO "+EcoparqueSQliteOpenHelper.DEPOSITOSMATERIAL_TABLE_NAME+" VALUES('"+idMaterial+"','"+idDeposito+"')");

    }

    @Override
    public void deleteDepositoMaterial(String idMaterial, String idDeposito) {
        SQLiteDatabase db = openHelper.getReadableDatabase();
        try{
        db.execSQL("DELETE FROM "+EcoparqueSQliteOpenHelper.DEPOSITOSMATERIAL_TABLE_NAME+" WHERE id_material='"+idMaterial+"' AND id_deposito='"+idDeposito+"'");
        }catch(Exception ex){

        }
    }

    public static DepositoMaterial buildDepositoMaterialFromCursor(Cursor query) {

        DepositoMaterial depositoMaterial = new DepositoMaterial();
        depositoMaterial.setIdMaterial(query.getString(query.getColumnIndex("id_material")));
        depositoMaterial.setIdDeposito(query.getString(query.getColumnIndex("id_deposito")));
        return depositoMaterial;
    }
}
