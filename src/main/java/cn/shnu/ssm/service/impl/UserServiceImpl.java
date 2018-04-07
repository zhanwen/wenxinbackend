package cn.shnu.ssm.service.impl;

import cn.shnu.ssm.dao.UserDao;
import cn.shnu.ssm.pojo.Teacher;
import cn.shnu.ssm.pojo.User;
import cn.shnu.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Author: Hanwen
 * @Date: 2018/4/4 下午4:08
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User findUser(String studentNo) throws Exception {
        User users = userDao.selectByStudentNo(studentNo);
        return users;
    }

    public void updateUser(User user) {
        userDao.updataUser(user);
    }

    public void updateUserInformation(User uuser) {
        userDao.updateUserInformation(uuser);
    }

    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    public boolean findManager(String username, String pwd) {
        User user = new User();
        user.setStudentNo(username);
        user.setPassword(pwd);
        User user2 = userDao.findManager(user);
        return user2 != null ? true : false;
    }

    public List<Teacher> findAllTeacher() {
        return userDao.findAllTeacher();
    }

    public void updateTeacher(Teacher teacher) {
        userDao.updateTeacher(teacher);
    }

    public void deleteTeacher(Integer id) {
        userDao.deleteTeacher(id);
    }

    public void addTeacher(Teacher teacher) {
        userDao.addTeacher(teacher);
    }

    public Teacher findTeacher(int teacherId) {
        return userDao.findTeacher(teacherId);

    }
}
