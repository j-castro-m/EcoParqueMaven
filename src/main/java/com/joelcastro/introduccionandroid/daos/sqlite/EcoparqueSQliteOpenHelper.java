package com.joelcastro.introduccionandroid.daos.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alu03009 on 10/01/14.
 */
public class EcoparqueSQliteOpenHelper extends SQLiteOpenHelper {


    public static final String MATERIALES_TABLE_NAME = "materiales";
    public static final String ECOPARQUE_TABLE_NAME = "ecoparques";
    public static final String DEPOSITOS_TABLE_NAME = "depositos";
    public static final String DEPOSITOSMATERIAL_TABLE_NAME = "depositomaterial";

    // Crear constantes con los nombres de las columnas

    public EcoparqueSQliteOpenHelper(Context context){
        super(context,"ecoparque.sqlite",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+MATERIALES_TABLE_NAME+"(id INT, name TEXT)");
        db.execSQL("CREATE TABLE "+DEPOSITOSMATERIAL_TABLE_NAME+"(idmateria INT, iddeposito INT)");
        db.execSQL("CREATE TABLE "+ECOPARQUE_TABLE_NAME+"(id INT, image TEXT, lugar TEXT)");
        db.execSQL("CREATE TABLE "+DEPOSITOS_TABLE_NAME+"(id INT,"
                                                        +" idecoparque INT,"
                                                        +" depositanteid TEXT,"
                                                        +" fecha TEXT,"
                                                        +" peso TEXT,"
                                                        +" company BOOLEAN,"
                                                        +" nombre TEXT,"
                                                        +" sector TEXT,"
                                                        +" telefono TEXT,"
                                                        +" email TEXT,"
                                                        +" web TEXT"
                                                        +")");


        db.execSQL("INSERT INTO "+MATERIALES_TABLE_NAME+" VALUES (1, 'Material informático')");
        db.execSQL("INSERT INTO "+MATERIALES_TABLE_NAME+" VALUES (2, 'Neveras')");
        db.execSQL("INSERT INTO "+MATERIALES_TABLE_NAME+" VALUES (3, 'Aceites usados')");

        db.execSQL("INSERT INTO "+ECOPARQUE_TABLE_NAME+" VALUES (1,'San Jose - Las Fuentes','http://www.restauranteateneo.es/sites/all/themes/ateneo/images/bus.png')");
        db.execSQL("INSERT INTO "+ECOPARQUE_TABLE_NAME+" VALUES (2,'Cogullada','http://www.restauranteateneo.es/sites/all/themes/ateneo/images/bus.png')");
        db.execSQL("INSERT INTO "+ECOPARQUE_TABLE_NAME+" VALUES (3,'Universidad - Delicias','http://www.restauranteateneo.es/sites/all/themes/ateneo/images/bus.png')");
        db.execSQL("INSERT INTO "+ECOPARQUE_TABLE_NAME+" VALUES (4,'Valdespartera','http://www.restauranteateneo.es/sites/all/themes/ateneo/images/bus.png')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}