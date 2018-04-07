package cn.shnu.ssm.service;

import cn.shnu.ssm.pojo.Teacher;
import cn.shnu.ssm.pojo.User;

import java.util.List;
/**
 * @Author: Hanwen
 * @Date: 2018/4/4 下午3:08
 */
public interface UserService {

    User findUser(String studentNo)throws Exception;
    void updateUser(User user);

    void updateUserInformation(User uuser);

    List<User> findAllUser();

    boolean findManager(String username, String pwd);

    List<Teacher> findAllTeacher();
}
