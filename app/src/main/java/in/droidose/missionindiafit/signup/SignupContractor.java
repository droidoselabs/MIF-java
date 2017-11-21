package in.droidose.missionindiafit.signup;

import in.droidose.missionindiafit.common.BasePresentor;
import in.droidose.missionindiafit.common.BaseView;

/**
 * Created by rajatdhamija on 20/11/17.
 */
interface SignupContractor {
    interface View extends BaseView {
        void setNameError(String errorMessage);

        void setEmailError(String errorMessage);

        void setPasswordError(String errorMessage);

        void setConfirmPasswordError(String errorMessage);

        void showApiError(String errorMessage);

        void navigateToViewTwo();

        void navigateToViewThree();

        void navigateToViewFour();

        void navigateToViewFive();

        void navigateToHome();
    }

    interface Presentor extends BasePresentor {

        void validateCredentials(String name, String email, String password, String confirmPassword);

        void onGenderScreenSwiped(String gender);

        void onWeightAndHeightScreenSwiped(String weight, String height);

        void onBodyTypeSwiped(String bodyType);
    }
}
