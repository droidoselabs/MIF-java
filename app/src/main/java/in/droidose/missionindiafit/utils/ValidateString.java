package in.droidose.missionindiafit.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.droidose.missionindiafit.constants.AppConstants;

/**
 * Created by rajatdhamija on 19/11/17.
 */

public class ValidateString implements AppConstants {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static Pattern pattern;
    private static Matcher matcher;

    public static String validateEmail(String email) {

        if (email == null || email.isEmpty()) {
            return ERROR_EMAIL_CANNOT_BE_EMPTY;
        } else {
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return null;
            } else {
                return ERROR_EMAIL_IS_NOT_VALID;
            }
        }
    }

    public static String validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return ERROR_PASSWORD_CANNOT_BE_EMPTY;
        } else if (password.length() < PASSWORD_MIN_LENGTH) {
            return ERROR_PASSWORD_CANNOT_BE_LESS_THAN_8_CHARACTERS;
        } else {
            return null;
        }
    }
}
