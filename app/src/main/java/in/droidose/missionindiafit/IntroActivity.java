package in.droidose.missionindiafit;

import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;

public class IntroActivity extends BaseActivity {
    private static final int INT_START = 2;
    private AppCompatButton btnGetStarted;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        init();
        listeners();
    }

    private void init() {
        btnGetStarted = (AppCompatButton) findViewById(R.id.btnGetStarted);
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        SpannableStringBuilder str = new SpannableStringBuilder(getString(R.string.already_have_an_account));
        str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), INT_START, str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvLogin.setText(str);
    }

    private void listeners() {
        tvLogin.setOnClickListener(this);
        btnGetStarted.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvLogin:
                break;
            case R.id.btnGetStarted:
                break;
            default:
                break;
        }
    }
}
