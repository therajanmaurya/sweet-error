package com.github.therajanmaurya.sweeterror.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.github.therajanmaurya.sweeterror.SweetUIErrorHandler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @author Rajan Maurya
 *         On 05/11/17.
 */
public class SweetErrorInActivity extends AppCompatActivity {

    @BindView(R.id.ll_sweet)
    LinearLayout llSweet;

    @BindView(R.id.layout_error)
    View layoutError;

    private SweetUIErrorHandler sweetUIErrorHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweet_error);
        ButterKnife.bind(this);

        sweetUIErrorHandler = new SweetUIErrorHandler(this, findViewById(android.R.id.content));

        SweetErrorType sweetErrorType = (SweetErrorType) getIntent()
                .getSerializableExtra(ConstantKeys.SWEET_ERROR_TYPE);

        switch (sweetErrorType) {
            case EMPTY_UI:
                sweetUIErrorHandler.showSweetEmptyUI(getString(R.string.sweets),
                        getString(R.string.sweet), R.drawable.ic_adb_black_24dp,
                        llSweet, layoutError);
                break;
            case ERROR_UI:
                sweetUIErrorHandler.showSweetErrorUI(getString(R.string.sweets), llSweet,
                        layoutError);
                break;
            case NO_INTERNET:
                sweetUIErrorHandler.showSweetNoInternetUI(llSweet, layoutError);
                break;
            case CUSTOM:
                findViewById(R.id.fab_add_sweet).setVisibility(View.GONE);
                sweetUIErrorHandler.showSweetCustomErrorUI(getString(R.string.no_sweets_found),
                        getString(R.string.come_later_again), R.drawable.ic_adb_black_24dp,
                        llSweet, layoutError);
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
