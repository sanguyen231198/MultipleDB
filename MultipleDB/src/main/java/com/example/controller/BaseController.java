package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity_mysql.UserMySQL;
import com.example.entity_postgres.UserPostgres;
import com.example.repository_mysql.UserMySQLRepository;
import com.example.repository_postgres.UserPostgresRepository;

@RestController
public class BaseController {
	@Autowired
	private UserMySQLRepository userMySQLRepository;
	@Autowired
	private UserPostgresRepository userPostgresRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		String message = "Hello Spring Boot + JSP";
		model.addAttribute("message", message);
		return "index";
	}
	@GetMapping("/listMySQL")
	List<UserMySQL> allMySQL() {
		return userMySQLRepository.listUsers();
	}


	@GetMapping("/listPostgres")
	List<UserPostgres> allPostgres() {
		return userPostgresRepository.listUsers();
	}
//
	@PutMapping(value = "/mysql/updateUser/{id}")
	public List<UserMySQL> updateMySQL(@PathVariable("id") Long id, @RequestBody UserMySQL userMySQL) {
		userMySQLRepository.update(id,userMySQL);
		return userMySQLRepository.listUsers() ;
	}
	@PutMapping(value = "/postgres/updateUser/{id}")
	public List<UserPostgres> updatePostgres(@PathVariable("id") Long id, @RequestBody UserPostgres userPostgres) {
		userPostgresRepository.update(id, userPostgres);
		return userPostgresRepository.listUsers() ;
	}
//	@GetMapping(value = "/list")
//	public String showList(Model model) {
//
//		List<UserMySQL> userMySQLs = userMySQLRepository.listUsers();
//
//		List<UserPostgres> userPostgres = userPostgresRepository.listUser();
//
//		model.addAttribute("userMySQLs", userMySQLs);
//		model.addAttribute("userPostgres", userPostgres);
//
//		return "success";
//	}

	
}
