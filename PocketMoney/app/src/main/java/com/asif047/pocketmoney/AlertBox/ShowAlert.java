package com.asif047.pocketmoney.AlertBox;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.asif047.pocketmoney.PocketStartActivity;
import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;

public class ShowAlert {
    private SweetAlertDialog sweetAlertDialog;
    private Context context;

    public ShowAlert(Context context) {
        this.context = context;
    }




    public void showIncomeExpenseSaved()
    {
        sweetAlertDialog=new SweetAlertDialog(context,SweetAlertDialog.SUCCESS_TYPE);
        sweetAlertDialog.setCancelable(false);
        sweetAlertDialog.setTitleText("Saved")
                .setContentText("Data successfully saved")
                .setConfirmText("OK")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        ((Activity)context).finish();
                        Intent intent = new Intent(context, PocketStartActivity.class);
                        context.startActivity(intent);
                    }
                })
                .show();
    }









}
