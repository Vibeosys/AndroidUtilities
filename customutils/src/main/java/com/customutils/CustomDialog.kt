package com.customutils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class CustomDialog(context: Context) {

    private var mContext:Context?=null
    private var mDialog : Dialog?=null
    private var mDialogMessage : TextView?=null
    private var mDialogTitle : TextView?=null
    private var mBtnLayout: LinearLayout?=null

    private var mOkBtn : Button?=null
    private var mCancelBtn : Button?=null

    init {

        mContext = context
        mContext = context
        mDialog = getDialog(mContext!!, R.layout.dialogue_success_layout)
        mBtnLayout = mDialog?.findViewById(R.id.btn_background_layout)
        mDialogMessage = mDialog?.findViewById(R.id.message_Tv)
        mDialogTitle = mDialog?.findViewById(R.id.title_Tv)
        mCancelBtn = mDialog?.findViewById(R.id.cancel_btn)
        mOkBtn = mDialog?.findViewById(R.id.ok_btn)

    }

    fun showAlert(message: String,title:String,btnText:String, okListener: DialogClick) {
        mOkBtn?.setTextColor(mContext?.resources!!.getColor(R.color.errorColor))
        mBtnLayout?.setBackgroundResource(R.drawable.error_bg)
        mDialogMessage?.setText(message)
        mCancelBtn?.setText("Cancel")
        mDialogTitle?.setText(title)
        mCancelBtn?.visibility =View.VISIBLE
        mCancelBtn?.setOnClickListener {
            mDialog?.dismiss()
        }
        mOkBtn?.setText(btnText)
        mOkBtn?.setOnClickListener {
            mDialog?.dismiss()
            okListener.dialogClick()
        }
        mDialog?.show()

    }


    fun showSuccess(message: String, okListener: DialogClick) {
        mBtnLayout?.setBackgroundResource(R.drawable.success_bg)
        mOkBtn?.setTextColor(mContext?.resources!!.getColor(R.color.black))
        mDialogMessage?.setText(message)
        mCancelBtn?.setText("Cancel")
        mDialogTitle?.setText("Success")
        mCancelBtn?.visibility =View.GONE
        mCancelBtn?.setOnClickListener {
            mDialog?.dismiss()
        }
        mOkBtn?.setText("Ok")
        mOkBtn?.setOnClickListener {
            mDialog?.dismiss()
            okListener.dialogClick()
        }
        mDialog?.show()
    }

    fun showSuccess(message: String) {
        mBtnLayout?.setBackgroundResource(R.drawable.success_bg)
        mOkBtn?.setTextColor(mContext?.resources!!.getColor(R.color.black))
        mDialogMessage?.setText(message)
        mCancelBtn?.setText("Cancel")
        mDialogTitle?.setText("Success")
        mCancelBtn?.visibility =View.GONE
        mCancelBtn?.setOnClickListener {
            mDialog?.dismiss()
        }
        mOkBtn?.setText("Ok")

        mOkBtn?.setOnClickListener {
            mDialog?.dismiss()
        }
        mDialog?.show()

    }
    fun getDialog(mContext: Context, id: Int): Dialog {

        val mDialog = Dialog(mContext)
        mDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mDialog.setCancelable(false)
        mDialog.setContentView(id)
        return mDialog

    }

}