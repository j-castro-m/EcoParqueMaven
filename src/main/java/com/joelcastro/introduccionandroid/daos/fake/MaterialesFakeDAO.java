package com.joelcastro.introduccionandroid.daos.fake;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.api.Scope;
import com.joelcastro.introduccionandroid.daos.MaterialesDAO;
import com.joelcastro.introduccionandroid.models.Material;

import java.util.List;

/**
 * Created by alu03009 on 10/01/14.
 */
@EBean(scope = Scope.Singleton)
public class MaterialesFakeDAO  implements MaterialesDAO {

    public MaterialesFakeDAO() {
    }

    @Override
    public List<Material> getAllMateriales() {
        return null;
    }
}
