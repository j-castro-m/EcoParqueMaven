package com.joelcastro.introduccionandroid.daos.sqlite;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.api.Scope;
import com.joelcastro.introduccionandroid.daos.DepositoDAO;
import com.joelcastro.introduccionandroid.models.Deposito;

import java.util.List;

/**
 * Created by alu03009 on 10/01/14.
 */
@EBean(scope = Scope.Singleton)
public class DepositoSQLiteDAO implements DepositoDAO {
    @Override
    public List<Deposito> getAllDeposites() {
        return null;
    }
}
