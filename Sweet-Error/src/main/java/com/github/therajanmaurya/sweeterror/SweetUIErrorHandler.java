package com.github.therajanmaurya.sweeterror;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Rajan Maurya
 *         On 04/11/17.
 */
public class SweetUIErrorHandler {

    private ImageView ivEmptyFeatureImage;
    private ImageView ivErrorNoInternet;
    private ImageView ivCustomFeatureImage;

    private TextView tvFeatureName;
    private TextView tvSubFeatureName;
    private TextView tvErrorFeatureName;
    private TextView tvCustomFeatureName;
    private TextView tvCustomSubFeatureName;

    private LinearLayout llEmptyUI;
    private LinearLayout llErrorToLoad;
    private LinearLayout llNoInternet;
    private LinearLayout llError;
    private LinearLayout llCustomUI;

    private Button btnTryAgain;

    private Context context;
    private View view;

    public SweetUIErrorHandler(Context context, View view) {
        this.context = context;
        this.view = view;
        initializeUIComponent();
    }

    /**
     * Show the Empty UI with Feature image and feature name and sub feature name.
     *
     * @param featureName    Feature Name
     * @param subFeatureName Sub Feature Name
     * @param featureImage   Feature Image that you wanna show
     */
    public void showSweetEmptyUI(String featureName, String subFeatureName, Integer featureImage,
            View featureLayoutUI, View sweetErrorLayoutUI) {
        featureLayoutUI.setVisibility(View.GONE);
        sweetErrorLayoutUI.setVisibility(View.VISIBLE);
        llErrorToLoad.setVisibility(View.GONE);
        llCustomUI.setVisibility(View.GONE);
        llEmptyUI.setVisibility(View.VISIBLE);
        ivEmptyFeatureImage.setImageResource(featureImage);
        tvFeatureName.setText(context.getString(R.string.empty_ui_message, featureName));
        tvSubFeatureName.setText(context.getString(R.string.empty_ui_sub_message, subFeatureName));
    }

    /**
     * Show the Empty UI with Feature image and feature name. It will hide the sub feature name from
     * bottom of feature name and only show two things feature image and name.
     *
     * @param featureName  Feature Name
     * @param featureImage Sub Feature Name
     */
    public void showSweetEmptyUI(String featureName, Integer featureImage, View featureLayoutUI,
            View sweetErrorLayoutUI) {
        featureLayoutUI.setVisibility(View.GONE);
        sweetErrorLayoutUI.setVisibility(View.VISIBLE);
        llErrorToLoad.setVisibility(View.GONE);
        llCustomUI.setVisibility(View.GONE);
        llEmptyUI.setVisibility(View.VISIBLE);
        ivEmptyFeatureImage.setImageResource(featureImage);
        tvFeatureName.setText(context.getString(R.string.empty_ui_message, featureName));
        tvSubFeatureName.setVisibility(View.GONE);
    }

    /**
     * Show the Error UI with the No Network Image and with text
     * "Sorry we weren't able to load {Feature Name}" and with button {Try Again}.
     *
     * @param featureName Feature Name
     */
    public void showSweetErrorUI(String featureName, View featureLayoutUI,
            View sweetErrorLayoutUI) {
        featureLayoutUI.setVisibility(View.GONE);
        sweetErrorLayoutUI.setVisibility(View.VISIBLE);
        llEmptyUI.setVisibility(View.GONE);
        llCustomUI.setVisibility(View.GONE);
        llNoInternet.setVisibility(View.GONE);
        llErrorToLoad.setVisibility(View.VISIBLE);
        llError.setVisibility(View.VISIBLE);
        btnTryAgain.setText(context.getString(R.string.try_again));
        tvErrorFeatureName.setText(featureName);
        ivErrorNoInternet.setImageResource(R.drawable.ic_cloud_off_black_24dp);
    }

    /**
     * Show the text "Sorry we weren't able to load {Feature Name}" and
     * with button {Try Again} and can update the No Network Image and with
     * the any feature image you will pass.
     *
     * @param featureName  Feature Name
     * @param featureImage Feature Image
     */
    public void showSweetErrorUI(String featureName, Integer featureImage, View featureLayoutUI,
            View sweetErrorLayoutUI) {
        featureLayoutUI.setVisibility(View.GONE);
        sweetErrorLayoutUI.setVisibility(View.VISIBLE);
        llEmptyUI.setVisibility(View.GONE);
        llCustomUI.setVisibility(View.GONE);
        llNoInternet.setVisibility(View.GONE);
        llErrorToLoad.setVisibility(View.VISIBLE);
        llError.setVisibility(View.VISIBLE);
        btnTryAgain.setText(context.getString(R.string.try_again));
        tvErrorFeatureName.setText(featureName);
        ivErrorNoInternet.setImageResource(featureImage);
    }

    /**
     * Show the No Internet UI with portable wifi image and text
     * {Oh no! No Internet Connection or try again}
     */
    public void showSweetNoInternetUI(View featureLayoutUI, View sweetErrorLayoutUI) {
        featureLayoutUI.setVisibility(View.GONE);
        sweetErrorLayoutUI.setVisibility(View.VISIBLE);
        llEmptyUI.setVisibility(View.GONE);
        llCustomUI.setVisibility(View.GONE);
        llError.setVisibility(View.GONE);
        llErrorToLoad.setVisibility(View.VISIBLE);
        llNoInternet.setVisibility(View.VISIBLE);
        btnTryAgain.setText(context.getString(R.string.retry));
        ivErrorNoInternet.setImageResource(R.drawable.ic_portable_wifi_off_black_24dp);
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
    public void showSweetCustomErrorUI(String featureName, String subFeatureName,
            Integer featureImage, View featureLayoutUI, View sweetErrorLayoutUI) {
        featureLayoutUI.setVisibility(View.GONE);
        sweetErrorLayoutUI.setVisibility(View.VISIBLE);
        llErrorToLoad.setVisibility(View.GONE);
        llEmptyUI.setVisibility(View.GONE);
        llCustomUI.setVisibility(View.VISIBLE);
        ivCustomFeatureImage.setImageResource(featureImage);
        tvCustomFeatureName.setText(featureName);
        tvCustomSubFeatureName.setText(subFeatureName);
    }

    /**
     * Show the sweet custom error UI with feature name and sub feature name like
     * Feature name: {No Sweets found to taste}
     *
     * @param featureName  Feature Name
     * @param featureImage Feature Image
     */
    public void showSweetCustomErrorUI(String featureName, Integer featureImage,
            View featureLayoutUI, View sweetErrorLayoutUI) {
        featureLayoutUI.setVisibility(View.GONE);
        sweetErrorLayoutUI.setVisibility(View.VISIBLE);
        llErrorToLoad.setVisibility(View.GONE);
        llEmptyUI.setVisibility(View.GONE);
        llCustomUI.setVisibility(View.VISIBLE);
        ivCustomFeatureImage.setImageResource(featureImage);
        tvCustomFeatureName.setText(featureName);
        tvCustomSubFeatureName.setVisibility(View.GONE);
    }

    /**
     * Hide the Sweet Error layout and show feature layout UI
     *
     * @param featureLayoutUI    Feature Layout UI
     * @param sweetErrorLayoutUI Sweet Error Layout UI
     */
    public void hideSweetErrorLayoutUI(View featureLayoutUI, View sweetErrorLayoutUI) {
        featureLayoutUI.setVisibility(View.VISIBLE);
        sweetErrorLayoutUI.setVisibility(View.GONE);
    }

    private void initializeUIComponent() {
        ivEmptyFeatureImage = view.findViewById(R.id.iv_empty_feature_image);
        tvFeatureName = view.findViewById(R.id.tv_empty_feature_name);
        tvSubFeatureName = view.findViewById(R.id.tv_empty_sub_feature_name);
        llEmptyUI = view.findViewById(R.id.ll_empty_ui);
        llErrorToLoad = view.findViewById(R.id.ll_error_to_load);
        llNoInternet = view.findViewById(R.id.ll_no_internet);
        llError = view.findViewById(R.id.ll_error);
        btnTryAgain = view.findViewById(R.id.btn_try_again);
        tvErrorFeatureName = view.findViewById(R.id.tv_error_feature_name);
        ivErrorNoInternet = view.findViewById(R.id.iv_error_no_connection);
        llCustomUI = view.findViewById(R.id.ll_custom_ui);
        ivCustomFeatureImage = view.findViewById(R.id.iv_custom_feature_image);
        tvCustomFeatureName = view.findViewById(R.id.tv_custom_feature_name);
        tvCustomSubFeatureName = view.findViewById(R.id.tv_custom_sub_feature_name);
    }
}
