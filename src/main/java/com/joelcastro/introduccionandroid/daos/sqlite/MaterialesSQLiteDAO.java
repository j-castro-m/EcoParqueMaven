package com.joelcastro.introduccionandroid.daos.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.googlecode.androidannotations.api.Scope;
import com.joelcastro.introduccionandroid.models.Material;
import com.joelcastro.introduccionandroid.daos.MaterialesDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alu03009 on 10/01/14.
 */

@EBean(scope = Scope.Singleton)
public class MaterialesSQLiteDAO implements MaterialesDAO {


    EcoparqueSQliteOpenHelper openHelper;

    @RootContext
    Context context;

    @AfterInject
    void initOpenHelper(){
        openHelper = new EcoparqueSQliteOpenHelper(context);
    }


    @Override
    public List<Material> getAllMateriales() {
        SQLiteDatabase db = openHelper.getReadableDatabase();
        Cursor query = db.query(openHelper.MATERIALES_TABLE_NAME,null,null,null,null,null,null);
        List<Material> materiales = new ArrayList<Material>();

        while (!query.isLast()){
            Material material = buildMaterialFromCursor(query);
            materiales.add(material);
            query.moveToNext();
        }
        query.close();
        db.close();
        return materiales;
    }

    public static Material buildMaterialFromCursor(Cursor query) {
        Material material = new Material();
        material.setId((int) query.getInt(query.getColumnIndex("id")));
        material.setName(query.getString(query.getColumnIndex("name")));
        return material;
    }
}