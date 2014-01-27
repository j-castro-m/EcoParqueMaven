package com.joelcastro.introduccionandroid.daos.parse;

import android.util.Log;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.api.Scope;
import com.joelcastro.introduccionandroid.daos.MaterialesDAO;
import com.joelcastro.introduccionandroid.models.Material;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alu03009 on 24/01/14.
 */
@EBean(scope = Scope.Singleton)
public class MaterialesParseDAO implements MaterialesDAO{
    @Override
    public List<Material> getAllMateriales() {
        List<Material> materiales = new ArrayList<Material>();
        ParseQuery<ParseObject > query = ParseQuery.getQuery("Materials");
        try {
            for (ParseObject parseObject : query.find()) {
                Material material = new Material();
                material.setId(parseObject.getString("idMaterial"));
                material.setName(parseObject.getString("name"));
                materiales.add(material);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return materiales;
    }
}
