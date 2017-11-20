package in.droidose.missionindiafit;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.liangfeizc.RubberIndicator;

public class HomeActivity extends BaseActivity implements RubberIndicator.OnMoveListener {

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private static final String KEY_INDICATOR_POSITION = "indicator_position";
    private static final String KEY_INDICATOR_ITEM_NUM = "indicator_item_num";
    private RubberIndicator mRubberIndicator;
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
}