//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package com.joelcastro.introduccionandroid.daos.sqlite;

import android.app.Activity;
import android.content.Context;
import android.view.View;

public final class DepositoSQLiteDAO_
    extends DepositoSQLiteDAO
{

    private Context context_;
    private static DepositoSQLiteDAO_ instance_;

    private DepositoSQLiteDAO_(Context context) {
        context_ = context;
        init_();
    }

    public void afterSetContentView_() {
        if (!(context_ instanceof Activity)) {
            return ;
        }
    }

    /**
     * You should check that context is an activity before calling this method
     * 
     */
    public View findViewById(int id) {
        Activity activity_ = ((Activity) context_);
        return activity_.findViewById(id);
    }

    @SuppressWarnings("all")
    private void init_() {
        if (context_ instanceof Activity) {
            Activity activity = ((Activity) context_);
        }
    }

    public static DepositoSQLiteDAO_ getInstance_(Context context) {
        if (instance_ == null) {
            instance_ = new DepositoSQLiteDAO_(context.getApplicationContext());
        }
        return instance_;
    }

    public void rebind(Context context) {
    }

}
