/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.UserService;

@Service
public class UserServiceImpl  extends BaseServiceImpl implements UserService {

	@Override
	public boolean isExist(String name) {

		List l = list("name",name);
		if(!l.isEmpty())
			return true;
		return false;
	}

	@Override
	public User get(String name, String password) {
		List<User> l  = list("name",name, "password",password);
		if(l.isEmpty())
			return null;
		return l.get(0);

	}



	
}

/**
* 模仿天猫整站ssh 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
