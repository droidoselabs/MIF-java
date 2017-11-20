package in.droidose.missionindiafit.signup;

import in.droidose.missionindiafit.login.LoginInteractor;

/**
 * Created by rajatdhamija on 20/11/17.
 */
public interface SignupInteractor {
    /**
     * The interface On keep going click listener.
     */
    interface OnKeepGoingClickListener {
        /**
         * Name error
         *
         * @param errorMessage the error message
         */
        void onNameError(String errorMessage);

        /**
         * Email error
         *
         * @param errorMessage the error message
         */
        void onEmailError(String errorMessage);

        /**
         * Password error
         *
         * @param errorMessage the error message
         */
        void onPasswordError(String errorMessage);

        /**
         * Confirm Password error
         *
         * @param errorMessage the error message
         */
        void onConfirmPasswordError(String errorMessage);

        /**
         * Signup Success
         */
        void onSuccessSignup();

        /**
         * On gender saved.
         */
        void onGenderSaved();

        /**
         * On weight and height saved.
         */
        void onWeightAndHeightSaved();

        /**
         * On body type saved.
         */
        void onBodyTypeSaved();

        /**
         * On profile setup complete.
         */
        void onProfileSetupComplete();

        /**
         * onFailure();
         *
         * @param errorMessage the error message
         */
        void onFailure(String errorMessage);
    }
    interface OnFirebaseSignup {
        /**
         * Login Success
         */
        void onSuccess();

        /**
         * onFailure();
         */
        void onFailure(String errorMessage);
    }
    /**
     * Login APi Hit
     *
     * @param email                    email of user
     * @param password                 password of user
     * @param onKeepGoingClickListener login listener for login click
     */
    void apiSignup(String email, String password, SignupInteractor.OnKeepGoingClickListener onKeepGoingClickListener);

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    void setGender(String gender);

    /**
     * Sets weight and height.
     *
     * @param weight the weight
     * @param height the height
     */
    void setWeightAndHeight(String weight, String height);

    /**
     * Sets body type.
     *
     * @param bodyType the body type
     */
    void setBodyType(String bodyType);
}
