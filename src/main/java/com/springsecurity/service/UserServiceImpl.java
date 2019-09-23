/**
 * 
 */
package com.springsecurity.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.model.Employee;

/**
 * @author santoshkumar_si
 * @date 10-Sep-2019
 */
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService,UserService{

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(" IN loadUserByUserName ");
		// TODO Auto-generated method stub
		//Employee user = userDao.findByUsername(userId);
		Employee user = new Employee();
		/*if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}*/
		return new org.springframework.security.core.userdetails.User("Alex123", "$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu", getAuthority());
	}
	
	private List<SimpleGrantedAuthority> getAuthority() {
		System.out.println(" Going to get authority ");
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	@Override
	public List<Employee> findAll() {
		System.out.println("in Find All ");
		List<Employee> list = new ArrayList<>();
		Employee ee = new Employee();
		ee.setEmpId("1");
		ee.setEmpName("Santosh");
		list.add(ee);
		//userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.springsecurity.service.UserService#save(org.springframework.security.core.userdetails.User)
	 */
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.springsecurity.service.UserService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	

}
