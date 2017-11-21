package in.droidose.missionindiafit.common;

import in.droidose.missionindiafit.login.LoginInteractor;
import in.droidose.missionindiafit.signup.SignupInteractor;

/**
 * Created by rajatdhamija on 18/11/17.
 */

public interface IFirebaseProvider {
    void loginViaFirebase(String email,
                          String password,
                          LoginInteractor.OnFirebaseLogin firebaseLogin);

    void signupViaFirebase(String name,
                           String email,
                           String password,
                           String confirmPassword,
                           SignupInteractor.OnFirebaseSignup firebaseSignup);
}
