package com.github.therajanmaurya.sweeterror

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

/**
 * @author Rajan Maurya
 * On 04/11/17.
 */
class SweetUIErrorHandler(private val context: Context, private val view: View) {

    private lateinit var ivEmptyFeatureImage: ImageView
    private lateinit var ivErrorNoInternet: ImageView
    private lateinit var ivCustomFeatureImage: ImageView

    private lateinit var tvFeatureName: TextView
    private lateinit var tvSubFeatureName: TextView
    private lateinit var tvErrorFeatureName: TextView
    private lateinit var tvCustomFeatureName: TextView
    private lateinit var tvCustomSubFeatureName: TextView

    private lateinit var llEmptyUI: LinearLayout
    private lateinit var llErrorToLoad: LinearLayout
    private lateinit var llNoInternet: LinearLayout
    private lateinit var llError: LinearLayout
    private lateinit var llCustomUI: LinearLayout

    private lateinit var btnTryAgain: Button

    init {
        initializeUIComponent()
    }

    /**
     * Show the Empty UI with Feature image and feature name and sub feature name.
     *
     * @param featureName    Feature Name
     * @param subFeatureName Sub Feature Name
     * @param featureImage   Feature Image that you wanna show
     */
    fun showSweetEmptyUI(featureName: String, subFeatureName: String, featureImage: Int?,
                         featureLayoutUI: View, sweetErrorLayoutUI: View) {
        featureLayoutUI.visibility = View.GONE
        sweetErrorLayoutUI.visibility = View.VISIBLE
        llErrorToLoad.visibility = View.GONE
        llCustomUI.visibility = View.GONE
        llEmptyUI.visibility = View.VISIBLE
        ivEmptyFeatureImage.setImageResource(featureImage!!)
        tvFeatureName.text = context.getString(R.string.empty_ui_message, featureName)
        tvSubFeatureName.text = context.getString(R.string.empty_ui_sub_message, subFeatureName)
    }

    /**
     * Show the Empty UI with Feature image and feature name. It will hide the sub feature name from
     * bottom of feature name and only show two things feature image and name.
     *
     * @param featureName  Feature Name
     * @param featureImage Sub Feature Name
     */
    fun showSweetEmptyUI(featureName: String, featureImage: Int?, featureLayoutUI: View,
                         sweetErrorLayoutUI: View) {
        featureLayoutUI.visibility = View.GONE
        sweetErrorLayoutUI.visibility = View.VISIBLE
        llErrorToLoad.visibility = View.GONE
        llCustomUI.visibility = View.GONE
        llEmptyUI.visibility = View.VISIBLE
        ivEmptyFeatureImage.setImageResource(featureImage!!)
        tvFeatureName.text = context.getString(R.string.empty_ui_message, featureName)
        tvSubFeatureName.visibility = View.GONE
    }

    /**
     * Show the Error UI with the No Network Image and with text
     * "Sorry we weren't able to load {Feature Name}" and with button {Try Again}.
     *
     * @param featureName Feature Name
     */
    fun showSweetErrorUI(featureName: String, featureLayoutUI: View,
                         sweetErrorLayoutUI: View) {
        featureLayoutUI.visibility = View.GONE
        sweetErrorLayoutUI.visibility = View.VISIBLE
        llEmptyUI.visibility = View.GONE
        llCustomUI.visibility = View.GONE
        llNoInternet.visibility = View.GONE
        llErrorToLoad.visibility = View.VISIBLE
        llError.visibility = View.VISIBLE
        btnTryAgain.text = context.getString(R.string.try_again)
        tvErrorFeatureName.text = featureName
        ivErrorNoInternet.setImageResource(R.drawable.ic_cloud_off_black_24dp)
    }

    /**
     * Show the text "Sorry we weren't able to load {Feature Name}" and
     * with button {Try Again} and can update the No Network Image and with
     * the any feature image you will pass.
     *
     * @param featureName  Feature Name
     * @param featureImage Feature Image
     */
    fun showSweetErrorUI(featureName: String, featureImage: Int?, featureLayoutUI: View,
                         sweetErrorLayoutUI: View) {
        featureLayoutUI.visibility = View.GONE
        sweetErrorLayoutUI.visibility = View.VISIBLE
        llEmptyUI.visibility = View.GONE
        llCustomUI.visibility = View.GONE
        llNoInternet.visibility = View.GONE
        llErrorToLoad.visibility = View.VISIBLE
        llError.visibility = View.VISIBLE
        btnTryAgain.text = context.getString(R.string.try_again)
        tvErrorFeatureName.text = featureName
        ivErrorNoInternet.setImageResource(featureImage!!)
    }

    /**
     * Show the No Internet UI with portable wifi image and text
     * {Oh no! No Internet Connection or try again}
     */
    fun showSweetNoInternetUI(featureLayoutUI: View, sweetErrorLayoutUI: View) {
        featureLayoutUI.visibility = View.GONE
        sweetErrorLayoutUI.visibility = View.VISIBLE
        llEmptyUI.visibility = View.GONE
        llCustomUI.visibility = View.GONE
        llError.visibility = View.GONE
        llErrorToLoad.visibility = View.VISIBLE
        llNoInternet.visibility = View.VISIBLE
        btnTryAgain.text = context.getString(R.string.retry)
        ivErrorNoInternet.setImageResource(R.drawable.ic_portable_wifi_off_black_24dp)
    }

    /**
     * Show the sweet custom error UI with feature name and sub feature name like
     * Feature name: {No Sweets found to taste}
     * SUb Feature name: {please come later again...}
     *
     * @param featureName    Feature Name
     * @param subFeatureName Sub Feature Name
     * @param featureImage   Feature Image
     */
    fun showSweetCustomErrorUI(featureName: String, subFeatureName: String,
                               featureImage: Int?, featureLayoutUI: View, sweetErrorLayoutUI: View) {
        featureLayoutUI.visibility = View.GONE
        sweetErrorLayoutUI.visibility = View.VISIBLE
        llErrorToLoad.visibility = View.GONE
        llEmptyUI.visibility = View.GONE
        llCustomUI.visibility = View.VISIBLE
        ivCustomFeatureImage.setImageResource(featureImage!!)
        tvCustomFeatureName.text = featureName
        tvCustomSubFeatureName.text = subFeatureName
    }

    /**
     * Show the sweet custom error UI with feature name and sub feature name like
     * Feature name: {No Sweets found to taste}
     *
     * @param featureName  Feature Name
     * @param featureImage Feature Image
     */
    fun showSweetCustomErrorUI(featureName: String, featureImage: Int?,
                               featureLayoutUI: View, sweetErrorLayoutUI: View) {
        featureLayoutUI.visibility = View.GONE
        sweetErrorLayoutUI.visibility = View.VISIBLE
        llErrorToLoad.visibility = View.GONE
        llEmptyUI.visibility = View.GONE
        llCustomUI.visibility = View.VISIBLE
        ivCustomFeatureImage.setImageResource(featureImage!!)
        tvCustomFeatureName.text = featureName
        tvCustomSubFeatureName.visibility = View.GONE
    }

    /**
     * Hide the Sweet Error layout and show feature layout UI
     *
     * @param featureLayoutUI    Feature Layout UI
     * @param sweetErrorLayoutUI Sweet Error Layout UI
     */
    fun hideSweetErrorLayoutUI(featureLayoutUI: View, sweetErrorLayoutUI: View) {
        featureLayoutUI.visibility = View.VISIBLE
        sweetErrorLayoutUI.visibility = View.GONE
    }

    private fun initializeUIComponent() {
        ivEmptyFeatureImage = view.findViewById(R.id.ivEmptyFeatureImage)
        tvFeatureName = view.findViewById(R.id.tvFeatureName)
        tvSubFeatureName = view.findViewById(R.id.tvSubFeatureName)
        llEmptyUI = view.findViewById(R.id.llEmptyUI)
        llErrorToLoad = view.findViewById(R.id.llErrorToLoad)
        llNoInternet = view.findViewById(R.id.llNoInternet)
        llError = view.findViewById(R.id.llError)
        btnTryAgain = view.findViewById(R.id.btnTryAgain)
        tvErrorFeatureName = view.findViewById(R.id.tvErrorFeatureName)
        ivErrorNoInternet = view.findViewById(R.id.ivErrorNoInternet)
        llCustomUI = view.findViewById(R.id.llCustomUI)
        ivCustomFeatureImage = view.findViewById(R.id.ivCustomFeatureImage)
        tvCustomFeatureName = view.findViewById(R.id.tvCustomFeatureName)
        tvCustomSubFeatureName = view.findViewById(R.id.tvCustomSubFeatureName)
    }
}
