package com.joelcastro.introduccionandroid.daos;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.api.Scope;
import com.joelcastro.introduccionandroid.daos.MaterialesDAO;
import com.joelcastro.introduccionandroid.daos.fake.DepositoFakeDAO;
import com.joelcastro.introduccionandroid.daos.fake.DepositoMaterialFakeDAO;
import com.joelcastro.introduccionandroid.daos.fake.EcoParqueFakeDAO;
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
    EcoParqueFakeDAO ecoParqueFakeDAO;

    @Bean
    DepositoFakeDAO depositoFakeDAO;

    @Bean
    DepositoMaterialFakeDAO depositoMaterialFakeDAO;

    @Bean
    MaterialesSQLiteDAO materialesSQLiteDAO;


    @Bean
    EcoParqueFakeDAO ecoParqueSQLiteDAO;

    @Bean
    DepositoFakeDAO depositoSQLiteDAO;

    @Bean
    DepositoMaterialFakeDAO depositoMaterialSQLiteDAO;

    MaterialesDAO materialesDAOSelected;
    EcoParqueDAO ecoParqueDAOSelected;
    DepositoDAO depositoDAOSelected;
    DepositoMaterialDAO depositoMaterialDAOSelected;

    @AfterInject
    void initDAOs(){
        if (useFakeData){
            materialesDAOSelected = materialesFakeDAO;
            ecoParqueDAOSelected = ecoParqueFakeDAO;
            depositoDAOSelected = depositoFakeDAO;
            depositoMaterialDAOSelected = depositoMaterialFakeDAO;
        } else {
            materialesDAOSelected = materialesSQLiteDAO;
            ecoParqueDAOSelected = ecoParqueSQLiteDAO;
            depositoDAOSelected = depositoSQLiteDAO;
            depositoMaterialDAOSelected = depositoMaterialSQLiteDAO;
        }
    }

    public MaterialesDAO getMaterialesDAO(){
        return materialesDAOSelected;
    }

    public DepositoDAO getDepositosDAO(){return depositoDAOSelected;}
    public EcoParqueDAO getEcoParqueDAO(){return ecoParqueDAOSelected;}

    public DepositoMaterialDAO getDepositoMaterialDAO() {
        return depositoMaterialDAOSelected;
    }
}
