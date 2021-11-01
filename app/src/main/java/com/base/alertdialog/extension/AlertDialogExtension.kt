package com.base.alertdialog.extension

import android.app.Activity
import androidx.fragment.app.Fragment
import com.base.alertdialog.helper.AlertDialogHelper


inline fun Activity.showAlertDialog(func: AlertDialogHelper.() -> Unit): android.app.AlertDialog =
    AlertDialogHelper(this).apply {
        func()
    }.create()


inline fun Fragment.showAlertDialog(func: AlertDialogHelper.() -> Unit): android.app.AlertDialog =
    AlertDialogHelper(context!!).apply {
        func()
    }.create()