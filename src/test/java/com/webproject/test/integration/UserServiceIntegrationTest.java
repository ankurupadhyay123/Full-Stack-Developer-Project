package com.webproject.test.integration;

import com.webproject.WebprojectApplication;
import com.webproject.backend.persistence.domain.backend.Role;
import com.webproject.backend.persistence.domain.backend.User;
import com.webproject.backend.persistence.domain.backend.UserRole;
import com.webproject.backend.service.UserService;
import com.webproject.enums.PlansEnum;
import com.webproject.enums.RolesEnum;
import com.webproject.utils.UserUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebprojectApplication.class)
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Rule
    public TestName testName = new TestName();

    @Test
    public void testCreateNewUser() throws Exception {

        String username = testName.getMethodName();
        String email = testName.getMethodName() + "@webproject.com";


        Set<UserRole> userRoles = new HashSet<>();
        User basicUser = UserUtils.createBasicUser(username, email);
        userRoles.add(new UserRole(basicUser, new Role(RolesEnum.BASIC)));

        User user = userService.createUser(basicUser, PlansEnum.BASIC, userRoles);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
    }
}
