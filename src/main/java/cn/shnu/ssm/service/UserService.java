package cn.shnu.ssm.service;

import cn.shnu.ssm.pojo.User;

import java.util.List;

public interface UserService {

    List<User> findUser()throws Exception;


}
