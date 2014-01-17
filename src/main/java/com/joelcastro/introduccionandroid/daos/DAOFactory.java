package com.joelcastro.introduccionandroid.daos;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.api.Scope;
import com.joelcastro.introduccionandroid.daos.MaterialesDAO;
import com.joelcastro.introduccionandroid.daos.fake.MaterialesFakeDAO;
import com.joelcastro.introduccionandroid.daos.sqlite.DepositoSQLiteDAO;
import com.joelcastro.introduccionandroid.daos.sqlite.MaterialesSQLiteDAO;

/**
 * Created by alu03009 on 10/01/14.
 */
@EBean(scope = Scope.Singleton)
public class DAOFactory {

    boolean useFakeData = false;

    @Bean
    MaterialesFakeDAO materialesFakeDAO;

    @Bean
    MaterialesSQLiteDAO materialesSQLiteDAO;


    MaterialesDAO materialesDAOSelected;

    @AfterInject
    void initDAOs(){
        if (useFakeData){
            materialesDAOSelected = materialesFakeDAO;
        } else {
            materialesDAOSelected = materialesSQLiteDAO;
        }
    }

    public MaterialesSQLiteDAO getMaterialesDAO(){
        return materialesSQLiteDAO;
    }

    public DepositoSQLiteDAO getDepositosDAO(){
        // Igual que antes
        return null;
    }
}
