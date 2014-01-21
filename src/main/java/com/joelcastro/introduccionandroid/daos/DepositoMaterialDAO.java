package com.joelcastro.introduccionandroid.daos;

import com.joelcastro.introduccionandroid.models.Deposito;
import com.joelcastro.introduccionandroid.models.Material;

import java.util.List;

/**
 * Created by alu03009 on 21/01/14.
 */
public interface DepositoMaterialDAO {
    public List<Integer> getMateriales(Deposito deposito);

    public void addDepositoMaterial(int idMaterial, int idDeposito);
    public void deleteDepositoMaterial(int idMaterial, int idDeposito);
}
