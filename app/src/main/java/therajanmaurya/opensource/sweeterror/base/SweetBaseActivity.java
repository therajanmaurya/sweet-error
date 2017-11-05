package therajanmaurya.opensource.sweeterror.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import therajanmaurya.opensource.sweeterror.sweeterror.SweetErrorType;
import therajanmaurya.opensource.sweeterror.sweeterror.SweetUIErrorHandler;

/**
 * @author Rajan Maurya
 *         On 04/11/17.
 */
@SuppressLint("Registered")
public class SweetBaseActivity extends AppCompatActivity {

    private SweetUIErrorHandler sweetUIErrorHandler;

    public void initializeSweetUIErrorHandler(Context context, View view) {
        sweetUIErrorHandler = new SweetUIErrorHandler(context, view);
    }

    public void showSweetEmptyUI(@NonNull String featureName, @Nullable String subFeatureName,
            @NonNull Integer featureImage) {
        sweetUIErrorHandler.showSweetErrorUI(SweetErrorType.EMPTY_UI, featureName,
                subFeatureName, featureImage);
    }

    public void showSweetErrorUI(@NonNull String featureName) {
        sweetUIErrorHandler.showSweetErrorUI(SweetErrorType.ERROR_UI, featureName, null,
                null);
    }

    public void showSweetNoInternetUI() {
        sweetUIErrorHandler.showSweetErrorUI(SweetErrorType.NO_INTERNET, null, null,
                null);
    }

    public void showCustomErrorUI(@NonNull String featureName, @Nullable String subFeatureName,
            @NonNull Integer featureImage) {
        sweetUIErrorHandler.showSweetErrorUI(SweetErrorType.CUSTOM, featureName,
                subFeatureName, featureImage);
    }
}
