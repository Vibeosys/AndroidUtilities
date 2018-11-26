package com.customutils

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.EditText

import java.util.regex.Matcher
import java.util.regex.Pattern

class CustomEditText : EditText {


    private var mValidType: String? = null
    private var mPasswordMin = 3
    private var mPasswordMax = 12
    private var mMobileNumberMin = 10
    private var mMobileNumberMax = 13


    private val validEmailAddressPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)
    private val validMobileNumberPattern = "^[+]?\\d+"




    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val array = context.obtainStyledAttributes(attrs, R.styleable.Validate)

        mValidType = array.getString(R.styleable.Validate_validate)
        if (array.getString(R.styleable.Validate_passwordMinRange) != null)
            mPasswordMin = Integer.parseInt(array.getString(R.styleable.Validate_passwordMinRange))
        if (array.getString(R.styleable.Validate_passwordMaxRange) != null)
            mPasswordMax = Integer.parseInt(array.getString(R.styleable.Validate_passwordMaxRange))
        if (array.getString(R.styleable.Validate_mobileNumberMinRange) != null)
            mMobileNumberMin = Integer.parseInt(array.getString(R.styleable.Validate_mobileNumberMinRange))
        if (array.getString(R.styleable.Validate_mobileNumberMaxRange) != null)
            mMobileNumberMax = Integer.parseInt(array.getString(R.styleable.Validate_mobileNumberMaxRange))
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val array = context.obtainStyledAttributes(attrs, R.styleable.Validate, defStyleAttr, 0)

        mValidType = array.getString(R.styleable.Validate_validate)
        if (array.getString(R.styleable.Validate_passwordMinRange) != null)
            mPasswordMin = Integer.parseInt(array.getString(R.styleable.Validate_passwordMinRange))
        if (array.getString(R.styleable.Validate_passwordMaxRange) != null)
            mPasswordMax = Integer.parseInt(array.getString(R.styleable.Validate_passwordMaxRange))
        if (array.getString(R.styleable.Validate_mobileNumberMinRange) != null)
            mMobileNumberMin = Integer.parseInt(array.getString(R.styleable.Validate_mobileNumberMinRange))
        if (array.getString(R.styleable.Validate_mobileNumberMaxRange) != null)
            mMobileNumberMax = Integer.parseInt(array.getString(R.styleable.Validate_mobileNumberMaxRange))

    }

    fun isValid(msg: String): Boolean {

        return checkValidation(msg)
    }

    fun isValid(): Boolean {

        return checkValidation(null)
    }

    private fun checkValidation(msg: String?): Boolean {
        val input = this.text.toString()

        if (mValidType != null) {
            if (mValidType == "email") {
                if (!validateEmail(input)) {
                    this.error = msg ?: "Please provide valid email"
                    this.requestFocus()
                    return false
                }
            } else if (mValidType == "name") {
                if (input == "") {
                    this.error = msg ?: "Please provide valid name"
                    this.requestFocus()
                    return false
                }
            } else if (mValidType == "password") {
                if (input == "") {
                    this.error = msg ?: "Please provide valid password"
                    this.requestFocus()
                    return false
                } else if (input.length < mPasswordMin || this.text.toString().length > mPasswordMax) {
                    this.error = msg ?: "Please provide password as minimum $mPasswordMin or maximum $mPasswordMax"
                    this.requestFocus()
                    return false
                }
            } else if (mValidType == "mobileNumber") {
                if (input == "") {
                    this.error = msg ?: "Please provide valid mobile number"
                    this.requestFocus()
                    return false
                } else if (input.length < mMobileNumberMin || this.text.toString().length > mMobileNumberMax) {
                    this.error = msg ?: "Please provide mobile number as minimum $mMobileNumberMin or maximum $mMobileNumberMax"
                    this.requestFocus()
                    return false
                } else if (!validateMobileNumber(input)) {
                    this.error = msg ?: "Please provide valid mobile number"
                    this.requestFocus()
                    return false
                }
            }
        }
        return true
    }


    private fun validateEmail(email: String): Boolean {
        val matcher = validEmailAddressPattern.matcher(email)
        return matcher.find()
    }

    private fun validateMobileNumber(mobileNumber: String): Boolean {
        //Matcher matcher = validMobileNumberPattern.matcher(mobileNumber);
        return mobileNumber.matches(validMobileNumberPattern.toRegex())
    }
}
