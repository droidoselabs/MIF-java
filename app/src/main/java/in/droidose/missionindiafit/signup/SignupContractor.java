package in.droidose.missionindiafit.signup;

import in.droidose.missionindiafit.common.BasePresentor;
import in.droidose.missionindiafit.common.BaseView;

/**
 * Created by rajatdhamija on 20/11/17.
 */
public interface SignupContractor {
    /**
     * The interface View.
     */
    interface View extends BaseView {

        /**
         * Set Name error if name is not valid
         *
         * @param errorMessage the error message
         */
        void setNameError(String errorMessage);

        /**
         * Set Email error if email is not valid
         *
         * @param errorMessage the error message
         */
        void setEmailError(String errorMessage);

        /**
         * Set password error if password is not valid
         *
         * @param errorMessage the error message
         */
        void setPasswordError(String errorMessage);

        /**
         * Set Confirm Password error if confirm pass does not match password || Not valid
         *
         * @param errorMessage the error message
         */
        void setConfirmPasswordError(String errorMessage);

        /**
         * show api Error
         *
         * @param errorMessage the error message
         */
        void showApiError(String errorMessage);

        /**
         * Navigate user to view two
         */
        void navigateToViewTwo();

        /**
         * Navigate user to view three
         */
        void navigateToViewThree();

        /**
         * Navigate user to view four
         */
        void navigateToViewFour();

        /**
         * Navigate user to view five
         */
        void navigateToViewFive();

        /**
         * Navigate user to homepage on login success
         */
        void navigateToHome();
    }

    /**
     * The interface Presentor.
     */
    interface Presentor extends BasePresentor {
        /**
         * Validate Credentials
         *
         * @param name            name of user
         * @param email           email of user
         * @param password        password of user
         * @param confirmPassword password confirmation
         */
        void validateCredentials(String name, String email, String password, String confirmPassword);

        /**
         * Sets gender.
         *
         * @param gender the gender
         */
        void setGender(String gender);

        /**
         * Sets height and weight.
         *
         * @param weight the weight
         * @param height the height
         */
        void setHeightAndWeight(String weight, String height);

        /**
         * Sets body type.
         *
         * @param bodyType the body type
         */
        void setBodyType(String bodyType);
    }
}
