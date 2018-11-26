package com.customutils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.widget.CardView
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast



/**
 * Created by chetan on 30-04-2018.
 */
class CustomToast(context: Context) {

    private var mContext :Context?=null
    private var mToastView:View? = null
    private var mToastTv:TextView?=null
    private var mToastIv: ImageView?=null
    private var mToastCard:CardView?=null



    init {
        mContext = context
        val inflater = (mContext as Activity).layoutInflater
        mToastView = inflater.inflate(R.layout.toast_custom, null)
        mToastTv = mToastView?.findViewById(R.id.toast_Tv)
        mToastIv = mToastView?.findViewById(R.id.toast_Iv)
        mToastCard = mToastView?.findViewById(R.id.main_card)


    }


    fun showSuccess(msg: String) {
        // for success toast
        mToastCard?.setCardBackgroundColor(mContext?.resources!!.getColor(R.color.successColor))
        mToastTv?.setText(msg)
        mToastIv?.setImageResource(R.drawable.ic_correct)
        val toast = Toast(mContext)
        toast.view = mToastView
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }

    fun showError(msg: String) {
        mToastCard?.setCardBackgroundColor(mContext?.resources!!.getColor(R.color.errorColor))
        mToastTv?.setText(msg)
        mToastIv?.setImageResource(R.drawable.ic_wrong)
        val toast = Toast(mContext)
        toast.view = mToastView
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }

    fun showNetworkError() {
        mToastCard?.setCardBackgroundColor(mContext?.resources!!.getColor(R.color.errorColor))
        mToastTv?.setText("Something went wrong, please try again")
        mToastIv?.setImageResource(R.drawable.ic_wrong)
        val toast = Toast(mContext)
        toast.view = mToastView
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }

    fun showNetworkUnAvailable() {
        mToastCard?.setCardBackgroundColor(mContext?.resources!!.getColor(R.color.errorColor))
        mToastTv?.setText("Network not available")
        mToastIv?.setImageResource(R.drawable.ic_wrong)
        val toast = Toast(mContext)
        toast.view = mToastView
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }










}