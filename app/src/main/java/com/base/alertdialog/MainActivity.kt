package com.base.alertdialog

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.base.alertdialog.extension.showAlertDialog

class MainActivity : AppCompatActivity() {

    private var alertDialog: AlertDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showAlertDialog()
    }


    private fun showAlertDialog() {

        alertDialog = showAlertDialog {
            cancelable = false

            setTitle("Title")
            setBody("Body")

            prepareOkayButton("Okay", "#A7DE3D")
            prepareCancelButton("Cancel", "#F77B7B")

            okayClickListener {

                Toast.makeText(applicationContext, "OkayListener", Toast.LENGTH_SHORT).show()
                alertDialog?.dismiss()
            }

            cancelClickListener {

                Toast.makeText(applicationContext, "CancelListener", Toast.LENGTH_SHORT).show()
                alertDialog?.dismiss()
            }
        }

        alertDialog?.show()
    }
}