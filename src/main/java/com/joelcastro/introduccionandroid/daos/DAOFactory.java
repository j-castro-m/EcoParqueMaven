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
import com.joelcastro.introduccionandroid.daos.parse.DepositoMaterialParseDAO;
import com.joelcastro.introduccionandroid.daos.parse.DepositoParseDAO;
import com.joelcastro.introduccionandroid.daos.parse.EcoParqueParseDAO;
import com.joelcastro.introduccionandroid.daos.parse.MaterialesParseDAO;
import com.joelcastro.introduccionandroid.daos.sqlite.DepositoMaterialSQLiteDAO;
import com.joelcastro.introduccionandroid.daos.sqlite.DepositoSQLiteDAO;
import com.joelcastro.introduccionandroid.daos.sqlite.EcoParqueSQLiteDAO;
import com.joelcastro.introduccionandroid.daos.sqlite.MaterialesSQLiteDAO;

/**
 * Created by alu03009 on 10/01/14.
 */
@EBean(scope = Scope.Singleton)
public class DAOFactory {

    static int FAKE_DAO = 1;
    static int SQLITEDAO = 2;
    static int PARSEDAO = 3;

    int SELECTED = PARSEDAO;

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
    EcoParqueSQLiteDAO ecoParqueSQLiteDAO;
    @Bean
    DepositoSQLiteDAO depositoSQLiteDAO;
    @Bean
    DepositoMaterialSQLiteDAO depositoMaterialSQLiteDAO;


    @Bean
    MaterialesParseDAO materialesParseDAO;
    @Bean
    EcoParqueParseDAO ecoParqueParseDAO;
    @Bean
    DepositoParseDAO depositoParseDAO;
    @Bean
    DepositoMaterialParseDAO depositoMaterialParseDAO;


    MaterialesDAO materialesDAOSelected;
    EcoParqueDAO ecoParqueDAOSelected;
    DepositoDAO depositoDAOSelected;
    DepositoMaterialDAO depositoMaterialDAOSelected;

    @AfterInject
    void initDAOs(){
        if (SELECTED == FAKE_DAO){
            materialesDAOSelected = materialesFakeDAO;
            ecoParqueDAOSelected = ecoParqueFakeDAO;
            depositoDAOSelected = depositoFakeDAO;
            depositoMaterialDAOSelected = depositoMaterialFakeDAO;
        } else if(SELECTED == SQLITEDAO){
            materialesDAOSelected = materialesSQLiteDAO;
            ecoParqueDAOSelected = ecoParqueSQLiteDAO;
            depositoDAOSelected = depositoSQLiteDAO;
            depositoMaterialDAOSelected = depositoMaterialSQLiteDAO;
        }else if(SELECTED == PARSEDAO){
            materialesDAOSelected = materialesParseDAO;
            ecoParqueDAOSelected = ecoParqueParseDAO;
            depositoDAOSelected = depositoParseDAO;
            depositoMaterialDAOSelected = depositoMaterialParseDAO;
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
