package com.github.therajanmaurya.sweeterror.demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class SweetMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEmptyUI.setOnClickListener { sweetIntent(SweetErrorType.EMPTY_UI) }
        btnErrorUI.setOnClickListener { sweetIntent(SweetErrorType.ERROR_UI) }
        btnNoInternetUI.setOnClickListener { sweetIntent(SweetErrorType.NO_INTERNET) }
        btnCustomErrorUI.setOnClickListener { sweetIntent(SweetErrorType.CUSTOM) }
        btnCustomStyleErrorUI.setOnClickListener { sweetIntent(SweetErrorType.CUSTOM_STYLE) }
    }

    private fun sweetIntent(sweetErrorType: SweetErrorType) {
        val sweetIntent = Intent(this, SweetErrorInActivity::class.java)
        sweetIntent.putExtra(ConstantKeys.SWEET_ERROR_TYPE, sweetErrorType)
        startActivity(sweetIntent)
    }
}
