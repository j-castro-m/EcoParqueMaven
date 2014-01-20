package com.joelcastro.introduccionandroid.daos;

import com.googlecode.androidannotations.annotations.EBean;
import com.joelcastro.introduccionandroid.models.Deposito;
import com.joelcastro.introduccionandroid.models.EcoParque;

import java.util.List;

/**
 * Created by alu03009 on 20/01/14.
 */

public interface EcoParqueDAO {

    public List<EcoParque> getAllEcoParques();
}
