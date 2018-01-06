package main.java.com.rockey.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.rockey.ssm.mapper.UserMapper;
import com.rockey.ssm.po.User;
import com.rockey.ssm.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		int result = userMapper.insert(user);
		if(result<=0)
			throw new RuntimeException("插入失败");
		
	}

	public void deleteUser(Integer id) throws Exception {
		// TODO Auto-generated method stub
		int result = userMapper.deleteByPrimaryKey(id);
		if(result<=0)
			throw new RuntimeException("插入失败");
		
	}

	public User findUserByNameAndPwd(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.selectByNameAndPwd(user);
		
	}

}
