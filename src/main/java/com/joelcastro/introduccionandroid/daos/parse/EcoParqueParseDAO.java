package com.joelcastro.introduccionandroid.daos.parse;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.api.Scope;
import com.joelcastro.introduccionandroid.daos.EcoParqueDAO;
import com.joelcastro.introduccionandroid.models.EcoParque;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alu03009 on 24/01/14.
 */
@EBean(scope = Scope.Singleton)
public class EcoParqueParseDAO implements EcoParqueDAO {
    @Override
    public List<EcoParque> getAllEcoParques() {
        List<EcoParque> ecoparques = new ArrayList<EcoParque>();
        ParseQuery<ParseObject > query = ParseQuery.getQuery("EcoParque");
        try {
            for (ParseObject parseObject : query.find()) {
                EcoParque ecoParque = new EcoParque();
                ecoParque.setId(parseObject.getString("idEcoParque"));
                ecoParque.setImage(parseObject.getString("url"));
                ecoParque.setLugar(parseObject.getString("lugar"));
                ecoparques.add(ecoParque);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ecoparques;
    }

    @Override
    public EcoParque getEcoParque(String idEcoParque) {
        EcoParque ecoParque = new EcoParque();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("EcoParque");
        query.whereMatches("idEcoParque",idEcoParque);
        try {
            for (ParseObject parseObject : query.find()) {
                ecoParque.setId(parseObject.getString("idEcoParque"));
                ecoParque.setImage(parseObject.getString("url"));
                ecoParque.setLugar(parseObject.getString("lugar"));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ecoParque;
    }
}
