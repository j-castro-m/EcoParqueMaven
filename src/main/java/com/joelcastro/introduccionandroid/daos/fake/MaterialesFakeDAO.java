package com.joelcastro.introduccionandroid.daos.fake;

import com.googlecode.androidannotations.annotations.EBean;
import com.joelcastro.introduccionandroid.daos.MaterialesDAO;
import com.joelcastro.introduccionandroid.models.Material;

import java.util.List;

/**
 * Created by alu03009 on 10/01/14.
 */
@EBean
public class MaterialesFakeDAO  implements MaterialesDAO {

    @Override
    public List<Material> getAllMateriales() {
        return null;
    }
}
