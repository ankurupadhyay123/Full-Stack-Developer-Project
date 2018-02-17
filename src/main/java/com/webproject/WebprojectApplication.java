package com.webproject;

import com.webproject.backend.persistence.domain.backend.Role;
import com.webproject.backend.persistence.domain.backend.User;
import com.webproject.backend.persistence.domain.backend.UserRole;
import com.webproject.backend.service.UserService;
import com.webproject.enums.PlansEnum;
import com.webproject.enums.RolesEnum;
import com.webproject.utils.UserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class WebprojectApplication implements CommandLineRunner{

	/** The application logger */
	private static final Logger LOG = LoggerFactory.getLogger(WebprojectApplication.class);

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(WebprojectApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

	    String username = "proUser";
	    String email = "proUser@webproject.com";

		User user = UserUtils.createBasicUser(username, email);
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, new Role(RolesEnum.BASIC)));
		LOG.debug("Creating user with username {}", user.getUsername());
		userService.createUser(user, PlansEnum.PRO, userRoles);
		LOG.info("User {} created", user.getUsername());
	}
}
