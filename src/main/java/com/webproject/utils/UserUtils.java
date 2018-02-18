package com.webproject.utils;

import com.webproject.backend.persistence.domain.backend.User;
import com.webproject.web.controllers.ForgotMyPasswordController;

import javax.servlet.http.HttpServletRequest;

public class UserUtils {

    /**
     * Non instantiable
     */
    private UserUtils() {
        throw new AssertionError("Non instantiable");
    }

    /**
     * Creates a user with basic attributes set.
     * @param username The username
     * @param email The email
     * @return A user entity
     */
    public static User createBasicUser(String username, String email){
        User user = new User();
        user.setUsername(username);
        user.setPassword("secret");
        user.setEmail(email);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPhoneNumber("1234567890");
        user.setCountry("IN");
        user.setEnabled(true);
        user.setDescription("A basic User");
        user.setProfileImageUrl("https://openclipart.org/download/294182/Bearded-Man-Profile.svg");
        return user;
    }

    public static String createPasswordResetUrl(HttpServletRequest request, long userId, String token) {
        String passwordResetUrl =
                request.getScheme() +
                        "://" +
                        request.getServerName() +
                        ":" +
                        request.getServerPort() +
                        request.getContextPath() +
                        ForgotMyPasswordController.CHANGE_PASSWORD_PATH +
                        "?id=" +
                        userId +
                        "&token=" +
                        token;
        return passwordResetUrl;
    }
}
