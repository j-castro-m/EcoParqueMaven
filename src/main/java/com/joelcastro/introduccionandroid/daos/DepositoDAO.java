package com.joelcastro.introduccionandroid.daos;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.sharedpreferences.SharedPref;
import com.googlecode.androidannotations.api.Scope;
import com.joelcastro.introduccionandroid.models.Deposito;
import com.joelcastro.introduccionandroid.models.Material;

import java.util.List;

/**
 * Created by alu03009 on 10/01/14.
 */

public interface DepositoDAO {


    public List<Deposito> getAllDeposites();
}
