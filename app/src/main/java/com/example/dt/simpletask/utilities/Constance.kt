package com.example.dt.simpletask.utilities

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Build
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.dt.simpletask.R


var progressDialog: Dialog? = null
var  fcmToken  : String = "123"
var  apiKey  : String = "fd94f23499b954d6cea823567a606a3f"

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
fun initializeProgressDialog(context: Context?) {
    val alertDialogBuilder = AlertDialog.Builder(context).setCancelable(false)
    alertDialogBuilder.setView(R.layout.progress_dialog_loader)
    progressDialog = alertDialogBuilder.create()
    (progressDialog as AlertDialog?)?.window?.setLayout(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT
    )
    (progressDialog as AlertDialog?)?.window?.setBackgroundDrawableResource(R.color.dialogTrans)
}
fun showProgressDialog(show: Boolean) {
    if (progressDialog != null) {
        if (show) progressDialog!!.show() else progressDialog!!.hide()
    }
}
