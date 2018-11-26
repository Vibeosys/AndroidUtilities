package com.vibeosys.customutils

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.customutils.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(!NetworkUtils.isNetworkAvailable(this))
        {
            CustomToast(this).showNetworkUnAvailable()
        }
        loginBtn.setOnClickListener {
            if(emailEt.isValid() && nameEt.isValid())
            {

            }

        }

    }
}
