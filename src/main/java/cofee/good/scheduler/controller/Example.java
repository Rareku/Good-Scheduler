package cofee.good.scheduler.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cofee.good.scheduler.service.UserService;

@RestController
public class Example {

	@Autowired
	UserService userService;
	
	@GetMapping("users")
	public String getUsers() {
		return "JeJ";
	}
	
	@GetMapping("usersDb")
	public String getUsersFromDb() throws SQLException {
		return userService.getUsers();
	}
}
