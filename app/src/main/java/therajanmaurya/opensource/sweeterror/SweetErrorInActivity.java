package therajanmaurya.opensource.sweeterror;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import therajanmaurya.opensource.sweeterror.base.SweetBaseActivity;
import therajanmaurya.opensource.sweeterror.sweeterror.SweetErrorType;
import therajanmaurya.opensource.sweeterror.utils.ConstantKeys;

/**
 * @author Rajan Maurya
 *         On 05/11/17.
 */
public class SweetErrorInActivity extends SweetBaseActivity {

    @BindView(R.id.ll_sweet)
    LinearLayout llSweet;

    @BindView(R.id.layout_error)
    View layoutError;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweet_error);
        ButterKnife.bind(this);
        initializeSweetUIErrorHandler(this, findViewById(android.R.id.content));

        SweetErrorType sweetErrorType = (SweetErrorType) getIntent()
                .getSerializableExtra(ConstantKeys.SWEET_ERROR_TYPE);

        llSweet.setVisibility(View.GONE);
        layoutError.setVisibility(View.VISIBLE);

        switch (sweetErrorType) {
            case EMPTY_UI:
                showSweetEmptyUI(getString(R.string.sweets), getString(R.string.sweets),
                        R.drawable.ic_adb_black_24dp);
                break;
            case ERROR_UI:
                showSweetErrorUI(getString(R.string.sweets));
                break;
            case NO_INTERNET:
                showSweetNoInternetUI();
                break;
            case CUSTOM:
                findViewById(R.id.fab_add_sweet).setVisibility(View.GONE);
                showCustomErrorUI(getString(R.string.no_sweets_found),
                        getString(R.string.come_later_again), R.drawable.ic_adb_black_24dp);
                break;
        }
    }

    @OnClick(R.id.fab_add_sweet)
    void addSweet() {
       Snackbar.make(findViewById(R.id.cl_sweet), "Adding Sweet :)",
               Snackbar.LENGTH_LONG).show();
    }

    @OnClick(R.id.btn_try_again)
    void retrySweet() {
        Snackbar.make(findViewById(R.id.cl_sweet), "Loading Sweet ...",
                Snackbar.LENGTH_LONG).show();
    }
}
