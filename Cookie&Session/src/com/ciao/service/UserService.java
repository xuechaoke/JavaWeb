package com.ciao.service;

import com.ciao.bean.User;
import com.ciao.dao.UserDao;

/**
 * Created by Administrator on 2018/7/8/008.
 */
public class UserService {
    UserDao userDao  = new UserDao();
    public User login(String userName,String passWord){
        return userDao.findUser(userName,passWord);
    }
}
