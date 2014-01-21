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
    public List<Integer> getMateriales(Deposito deposito) {
        List<Integer> data = new ArrayList<Integer>();

        data.add(1);
        data.add(2);
        data.add(3);

        return data;
    }

    public void addDepositoMaterial(int idMaterial, int idDeposito) {

    }

    @Override
    public void deleteDepositoMaterial(int idMaterial, int idDeposito) {

    }
}
