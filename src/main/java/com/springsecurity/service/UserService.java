/**
 * 
 */
package com.springsecurity.service;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import com.springsecurity.model.Employee;

/**
 * @author santoshkumar_si
 * @date 10-Sep-2019
 */
public interface UserService {

	/**
	 * @return
	 */
	List<Employee> findAll();

	/**
	 * @param user
	 * @return
	 */
	User save(User user);

	/**
	 * @param id
	 */
	void delete(Long id);

}
