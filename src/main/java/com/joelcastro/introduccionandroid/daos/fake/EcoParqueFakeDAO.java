package com.joelcastro.introduccionandroid.daos.fake;

import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.api.Scope;
import com.joelcastro.introduccionandroid.R;
import com.joelcastro.introduccionandroid.daos.EcoParqueDAO;
import com.joelcastro.introduccionandroid.models.EcoParque;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alu03009 on 20/01/14.
 */
@EBean(scope = Scope.Singleton)
public class EcoParqueFakeDAO implements EcoParqueDAO {

    public EcoParqueFakeDAO() {
    }

    @Override
    public List<EcoParque> getAllEcoParques() {

        List<EcoParque> objectItemData = new ArrayList<EcoParque>();
        objectItemData.add(new EcoParque("1", "San Jose - Las Fuentes","http://www.restauranteateneo.es/sites/all/themes/ateneo/images/bus.png"));
        objectItemData.add(new EcoParque("2", "Cogullada","http://www.restauranteateneo.es/sites/all/themes/ateneo/images/bus.png"));
        objectItemData.add(new EcoParque("4", "Universidad - Delicias","http://www.restauranteateneo.es/sites/all/themes/ateneo/images/bus.png"));
        objectItemData.add(new EcoParque("3", "Valdespartera","http://www.restauranteateneo.es/sites/all/themes/ateneo/images/bus.png"));
        return objectItemData;
    }

    @Override
    public EcoParque getEcoParque(String idEcoParque) {
        int valueInt = Integer.valueOf(idEcoParque);
        switch(valueInt){
            case 1:
                return new EcoParque("1", "San Jose - Las Fuentes","http://www.restauranteateneo.es/sites/all/themes/ateneo/images/bus.png");
            case 2:
                return new EcoParque("2", "Cogullada","http://www.restauranteateneo.es/sites/all/themes/ateneo/images/bus.png");
            case 3:
                return new EcoParque("3", "Valdespartera","http://www.restauranteateneo.es/sites/all/themes/ateneo/images/bus.png");
            case 4:
                return new EcoParque("4", "Universidad - Delicias","http://www.restauranteateneo.es/sites/all/themes/ateneo/images/bus.png");
            default:
                return new EcoParque("4", "Universidad - Delicias","http://www.restauranteateneo.es/sites/all/themes/ateneo/images/bus.png");
        }
    }
}
