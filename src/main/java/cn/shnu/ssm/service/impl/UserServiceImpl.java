package cn.shnu.ssm.service.impl;

import cn.shnu.ssm.dao.UserDao;
import cn.shnu.ssm.pojo.User;
import cn.shnu.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public List<User> findUser() throws Exception {

        List<User> users = userDao.selectByExample(null);

        return users;
    }
}
