package in.droidose.missionindiafit.login;

import in.droidose.missionindiafit.common.FirebaseProvider;

/**
 * Created by rajatdhamija on 18/11/17.
 */
class LoginPresenterImplementation implements LoginContractor.Presentor, LoginInteractor.OnLoginClickListener {

    private LoginInteractor loginInterator;
    private LoginContractor.View loginView;

    /**
     * Instantiates a new Login presenter implementation.
     *
     * @param loginView the login view
     */
    LoginPresenterImplementation(LoginContractor.View loginView) {
        this.loginView = loginView;
        this.loginInterator = new LoginInteractorImplementation(new FirebaseProvider());
    }


    @Override
    public void onEmailError(String errorMessage) {
        if (loginView != null) {
            loginView.setEmailError(errorMessage);
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError(String errorMessage) {
        if (loginView != null) {
            loginView.setPasswordError(errorMessage);
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.navigateToHome();
        }

    }

    @Override
    public void onFailure(String errorMessage) {
        if (loginView != null) {
            loginView.hideProgress();
            loginView.showApiError(errorMessage);
        }
    }

    @Override
    public void validateCredentials(String email, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }
        loginInterator.apiLogin(email, password, this);
    }

    @Override
    public void onDestroyView() {
        loginView = null;
    }
}
