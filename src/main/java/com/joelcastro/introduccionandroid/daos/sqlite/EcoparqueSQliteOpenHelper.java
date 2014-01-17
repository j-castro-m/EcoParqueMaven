package com.joelcastro.introduccionandroid.daos.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alu03009 on 10/01/14.
 */
public class EcoparqueSQliteOpenHelper extends SQLiteOpenHelper {


    public static final String MATERIALES_TABLE_NAME = "materiales";

    // Crear constantes con los nombres de las columnas

    public EcoparqueSQliteOpenHelper(Context context){
        super(context,"ecoparque.sqlite",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+MATERIALES_TABLE_NAME); // esta sentencia no es valida, ojo

        // aquí los insert
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}