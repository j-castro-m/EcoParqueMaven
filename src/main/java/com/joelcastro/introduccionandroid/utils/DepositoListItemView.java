package com.joelcastro.introduccionandroid.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EViewGroup;
import com.googlecode.androidannotations.annotations.ViewById;
import com.joelcastro.introduccionandroid.R;
import com.joelcastro.introduccionandroid.activities.CompanyDataActivity_;
import com.joelcastro.introduccionandroid.activities.ResultsActivity_;
import com.joelcastro.introduccionandroid.activities.TypeAndQuantityActivity;
import com.joelcastro.introduccionandroid.activities.TypeAndQuantityActivity_;
import com.joelcastro.introduccionandroid.models.Deposito;

/**
 * Created by alu03009 on 21/01/14.
 */
@EViewGroup(R.layout.deposito_item_layout)
public class DepositoListItemView extends RelativeLayout {

    @ViewById(R.id.depositoListItemIdAndWeight)
    TextView idAndWeigth;

    @ViewById(R.id.depositoListItemFecha)
    TextView fecha;


    Context context;
    Deposito deposito;

    public DepositoListItemView(Context context) {
        super(context);
        this.context=context;
    }

    public void fillData(Deposito deposito)
    {
        this.deposito=deposito;
        idAndWeigth.setText(deposito.getDepositanteId() + " (" +deposito.getPeso() + "Kg)");
        idAndWeigth.setTag(deposito.getId());

        fecha.setText(deposito.getFecha());

    }

    @Click(R.id.depositoListItemButtonEditar)
    public void onEditClick()
    {
        Intent intent=new Intent(context, TypeAndQuantityActivity_.class);
        intent.putExtra("cif",deposito.getDepositanteId());
        intent.putExtra("company",deposito.getCompany());
        context.startActivity(intent);
    }

    @Click(R.id.depositoListItemFull)
    public void onAllClick(){
        Intent intent = new Intent().setClass(context, ResultsActivity_.class);
        intent.putExtra("ITmat", deposito.getIt());
        intent.putExtra("Fridge", deposito.getFridges());
        intent.putExtra("Oil", deposito.getOil());
        intent.putExtra("Peso", deposito.getPeso());
        intent.putExtra("cif", deposito.getDepositanteId());
        intent.putExtra("email","test@gmail.com");

        context.startActivity(intent);
    }
}
