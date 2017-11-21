package in.droidose.missionindiafit.signup;

import in.droidose.missionindiafit.common.IFirebaseProvider;
import in.droidose.missionindiafit.login.LoginInteractor;
import in.droidose.missionindiafit.utils.ValidateString;

/**
 * Created by rajatdhamija on 20/11/17.
 */

public class SignupInteractorImplementation implements SignupInteractor {
    private static final String PASSWORD_MISSMATCH = "Password Mismatch !";
    private IFirebaseProvider service;

    SignupInteractorImplementation(IFirebaseProvider service) {
        this.service = service;
    }

    @Override
    public void apiSignup(String name,
                          String email,
                          String password,
                          String confirmPassword,
                          final OnKeepGoingClickListener onKeepGoingClickListener) {
        String emailValidateMessage = ValidateString.validateEmail(email);
        String passwordValidateMessage = ValidateString.validatePassword(password);
        String nameValidateMessage = ValidateString.validateName(name);
        if (nameValidateMessage != null) {
            onKeepGoingClickListener.onNameError(nameValidateMessage);
        } else if (emailValidateMessage != null) {
            onKeepGoingClickListener.onEmailError(emailValidateMessage);
        } else if (passwordValidateMessage != null) {
            onKeepGoingClickListener.onPasswordError(passwordValidateMessage);
        } else if (!password.equals(confirmPassword)) {
            onKeepGoingClickListener.onConfirmPasswordError(PASSWORD_MISSMATCH);
        } else {
            service.signupViaFirebase(name, email, password, confirmPassword, new OnFirebaseSignup() {
                @Override
                public void onSuccess() {
                    onKeepGoingClickListener.onSuccessSignup();
                }

                @Override
                public void onFailure(String errorMessage) {
                    onKeepGoingClickListener.onFailure(errorMessage);
                }
            });
        }
    }

    @Override
    public void setGender(String gender, OnGenderLayoutListener onGenderLayoutListener) {
        onGenderLayoutListener.onGenderSaved();
    }

    @Override
    public void setWeightAndHeight(String weight, String height, OnWeightAndHeightSwipeListener onWeightAndHeightSwipeListener) {
        onWeightAndHeightSwipeListener.onWeightAndHeightSaved();
    }

    @Override
    public void setBodyType(String bodyType, OnBodyTypeSwipeListener onBodyTypeSwipeListener) {
        onBodyTypeSwipeListener.onBodyTypeSaved();
    }
}
