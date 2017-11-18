package in.droidose.missionindiafit.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.droidose.missionindiafit.BaseActivity;
import in.droidose.missionindiafit.IntroActivity;
import in.droidose.missionindiafit.R;

public class LoginActivity extends BaseActivity implements LoginView {
    private static final String TAG = LoginActivity.class.getSimpleName();
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.tvSignup)
    TextView tvSignup;
    @BindView(R.id.tvForgotPassword)
    TextView tvForgotPassword;
    @BindView(R.id.btnSignIn)
    AppCompatButton btnSignIn;
    private LoginPresentor mLoginPresentor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
        listeners();
    }

    /**
     * Login Activity initializations
     */
    private void init() {
        mLoginPresentor = new LoginPresenterImplementation(this);
    }

    /**
     * Login Activity Listeners
     */
    private void listeners() {
        btnSignIn.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.btnSignIn:
                mLoginPresentor.validateCredentials(etEmail.getText().toString().trim(), etPassword.getText().toString().trim());
                break;
            case R.id.tvForgotPassword:
                break;
            case R.id.tvSignup:
                break;
            default:
                break;
        }
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
    public void setEmailError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showApiError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, IntroActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresentor.onDestroyView();
    }
}
