package cn.shnu.ssm.dao;

import cn.shnu.ssm.pojo.User;

import java.util.List;

public interface UserDao {

    List<User> selectByExample(User user);

}