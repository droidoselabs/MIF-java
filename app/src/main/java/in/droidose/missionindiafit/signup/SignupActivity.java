package in.droidose.missionindiafit.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.AppCompatButton;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.liangfeizc.RubberIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.droidose.missionindiafit.BaseActivity;
import in.droidose.missionindiafit.HomeActivity;
import in.droidose.missionindiafit.R;

/**
 * Created by rajatdhamija on 20/11/17.
 */

public class SignupActivity extends BaseActivity implements SignupContractor.View, RubberIndicator.OnMoveListener {
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.etConfirmPassword)
    EditText etConfirmPassword;
    @BindView(R.id.btnKeepGoing)
    AppCompatButton btnKeepGoing;
    @BindView(R.id.viewOne)
    LinearLayout llOne;
    @BindView(R.id.viewTwo)
    LinearLayout llTwo;
    @BindView(R.id.viewThree)
    LinearLayout llThree;
    @BindView(R.id.viewFour)
    LinearLayout llFour;
    @BindView(R.id.viewFive)
    LinearLayout llFive;
    private SignupContractor.Presentor mSignupPresener;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private static final String KEY_INDICATOR_POSITION = "indicator_position";
    private static final String KEY_INDICATOR_ITEM_NUM = "indicator_item_num";
    private RubberIndicator mRubberIndicator;
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
        mSignupPresener = new SignupPresenterImplementation(this);
        btnKeepGoing.setOnClickListener(this);
        mDetector = new GestureDetectorCompat(this, new MyGestureListener());
        mRubberIndicator = (RubberIndicator) findViewById(R.id.rubber);
        if (savedInstanceState != null) {
            mRubberIndicator.setCount(savedInstanceState.getInt(KEY_INDICATOR_ITEM_NUM), savedInstanceState.getInt(KEY_INDICATOR_POSITION));
        } else {
            int indicatorItemNum = 5;
            mRubberIndicator.setCount(indicatorItemNum, 0);
        }
        mRubberIndicator.setOnMoveListener(this);
        updateFocusPosition();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_INDICATOR_POSITION, mRubberIndicator.getFocusPosition());
        outState.putInt(KEY_INDICATOR_ITEM_NUM, mRubberIndicator.getChildCount());
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public void moveToRight(View view) {
        mRubberIndicator.moveToRight();
    }

    public void moveToLeft(View view) {
        mRubberIndicator.moveToLeft();
    }

    @Override
    public void onMovedToLeft() {
        updateFocusPosition();
    }

    @Override
    public void onMovedToRight() {
        updateFocusPosition();
    }

    private void updateFocusPosition() {
        switch (mRubberIndicator.getFocusPosition()) {
            case 1:
                mSignupPresener.onGenderScreenSwiped("Male");
                break;
            case 2:
                mSignupPresener.onWeightAndHeightScreenSwiped("x", "y");
                break;
            case 3:
                mSignupPresener.onBodyTypeSwiped("Ectomorph");
                break;
            default:
                break;

        }
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                    return false;
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    moveToRight(null);
                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    moveToLeft(null);
                }
            } catch (Exception e) {
            }
            return false;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
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
    public void setNameError(String errorMessage) {
        showSnackBar(etName, errorMessage);
    }

    @Override
    public void setEmailError(String errorMessage) {
        showSnackBar(etEmail, errorMessage);
    }

    @Override
    public void setPasswordError(String errorMessage) {
        showSnackBar(etPassword, errorMessage);
    }

    @Override
    public void setConfirmPasswordError(String errorMessage) {
        showSnackBar(etConfirmPassword, errorMessage);
    }

    @Override
    public void showApiError(String errorMessage) {
        showSnackBar(btnKeepGoing, errorMessage);
    }

    @Override
    public void navigateToViewTwo() {
        llOne.setVisibility(View.GONE);
        llTwo.setVisibility(View.VISIBLE);
        llThree.setVisibility(View.GONE);
        llFour.setVisibility(View.GONE);
        llFive.setVisibility(View.GONE);
    }

    @Override
    public void navigateToViewThree() {
        llOne.setVisibility(View.GONE);
        llTwo.setVisibility(View.GONE);
        llThree.setVisibility(View.VISIBLE);
        llFour.setVisibility(View.GONE);
        llFive.setVisibility(View.GONE);
    }

    @Override
    public void navigateToViewFour() {
        llOne.setVisibility(View.GONE);
        llTwo.setVisibility(View.GONE);
        llThree.setVisibility(View.GONE);
        llFour.setVisibility(View.VISIBLE);
        llFive.setVisibility(View.GONE);
    }

    @Override
    public void navigateToViewFive() {
        llOne.setVisibility(View.GONE);
        llTwo.setVisibility(View.GONE);
        llThree.setVisibility(View.GONE);
        llFour.setVisibility(View.GONE);
        llFive.setVisibility(View.VISIBLE);
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.btnKeepGoing:
                mSignupPresener.validateCredentials(etName.getText().toString().trim(),
                        etEmail.getText().toString().trim(),
                        etPassword.getText().toString().trim(),
                        etConfirmPassword.getText().toString().trim());
                break;
            default:
                break;
        }
    }
}
