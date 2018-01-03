package com.rockey.ssm.service;

import com.rockey.ssm.po.User;

public interface UserService {

	/**
	 * @param user User
	 * @return User
	 * @throws Exception
	 */
	User findUserByNameAndPwd(User user) throws Exception;
	/**
	 * add new User
	 * @param user User
	 * @throws Exception
	 */
	void addUser(User user) throws Exception;
	/**
	 * delete User
	 * @param id String
	 * @throws Exception
	 */
	void deleteUser(Integer id) throws Exception;
}
