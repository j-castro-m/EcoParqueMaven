package com.joelcastro.introduccionandroid.daos.fake;

import com.joelcastro.introduccionandroid.daos.DepositoMaterialDAO;
import com.joelcastro.introduccionandroid.models.Deposito;
import com.joelcastro.introduccionandroid.models.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alu03009 on 21/01/14.
 */
public class DepositoMaterialFakeDAO implements DepositoMaterialDAO {
    @Override
    public List<Material> getMateriales(Deposito deposito) {
        List<Material> data = new ArrayList<Material>();

        data.add(new Material(1, "Material informático"));
        data.add(new Material(2, "Neveras"));
        data.add(new Material(3, "Aceites usados"));

        return data;
    }
}
