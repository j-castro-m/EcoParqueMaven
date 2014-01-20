package com.joelcastro.introduccionandroid.daos;

import com.googlecode.androidannotations.annotations.EBean;
import com.joelcastro.introduccionandroid.models.Material;

import java.util.List;

/**
 * Created by alu03009 on 10/01/14.
 */

public interface MaterialesDAO {


    public List<Material> getAllMateriales();
}
