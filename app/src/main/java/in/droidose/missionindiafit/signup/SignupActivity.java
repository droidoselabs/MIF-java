package in.droidose.missionindiafit.signup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import in.droidose.missionindiafit.BaseActivity;
import in.droidose.missionindiafit.R;

/**
 * Created by rajatdhamija on 20/11/17.
 */

public class SignupActivity extends BaseActivity implements SignupContractor.View {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        View.inflate(this, R.layout.signup_view_one, (ViewGroup) findViewById(R.id.llLayoutInflater));
    }

    @Override
    public void showProgress() {
        showProgressDialog(this, getString(R.string.loading));
    }

    @Override
    public void hideProgress() {
        dismissProgressDialog();
    }

    @Override
    public void setNameError(String errorMessage) {

    }

    @Override
    public void setEmailError(String errorMessage) {

    }

    @Override
    public void setPasswordError(String errorMessage) {

    }

    @Override
    public void setConfirmPasswordError(String errorMessage) {

    }

    @Override
    public void showApiError(String errorMessage) {

    }

    @Override
    public void navigateToViewTwo() {

    }

    @Override
    public void navigateToViewThree() {

    }

    @Override
    public void navigateToViewFour() {

    }

    @Override
    public void navigateToViewFive() {

    }

    @Override
    public void navigateToHome() {

    }
}
