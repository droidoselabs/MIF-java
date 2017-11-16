package in.droidose.missionindiafit;

import android.os.Bundle;
import android.view.View;

public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
        }
    }
}
