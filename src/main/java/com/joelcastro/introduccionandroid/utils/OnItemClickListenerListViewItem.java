package com.joelcastro.introduccionandroid.utils;

/**
 * Created by alu03009 on 21/11/13.
 */
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;
import com.joelcastro.introduccionandroid.R;

import com.joelcastro.introduccionandroid.activities.UserTypeActivity_;


public class OnItemClickListenerListViewItem implements OnItemClickListener {
    //@Pref MyPrefs myPrefs;
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Context context = view.getContext();

        TextView textViewItem = ((TextView) view.findViewById(R.id.textViewItem));
        String listItemText = textViewItem.getText().toString();
        int listItemId = Integer.valueOf(textViewItem.getTag().toString());


        Intent intent = new Intent().setClass(context, UserTypeActivity_.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //myPrefs.idEcoParque().put(listItemId);
        //myPrefs.lugarEcoParque().put(listItemText);
        context.startActivity(intent);

    }

}