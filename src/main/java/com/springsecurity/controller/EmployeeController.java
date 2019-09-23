/**
 * 
 */
package com.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.model.Employee;
import com.springsecurity.service.UserService;

/**
 * @author santoshkumar_si
 * @date 28-Jul-2019
 */
@RestController
@RequestMapping("/users")
public class EmployeeController {

	public static final String SUCCESS = "success";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    
	@Autowired
    private UserService userService;

	//@Secured({ROLE_USER,ROLE_ADMIN})
    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<Employee> listUser(){
    	System.out.println("List Users");
        return userService.findAll();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User create(@RequestBody User user){
        return userService.save(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id){
        userService.delete(id);
        return "success";
    }
}
