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
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${webmaster.username}")
	private String webmasterUsername;

    @Value("${webmaster.password}")
	private String webmasterPassword;

    @Value("${webmaster.email}")
	private String webmasterEmail;

	public static void main(String[] args) {
		SpringApplication.run(WebprojectApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		User user = UserUtils.createBasicUser(webmasterUsername, webmasterEmail);
		user.setPassword(webmasterPassword);
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, new Role(RolesEnum.ADMIN)));
		LOG.debug("Creating user with username {}", user.getUsername());
		userService.createUser(user, PlansEnum.PRO, userRoles);
		LOG.info("User {} created", user.getUsername());
	}
}
