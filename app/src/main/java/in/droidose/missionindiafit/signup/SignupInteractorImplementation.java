package in.droidose.missionindiafit.signup;

import in.droidose.missionindiafit.common.IFirebaseProvider;

/**
 * Created by rajatdhamija on 20/11/17.
 */

public class SignupInteractorImplementation implements SignupInteractor {
    private IFirebaseProvider service;

    SignupInteractorImplementation(IFirebaseProvider service) {
        this.service = service;
    }

    @Override
    public void apiSignup(String email, String password, OnKeepGoingClickListener onKeepGoingClickListener) {

    }

    @Override
    public void setGender(String gender) {

    }

    @Override
    public void setWeightAndHeight(String weight, String height) {

    }

    @Override
    public void setBodyType(String bodyType) {

    }
}
