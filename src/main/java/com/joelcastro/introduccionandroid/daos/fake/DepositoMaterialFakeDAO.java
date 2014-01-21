package com.joelcastro.introduccionandroid.daos.fake;

import com.googlecode.androidannotations.annotations.EBean;
import com.joelcastro.introduccionandroid.daos.DepositoMaterialDAO;
import com.joelcastro.introduccionandroid.models.Deposito;
import com.joelcastro.introduccionandroid.models.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alu03009 on 21/01/14.
 */
@EBean
public class DepositoMaterialFakeDAO implements DepositoMaterialDAO {
    @Override
    public List<String> getMateriales(Deposito deposito) {
        List<String> data = new ArrayList<String>();

        data.add("1");
        data.add("2");
        data.add("3");

        return data;
    }

    public void addDepositoMaterial(String idMaterial, String idDeposito) {

    }

    @Override
    public void deleteDepositoMaterial(String idMaterial, String idDeposito) {

    }
}
