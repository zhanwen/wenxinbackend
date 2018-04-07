package cn.shnu.ssm.dao;

import cn.shnu.ssm.pojo.Teacher;
import cn.shnu.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Author: Hanwen
 * @Date: 2018/4/5 下午3:08
 */
public interface UserDao {

    User selectByStudentNo(@Param("studentNo") String studentNo);

    void updataUser(User user);

    void updateUserInformation(User uuser);

    List<User> findAllUser();

    User findManager(User user);

    List<Teacher> findAllTeacher();

    void updateTeacher(Teacher teacher);

    void deleteTeacher(int id);

    void addTeacher(Teacher teacher);

    Teacher findTeacher(int teacherId);
}