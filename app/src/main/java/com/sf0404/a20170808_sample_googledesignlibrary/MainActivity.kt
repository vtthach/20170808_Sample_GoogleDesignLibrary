package com.sf0404.a20170808_sample_googledesignlibrary

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sf0404.a20170808_sample_googledesignlibrary.edittext.PhoneNumberAutoFormatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goToTabLayoutActivity(view: View){
        TabLayoutActivityJava.showMe(this)
    }

    fun gotoPhoneNumberAutoFormat(view: View) {
        PhoneNumberAutoFormatActivity.showMe(this)
    }
}
