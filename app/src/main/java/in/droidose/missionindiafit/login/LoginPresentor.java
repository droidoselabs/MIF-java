package in.droidose.missionindiafit.login;

/**
 * Created by rajatdhamija on 18/11/17.
 */

public interface LoginPresentor {
    /**
     * Validate Credentials
     *
     * @param email    email of user
     * @param password password of user
     */
    void validateCredentials(String email, String password);

    void onDestroyView();
}
