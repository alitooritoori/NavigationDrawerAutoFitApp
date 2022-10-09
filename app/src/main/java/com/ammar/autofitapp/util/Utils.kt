package com.ammar.autofitapp.util

import android.app.AlertDialog

class Utils {
    fun progress(progressDialog: AlertDialog, isShow: Boolean) {
        progressDialog.setTitle("Loading...")
        progressDialog.setCanceledOnTouchOutside(false)
        if (isShow) progressDialog.show() else progressDialog.dismiss()
    }
}