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

import com.joelcastro.introduccionandroid.R;
import com.joelcastro.introduccionandroid.models.EcoParque;

import java.util.ArrayList;
import java.util.List;

public class ArrayAdapterEcoParque extends ArrayAdapter<EcoParque> {

    Context mContext;
    int layoutResourceId;
    List<EcoParque> data = new ArrayList<EcoParque>();

    public ArrayAdapterEcoParque(Context mContext, int layoutResourceId, List<EcoParque> data) {

        super(mContext, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView==null){
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }


        EcoParque objectItem = data.get(position);


        TextView textViewItem = (TextView) convertView.findViewById(R.id.textViewItem);
        textViewItem.setText(objectItem.getLugar());
        textViewItem.setTag(objectItem.getId());



        new DownloadImageTask((ImageView) convertView.findViewById(R.id.image4List))
                .execute(objectItem.getImage());
        return convertView;

    }



}