package com.joelcastro.introduccionandroid.daos.parse;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.api.Scope;
import com.joelcastro.introduccionandroid.daos.DepositoMaterialDAO;
import com.joelcastro.introduccionandroid.models.Deposito;
import com.joelcastro.introduccionandroid.models.DepositoMaterial;
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
public class DepositoMaterialParseDAO implements DepositoMaterialDAO {
    @Override
    public List<String> getMateriales(Deposito deposito) {
        List<String> materials = new ArrayList<String>();
        ParseQuery<ParseObject > query = ParseQuery.getQuery("MaterialsAndDeposite");
        query.whereMatches("idDeposito",deposito.getId());
        try {
            for (ParseObject parseObject : query.find()) {
                materials.add(parseObject.getString("idMaterial"));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return materials;
    }

    @Override
    public void addDepositoMaterial(String idMaterial, String idDeposito) {
        ParseObject depositoMaterial = new ParseObject("MaterialsAndDeposite");
        depositoMaterial.put("idMaterial",idMaterial);
        depositoMaterial.put("idDeposito",idDeposito);
        depositoMaterial.saveInBackground();
    }

    @Override
    public void deleteDepositoMaterial(String idMaterial, String idDeposito) {

        ParseQuery<ParseObject > query = ParseQuery.getQuery("MaterialsAndDeposite");
        query.whereMatches("idDeposito",idDeposito);
        query.whereMatches("idMaterial",idMaterial);
        try {
            if(!(query.getFirst()==null)){
                query.getFirst().delete();
            }

        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
