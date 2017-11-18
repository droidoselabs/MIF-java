package in.droidose.missionindiafit.login;

/**
 * Created by rajatdhamija on 18/11/17.
 */

interface FirebaseLoginService {
    void loginViaFirebase(String email, String password, LoginInteractor.OnFirebaseLogin firebaseLogin);
}
