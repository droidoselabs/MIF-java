package in.droidose.missionindiafit;

import android.app.Application;
import android.content.Context;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by rajatdhamija on 11/11/17.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;

    /**
     * @return instance of MyApplication
     */
    public static MyApplication getApplication() {
        return myApplication;
    }

    /**
     * Getter to access Singleton instance
     *
     * @return instance of MyApplication
     */
    public static Context getAppContext() {
        return getApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        Paper.init(this);
//        Foreground.init(this);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        // Setup singleton instance
        myApplication = this;
    }
}
