package in.droidose.missionindiafit.common;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import in.droidose.missionindiafit.login.LoginInteractor;
import in.droidose.missionindiafit.signup.SignupInteractor;

/**
 * Created by rajatdhamija on 19/11/17.
 */

public class FirebaseProvider implements IFirebaseProvider {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    public void loginViaFirebase(String email,
                                 String password,
                                 final LoginInteractor.OnFirebaseLogin firebaseLogin) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            firebaseLogin.onSuccess();
                        } else {
                            firebaseLogin.onFailure(task.getException().getMessage());
                        }
                    }
                });
    }

    @Override
    public void signupViaFirebase(String name,
                                  String email,
                                  String password,
                                  String confirmPassword,
                                  final SignupInteractor.OnFirebaseSignup firebaseSignup) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            firebaseSignup.onSuccess();
                        } else {
                            firebaseSignup.onFailure(task.getException().getMessage());
                        }
                    }
                });
    }
}
