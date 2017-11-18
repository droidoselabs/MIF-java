package in.droidose.missionindiafit;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.tvSignup)
    TextView tvSignup;
    @BindView(R.id.tvForgotPassword)
    TextView tvForgotPassword;
    @BindView(R.id.btnSignIn)
    EditText btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        listeners();
    }

    private void listeners() {
        tvSignup.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.tvSignup:
                break;
            case R.id.tvForgotPassword:
                break;
            case R.id.btnSignIn:
                break;
            default:
                break;
        }
    }
}
