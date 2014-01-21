package com.joelcastro.introduccionandroid.utils;

/**
 * Created by alu03009 on 21/11/13.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EView;
import com.joelcastro.introduccionandroid.R;
import com.joelcastro.introduccionandroid.models.Deposito;
import com.joelcastro.introduccionandroid.models.EcoParque;

import java.util.List;

public class ArrayAdapterDeposito extends ArrayAdapter<Deposito> {

    Context mContext;
    int layoutResourceId;
    List<Deposito> data = null;

    public ArrayAdapterDeposito(Context mContext, int layoutResourceId, List<Deposito> data) {
        super(mContext, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        DepositoListItemView itemView;

        if(convertView==null){
            itemView = DepositoListItemView_.build(mContext);
            //LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            //convertView = inflater.inflate(layoutResourceId, parent, false);
        }else{
            itemView = (DepositoListItemView) convertView;
        }
        itemView.fillData(data.get(position));
        return itemView;

    }



}