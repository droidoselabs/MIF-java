package in.droidose.missionindiafit.login;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by rajatdhamija on 19/11/17.
 */

class LoginViaFirebase implements FirebaseLoginService {

    @Override
    public void loginViaFirebase(String email, String password, final LoginInteractor.OnFirebaseLogin firebaseLogin) {

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
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
}
