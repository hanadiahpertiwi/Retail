package com.ERetail;

import com.ERetail.model.AppUsers;
import com.ERetail.model.Role;
import com.ERetail.service.AppUsersService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;

@EnableTransactionManagement
@SpringBootApplication
public class RetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner run(AppUsersService appUsersService) {
//
//		return args -> {
//
//			appUsersService.saveUsers(new AppUsers(null, "Fajar Satriatna", "fajar123", "fajar123", new ArrayList<>()));
//			appUsersService.saveUsers(new AppUsers(null, "James Arthur", "james123", "james123", new ArrayList<>()));
//			appUsersService.saveUsers(new AppUsers(null, "Harry Styles", "harry123", "harry123", new ArrayList<>()));
//			appUsersService.saveUsers(new AppUsers(null, "Dua Lipa", "dualipa123", "dualipa123", new ArrayList<>()));
//
//			appUsersService.saveRole(new Role(null, "ROLE_USER"));
//			appUsersService.saveRole(new Role(null, "ROLE_MANAGER"));
//			appUsersService.saveRole(new Role(null, "ROLE_ADMIN"));
//			appUsersService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//
//			appUsersService.addRoleToUser("fajar123", "ROLE_USER");
//			appUsersService.addRoleToUser("james123", "ROLE_MANAGER");
//			appUsersService.addRoleToUser("harry123", "ROLE_ADMIN");
//			appUsersService.addRoleToUser("dualipa123", "ROLE_SUPER_ADMIN");
//		};
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
