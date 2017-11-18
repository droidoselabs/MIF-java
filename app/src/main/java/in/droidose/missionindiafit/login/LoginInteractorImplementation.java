package in.droidose.missionindiafit.login;

import in.droidose.missionindiafit.constants.AppConstants;
import in.droidose.missionindiafit.utils.ValidateString;

/**
 * Created by rajatdhamija on 18/11/17.
 */

class LoginInteractorImplementation implements LoginInteractor, AppConstants {
    private FirebaseLoginService service;

    LoginInteractorImplementation(FirebaseLoginService service) {
        this.service = service;
    }

    @Override
    public void apiLogin(String email, String password, final OnLoginClickListener loginClickListener) {

        String emailValidateMessage = ValidateString.validateEmail(email);
        String passwordValidateMessage = ValidateString.validatePassword(password);
        if (emailValidateMessage != null) {
            loginClickListener.onEmailError(emailValidateMessage);
        } else if (passwordValidateMessage != null) {
            loginClickListener.onPasswordError(passwordValidateMessage);
        } else {
            service.loginViaFirebase(email, password, new OnFirebaseLogin() {

                @Override
                public void onSuccess() {
                    loginClickListener.onSuccess();
                }

                @Override
                public void onFailure(String errorMessage) {
                    loginClickListener.onFailure(errorMessage);
                }
            });
        }
    }
}
