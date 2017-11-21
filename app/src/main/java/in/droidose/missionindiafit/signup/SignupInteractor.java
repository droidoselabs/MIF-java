package in.droidose.missionindiafit.signup;

/**
 * Created by rajatdhamija on 20/11/17.
 */
public interface SignupInteractor {

    interface OnKeepGoingClickListener {
        void onNameError(String errorMessage);

        void onEmailError(String errorMessage);

        void onPasswordError(String errorMessage);

        void onConfirmPasswordError(String errorMessage);

        void onSuccessSignup();

        void onFailure(String errorMessage);
    }

    interface OnFirebaseSignup {
        void onSuccess();

        void onFailure(String errorMessage);
    }

    interface OnGenderLayoutListener {
        void onGenderSaved();
    }

    interface OnWeightAndHeightSwipeListener {
        void onWeightAndHeightSaved();
    }

    interface OnBodyTypeSwipeListener {
        void onBodyTypeSaved();
    }


    void apiSignup(String name,
                   String email,
                   String password,
                   String confirmPassword,
                   SignupInteractor.OnKeepGoingClickListener onKeepGoingClickListener);


    void setGender(String gender, SignupInteractor.OnGenderLayoutListener onGenderLayoutListener);


    void setWeightAndHeight(String weight,
                            String height,
                            SignupInteractor.OnWeightAndHeightSwipeListener onWeightAndHeightSwipeListener);

    void setBodyType(String bodyType, SignupInteractor.OnBodyTypeSwipeListener onBodyTypeSwipeListener);
}
