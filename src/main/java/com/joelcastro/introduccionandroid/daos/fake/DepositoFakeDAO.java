package com.joelcastro.introduccionandroid.daos.fake;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.api.Scope;
import com.joelcastro.introduccionandroid.daos.DepositoDAO;
import com.joelcastro.introduccionandroid.models.Deposito;
import com.joelcastro.introduccionandroid.models.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alu03009 on 10/01/14.
 */
@EBean(scope = Scope.Singleton)
public class DepositoFakeDAO implements DepositoDAO {

    public DepositoFakeDAO() {
    }

    @Override
    public List<Deposito> getAllDeposites() {
        List<Deposito> objectItemData = new ArrayList<Deposito>();
        objectItemData.add(new Deposito(1,1,"18056045X","10/1/2013","35",true,false,false,false,"","","","",""));
        objectItemData.add(new Deposito(2,1,"18056045X","14/1/2013","65",false,true,false,false,"","","","",""));
        objectItemData.add(new Deposito(4,1,"18056045X","10/1/2014","59",true,true,false,false,"","","","",""));
        objectItemData.add(new Deposito(3,2,"18056045X","16/1/2014","87",false,false,true,false,"","","","",""));
        return objectItemData;

    }

    @Override
    public List<Deposito> getDepositesFromEcoParque(int idEcoParque) {
        List<Deposito> objectItemData = new ArrayList<Deposito>();
        if(idEcoParque == 1){
            objectItemData.add(new Deposito(1,1,"18056045X","10/1/2013","35",true,false,false,false,"","","","",""));
            objectItemData.add(new Deposito(2,1,"18056045X","14/1/2013","65",false,true,false,false,"","","","",""));
            objectItemData.add(new Deposito(4,1,"18056045X","10/1/2014","59",true,true,false,false,"","","","",""));
        }else if(idEcoParque == 2){
            objectItemData.add(new Deposito(3,2,"18056045X","16/1/2014","87",false,false,true,false,"","","","",""));
        }
            return objectItemData;

    }

    @Override
    public void addDeposito(Deposito deposito) {

    }

    @Override
    public void editDeposito(Deposito deposito) {

    }
}
