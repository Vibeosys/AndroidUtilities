package com.customutils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window

class LoadingDialog(context: Context) {

    private var mDialog: Dialog? = null
    private var mContext: Context? = null


    init {
        mContext = context
        mDialog = getDialog(mContext!!, R.layout.dialog_loading)
    }

    fun getDialog(mContext: Context, id: Int): Dialog {

        val mDialog = Dialog(mContext)
        mDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mDialog.setCancelable(false)
        mDialog.setContentView(id)
        return mDialog

    }

    open fun getDialog(): Dialog {
        return mDialog!!
    }

    open fun show() {
        mDialog?.show()
    }

    open fun hide() {
        mDialog?.dismiss()
    }

}