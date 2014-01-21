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
        objectItemData.add(new Deposito("1","1","18056045X","10/1/2013","35"));
        objectItemData.add(new Deposito("2","1","18056045X","14/1/2013","65"));
        objectItemData.add(new Deposito("4","1","18056045X","10/1/2014","59"));
        objectItemData.add(new Deposito("3","2","18056045X","16/1/2014","87"));
        return objectItemData;

    }

    @Override
    public List<Deposito> getDepositesFromEcoParque(String idEcoParque) {
        List<Deposito> objectItemData = new ArrayList<Deposito>();
        if(idEcoParque.equals("1")){
            objectItemData.add(new Deposito("1","1","18056045X","10/1/2013","35"));
            objectItemData.add(new Deposito("2","1","18056045X","14/1/2013","65"));
            objectItemData.add(new Deposito("4","1","18056045X","10/1/2014","59"));
        }else if(idEcoParque.equals("2")){
            objectItemData.add(new Deposito("3","2","18056045X","16/1/2014","87"));
        }
            return objectItemData;

    }

    @Override
    public String addDeposito(Deposito deposito) {
        return deposito.getId();
    }

    @Override
    public void editDeposito(Deposito deposito) {

    }
}
