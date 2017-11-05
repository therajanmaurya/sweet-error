package therajanmaurya.opensource.sweeterror;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import therajanmaurya.opensource.sweeterror.sweeterror.SweetErrorType;
import therajanmaurya.opensource.sweeterror.utils.ConstantKeys;

public class SweetMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_empty_ui)
    void showEmptyUI() {
        sweetIntent(SweetErrorType.EMPTY_UI);
    }

    @OnClick(R.id.btn_error_ui)
    void showErrorUI() {
        sweetIntent(SweetErrorType.ERROR_UI);
    }

    @OnClick(R.id.btn_no_internet_ui)
    void showNoInternetUI() {
        sweetIntent(SweetErrorType.NO_INTERNET);
    }

    @OnClick(R.id.btn_custom_error_ui)
    void showCustomErrorUI() {
        sweetIntent(SweetErrorType.CUSTOM);
    }

    public void sweetIntent(SweetErrorType sweetErrorType) {
        Intent sweetIntent = new Intent(this, SweetErrorInActivity.class);
        sweetIntent.putExtra(ConstantKeys.SWEET_ERROR_TYPE, sweetErrorType);
        startActivity(sweetIntent);
    }
}
