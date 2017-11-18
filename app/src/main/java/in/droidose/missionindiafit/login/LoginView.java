package in.droidose.missionindiafit.login;

/**
 * Created by rajatdhamija on 18/11/17.
 */

public interface LoginView {
    /**
     * Show Progress on login click
     */
    void showProgress();

    /**
     * Hide progress on login complete/failure
     */
    void hideProgress();

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
