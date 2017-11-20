package in.droidose.missionindiafit.login;

import in.droidose.missionindiafit.common.BasePresentor;
import in.droidose.missionindiafit.common.BaseView;

/**
 * Created by rajatdhamija on 19/11/17.
 */

public interface LoginContractor {
    interface View extends BaseView {
        /**
         * Set Email error if email is not valid
         */
        void setEmailError(String errorMessage);

        /**
         * Set password error if password is not valid
         */
        void setPasswordError(String errorMessage);

        /**
         * show api Error
         */
        void showApiError(String errorMessage);

        /**
         * Navigate user to homepage on login success
         */
        void navigateToHome();
    }

    interface Presentor extends BasePresentor {
        /**
         * Validate Credentials
         *
         * @param email    email of user
         * @param password password of user
         */
        void validateCredentials(String email, String password);

    }
}
