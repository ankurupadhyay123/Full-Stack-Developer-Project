package com.webproject.test.integration;

import com.webproject.backend.persistence.domain.backend.Role;
import com.webproject.backend.persistence.domain.backend.User;
import com.webproject.backend.persistence.domain.backend.UserRole;
import com.webproject.backend.service.UserService;
import com.webproject.enums.PlansEnum;
import com.webproject.enums.RolesEnum;
import com.webproject.utils.UserUtils;
import org.junit.rules.TestName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractServiceIntegrationTest {

    @Autowired
    protected UserService userService;

    protected User createUser(TestName testName) {
        String username = testName.getMethodName();
        String email = testName.getMethodName() + "@webproject.com";


        Set<UserRole> userRoles = new HashSet<>();
        User basicUser = UserUtils.createBasicUser(username, email);
        userRoles.add(new UserRole(basicUser, new Role(RolesEnum.BASIC)));

        return userService.createUser(basicUser, PlansEnum.BASIC, userRoles);
    }
}
