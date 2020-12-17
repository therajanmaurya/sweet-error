package com.github.therajanmaurya.sweeterror.demo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.github.therajanmaurya.sweeterror.SweetUIErrorHandler
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_sweet_error.*


/**
 * @author Rajan Maurya
 * On 05/11/17.
 */
class SweetErrorInActivity : AppCompatActivity() {

    private lateinit var sweetUIErrorHandler: SweetUIErrorHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sweet_error)

        sweetUIErrorHandler = SweetUIErrorHandler(this, findViewById(android.R.id.content))

        val sweetErrorType = intent
                .getSerializableExtra(ConstantKeys.SWEET_ERROR_TYPE) as SweetErrorType

        when (sweetErrorType) {
            SweetErrorType.EMPTY_UI -> {
                sweetUIErrorHandler.showSweetEmptyUI(getString(R.string.sweets),
                        getString(R.string.sweet), R.drawable.ic_adb_black_24dp,
                        llSweet, layoutError)
            }
            SweetErrorType.ERROR_UI -> {
                sweetUIErrorHandler.showSweetErrorUI(getString(R.string.sweets), llSweet, layoutError)
            }
            SweetErrorType.NO_INTERNET -> {
                sweetUIErrorHandler.showSweetNoInternetUI(llSweet, layoutError)
            }
            SweetErrorType.CUSTOM -> {
                fabAddSweet.hide()
                sweetUIErrorHandler.showSweetCustomErrorUI(getString(R.string.no_sweets_found),
                        getString(R.string.come_later_again), R.drawable.ic_adb_black_24dp,
                        llSweet, layoutError)
            }
            SweetErrorType.CUSTOM_STYLE -> {

                sweetUIErrorHandler.setBackgroundColor(R.color.grey_background)
                sweetUIErrorHandler.showCustomFeatureImage(false)
                sweetUIErrorHandler.setCustomFeatureImageTintColor(R.color.colorAccent)
                sweetUIErrorHandler.setCustomFeatureTextTypeFace(ResourcesCompat.getFont(this, R.font.nunito)!!)
                sweetUIErrorHandler.setCustomSubFeatureTextTypeFace(ResourcesCompat.getFont(this, R.font.nunito)!!)

                sweetUIErrorHandler.showSweetCustomErrorUI(getString(R.string.no_sweets_found),
                        getString(R.string.come_later_again), R.drawable.ic_adb_black_24dp,
                        llSweet, layoutError)
            }
        }


        fabAddSweet.setOnClickListener {
            Snackbar.make(clSweet, "Adding Sweet :)", Snackbar.LENGTH_LONG).show()
        }

        findViewById<Button>(R.id.btnTryAgain).setOnClickListener {
            Snackbar.make(clSweet, "Loading Sweet ...",
                    Snackbar.LENGTH_LONG).show()
        }
    }
}
