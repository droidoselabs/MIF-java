package in.droidose.missionindiafit;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import in.droidose.missionindiafit.constants.AppConstants;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by rajatdhamija on 11/11/17.
 */

public class BaseActivity extends AppCompatActivity implements View.OnClickListener,AppConstants {
    private static final float DIM_AMOUNT = 0.6f;
    private Dialog progressDialog;
    private TextView tvProgress;
    private TextView innerProgress;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void attachBaseContext(final Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onClick(View view) {

    }

    /**
     * Show Progress dialog on api hits
     *
     * @param context context of activity
     * @param message message to be displayed
     */
    public void showProgressDialog(final Context context, final String message) {

        try {
            /* Check if the last instance is alive */
            if (progressDialog != null) {
                if (progressDialog.isShowing()) {
                    tvProgress.setText(message);
                    return;
                }
            }

            /*  Ends Here   */

            progressDialog = new Dialog(context,
                    android.R.style.Theme_Translucent_NoTitleBar);

            progressDialog.setContentView(R.layout.dialog_progress);

            tvProgress = progressDialog
                    .findViewById(R.id.tvProgress);
            innerProgress = progressDialog
                    .findViewById(R.id.progress);
            tvProgress.setText(message);
            innerProgress.setText("");

            progressDialog.findViewById(R.id.progress_wheel);
            Window dialogWindow = progressDialog.getWindow();
            WindowManager.LayoutParams layoutParams = null;
            if (dialogWindow != null) {
                layoutParams = dialogWindow
                        .getAttributes();
            }
            assert layoutParams != null;
            layoutParams.dimAmount = DIM_AMOUNT;
            dialogWindow.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);

            progressDialog.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Dismisses the Progress Dialog
     *
     * @return the boolean
     */
    public boolean dismissProgressDialog() {
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {

                try {
                    progressDialog.dismiss();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                progressDialog = null;
                tvProgress = null;
                innerProgress = null;
                return true;
            }
        }

        return false;
    }
}
