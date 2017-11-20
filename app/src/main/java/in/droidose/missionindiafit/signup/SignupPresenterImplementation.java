package in.droidose.missionindiafit.signup;

import in.droidose.missionindiafit.common.FirebaseProvider;

/**
 * Created by rajatdhamija on 20/11/17.
 */

public class SignupPresenterImplementation implements SignupContractor.Presentor, SignupInteractor.OnKeepGoingClickListener {
    private SignupInteractor signupInteractor;
    private SignupContractor.View signupVew;

    public SignupPresenterImplementation(SignupContractor.View signupVew) {
        this.signupVew = signupVew;
        this.signupInteractor = new SignupInteractorImplementation(new FirebaseProvider());
    }

    @Override
    public void onDestroyView() {
        signupVew = null;
    }

    @Override
    public void onNameError(String errorMessage) {
        if (signupVew != null) {
            signupVew.hideProgress();
            signupVew.setNameError(errorMessage);
        }
    }

    @Override
    public void onEmailError(String errorMessage) {
        if (signupVew != null) {
            signupVew.hideProgress();
            signupVew.setEmailError(errorMessage);
        }
    }

    @Override
    public void onPasswordError(String errorMessage) {
        if (signupVew != null) {
            signupVew.hideProgress();
            signupVew.setPasswordError(errorMessage);
        }
    }

    @Override
    public void onConfirmPasswordError(String errorMessage) {
        if (signupVew != null) {
            signupVew.hideProgress();
            signupVew.setConfirmPasswordError(errorMessage);
        }
    }

    @Override
    public void onSuccessSignup() {
        if (signupVew != null) {
            signupVew.hideProgress();
            signupVew.navigateToViewTwo();
        }
    }

    @Override
    public void onGenderSaved() {
        if (signupVew != null) {
            signupVew.navigateToViewThree();
        }
    }

    @Override
    public void onWeightAndHeightSaved() {
        if (signupVew != null) {
            signupVew.navigateToViewFour();
        }
    }

    @Override
    public void onBodyTypeSaved() {
        if (signupVew != null) {
            signupVew.navigateToViewFive();
        }
    }

    @Override
    public void onProfileSetupComplete() {
        if (signupVew != null) {
            signupVew.navigateToHome();
        }
    }

    @Override
    public void onFailure(String errorMessage) {
        if (signupVew != null) {
            signupVew.hideProgress();
            signupVew.showApiError(errorMessage);
        }
    }

    @Override
    public void validateCredentials(String name, String email, String password, String confirmPassword) {
        if (signupVew != null) {
            signupVew.showProgress();
        }
        signupInteractor.apiSignup(name, password, this);
    }

    @Override
    public void setGender(String gender) {
        signupInteractor.setGender(gender);
    }

    @Override
    public void setHeightAndWeight(String weight, String height) {
        signupInteractor.setWeightAndHeight(weight, height);
    }

    @Override
    public void setBodyType(String bodyType) {
        signupInteractor.setBodyType(bodyType);
    }
}
