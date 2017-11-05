package therajanmaurya.opensource.sweeterror.sweeterror;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import therajanmaurya.opensource.sweeterror.R;

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

    public void showSweetErrorUI(SweetErrorType sweetErrorType, String featureName,
            @Nullable String subFeatureName, @Nullable Integer featureImage) {

        switch (sweetErrorType) {
            case EMPTY_UI:
                llEmptyUI.setVisibility(View.VISIBLE);
                ivEmptyFeatureImage.setImageResource(featureImage);
                tvFeatureName.setText(context.getString(R.string.empty_ui_message, featureName));
                tvSubFeatureName.setText(
                        context.getString(R.string.empty_ui_sub_message, subFeatureName));
                llErrorToLoad.setVisibility(View.GONE);
                break;
            case ERROR_UI:
                llEmptyUI.setVisibility(View.GONE);
                llNoInternet.setVisibility(View.GONE);
                llError.setVisibility(View.VISIBLE);
                llErrorToLoad.setVisibility(View.VISIBLE);
                btnTryAgain.setText(context.getString(R.string.try_again));
                tvErrorFeatureName.setText(featureName);
                ivErrorNoInternet.setImageResource(R.drawable.ic_cloud_off_black_24dp);
                break;
            case NO_INTERNET:
                llEmptyUI.setVisibility(View.GONE);
                llError.setVisibility(View.GONE);
                llNoInternet.setVisibility(View.VISIBLE);
                llErrorToLoad.setVisibility(View.VISIBLE);
                btnTryAgain.setText(context.getString(R.string.retry));
                ivErrorNoInternet.setImageResource(R.drawable.ic_portable_wifi_off_black_24dp);
                break;
            case CUSTOM:
                llErrorToLoad.setVisibility(View.GONE);
                llEmptyUI.setVisibility(View.GONE);
                llCustomUI.setVisibility(View.VISIBLE);
                ivCustomFeatureImage.setImageResource(featureImage);
                tvCustomFeatureName.setText(featureName);
                if (subFeatureName != null) {
                    tvCustomSubFeatureName.setText(subFeatureName);
                }
                break;
        }
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
