package in.droidose.missionindiafit.login;

/**
 * Created by rajatdhamija on 18/11/17.
 */

interface LoginInteractor {
    interface OnLoginClickListener {

        /**
         * Email error
         */
        void onEmailError(String errorMessage);

        /**
         * Password error
         */
        void onPasswordError(String errorMessage);

        /**
         * Login Success
         */
        void onSuccess();

        /**
         * onFailure();
         */
        void onFailure(String errorMessage);
    }

    interface OnFirebaseLogin {
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
     * @param email              email of user
     * @param password           password of user
     * @param loginClickListener login listener for login click
     */
    void apiLogin(String email, String password, OnLoginClickListener loginClickListener);
}
