package com.webproject.utils;

import com.webproject.backend.persistence.domain.backend.User;

public class UsersUtils {

    /**
     * Non instantiable
     */
    private UsersUtils() {
        throw new AssertionError("Non instantiable");
    }

    /**
     * Creates a user with basic attributes set.
     * @return A user entity
     */
    public static User createBasicUser(){
        User user = new User();
        user.setUsername("basicUser");
        user.setPassword("secret");
        user.setEmail("me@example.com");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPhoneNumber("1234567890");
        user.setCountry("IN");
        user.setEnabled(true);
        user.setDescription("A basic User");
        user.setProfileImageUrl("https://openclipart.org/download/294182/Bearded-Man-Profile.svg");
        return user;
    }
}
