package com.jr.veterinary_clinic.services.utils;

import java.util.regex.Pattern;

public class RegexUtil {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9_.-]+@[A-Za-z0-9.-]+\\.[a-z][a-z]+$"
    );

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

}
