package com.joelcastro.introduccionandroid.daos.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.googlecode.androidannotations.api.Scope;
import com.joelcastro.introduccionandroid.daos.DepositoDAO;
import com.joelcastro.introduccionandroid.models.Deposito;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by alu03009 on 10/01/14.
 */
@EBean(scope = Scope.Singleton)
public class DepositoSQLiteDAO implements DepositoDAO {

    EcoparqueSQliteOpenHelper openHelper;

    @RootContext
    Context context;

    @AfterInject
    void initOpenHelper(){
        openHelper = new EcoparqueSQliteOpenHelper(context);
    }

    @Override
    public List<Deposito> getAllDeposites() {
        SQLiteDatabase db = openHelper.getReadableDatabase();
        Cursor query = db.query(EcoparqueSQliteOpenHelper.DEPOSITOS_TABLE_NAME,null,null,null,null,null,null);
        List<Deposito> depositos = new ArrayList<Deposito>();
        query.moveToFirst();
        for(int i=0;i<query.getCount();i++){
            Deposito deposito = buildDepositoFromCursor(query);
            depositos.add(deposito);
            query.moveToNext();
        }
        query.close();
        db.close();
        return depositos;
    }

    @Override
    public List<Deposito> getDepositesFromEcoParque(int idEcoParque) {
        SQLiteDatabase db = openHelper.getReadableDatabase();
        Cursor query = db.rawQuery("SELECT * FROM " + EcoparqueSQliteOpenHelper.DEPOSITOS_TABLE_NAME + "WHERE idecoparque=" + idEcoParque, null);
        List<Deposito> depositos = new ArrayList<Deposito>();
        query.moveToFirst();
        for(int i=0;i<query.getCount();i++){
            Deposito deposito = buildDepositoFromCursor(query);
            depositos.add(deposito);
            query.moveToNext();
        }
        query.close();
        db.close();
        return depositos; }
    

    @Override
    public void addDeposito(Deposito deposito) {
        SQLiteDatabase db = openHelper.getWritableDatabase();
        deposito.setId(getAllDeposites().size()+1);
        db.execSQL("INSERT INTO "+EcoparqueSQliteOpenHelper.DEPOSITOS_TABLE_NAME+" VALUES("+
                deposito.getId()+","+
                deposito.getIdEcoParque()+","+
                "'"+deposito.getDepositanteId()+"'"+","+
                "'"+deposito.getFecha()+"'"+","+
                deposito.getCompany().toString()+","+
                "'"+deposito.getNombre()+"'"+","+
                "'"+deposito.getSector()+"'"+","+
                "'"+deposito.getTelefono()+"'"+","+
                "'"+deposito.getEmail()+"'"+","+
                "'"+deposito.getWeb()+"'"+")"
                );
        db.close();
    }

    @Override
    public void editDeposito(Deposito deposito) {
        SQLiteDatabase db = openHelper.getWritableDatabase();
        db.execSQL("DELETE FROM "+EcoparqueSQliteOpenHelper.DEPOSITOS_TABLE_NAME+" WHERE id ="+deposito.getId()+";");
        db.execSQL("INSERT INTO "+EcoparqueSQliteOpenHelper.DEPOSITOS_TABLE_NAME+" VALUES("+
                deposito.getId()+","+
                deposito.getIdEcoParque()+","+
                "'"+deposito.getDepositanteId()+"'"+","+
                "'"+deposito.getFecha()+"'"+","+
                deposito.getCompany().toString()+","+
                "'"+deposito.getNombre()+"'"+","+
                "'"+deposito.getSector()+"'"+","+
                "'"+deposito.getTelefono()+"'"+","+
                "'"+deposito.getEmail()+"'"+","+
                "'"+deposito.getWeb()+"'"+")"
        );
        db.close();
    }

    private Deposito buildDepositoFromCursor(Cursor query) {
        Deposito deposito = new Deposito();
        deposito.setId(query.getInt(query.getColumnIndex("id")));
        deposito.setIdEcoParque(query.getInt(query.getColumnIndex("idecoparque")));

        deposito.setDepositanteId(query.getString(query.getColumnIndex("depositanteid")));
        deposito.setFecha(query.getString(query.getColumnIndex("fecha")));
        deposito.setPeso(query.getString(query.getColumnIndex("peso")));
        deposito.setCompany(Boolean.getBoolean(query.getString(query.getColumnIndex("company"))));
        deposito.setNombre(query.getString(query.getColumnIndex("nombre")));
        deposito.setSector(query.getString(query.getColumnIndex("sector")));
        deposito.setTelefono(query.getString(query.getColumnIndex("telefono")));
        deposito.setEmail(query.getString(query.getColumnIndex("email")));
        deposito.setWeb(query.getString(query.getColumnIndex("web")));


        return deposito;
    }
}
