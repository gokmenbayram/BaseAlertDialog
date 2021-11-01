package com.base.alertdialog.helper

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.base.alertdialog.R

class AlertDialogHelper(context: Context) : BaseAlertDialogHelper() {

    override val dialogView: View by lazy {
        LayoutInflater.from(context).inflate(R.layout.dialog_custom, null)
    }

    override val builder: AlertDialog.Builder = AlertDialog.Builder(context).setView(dialogView)

    val title: TextView by lazy {
        dialogView.findViewById(R.id.title)
    }

    val body: TextView by lazy {
        dialogView.findViewById(R.id.body)
    }


    private val okayButton: Button by lazy {
        dialogView.findViewById(R.id.okay_btn)
    }

    private val cancelButton: Button by lazy {
        dialogView.findViewById(R.id.cancel_btn)
    }

    private val questionLayout: LinearLayout by lazy {
        dialogView.findViewById(R.id.question_layout)
    }


    fun setTitle(title: String, textColor: String? = null) {

        this.title.text = title

        textColor?.let {

            this.title.setTextColor(Color.parseColor(textColor))
        }
    }

    fun setBody(body: String? = null, visibility: Boolean? = true) {

        if (visibility == true) {

            this.body.visibility = View.VISIBLE
            this.body.text = body
        }
        else {

            this.body.visibility = View.GONE
        }
    }

    fun prepareCancelButton(text: String? = null, bgColor: String? = null, visibility: Boolean = true) {

        if (visibility) {
            text?.let {

                cancelButton.text = it
            }

            bgColor?.let {

                cancelButton.setBackgroundColor(Color.parseColor(it))
            }
        }

        else {

            cancelButton.visibility = View.GONE
        }
    }

    fun prepareOkayButton(text: String? = null, bgColor: String? = null) {

        text?.let {

            okayButton.text = it
        }

        bgColor?.let {

            okayButton.setBackgroundColor(Color.parseColor(bgColor))
        }
    }

    fun cancelClickListener(func: (() -> Unit)? = null) =
        with(cancelButton) {
            setClickListener(func)
        }

    fun okayClickListener(func: (() -> Unit)? = null) =
        with(okayButton) {
            setClickListener(func)
        }


    private fun View.setClickListener(func: (() -> Unit)?) =
        setOnClickListener {
            func?.invoke()
            dialog?.dismiss()
        }
}