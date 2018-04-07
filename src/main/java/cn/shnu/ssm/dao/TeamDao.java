package cn.shnu.ssm.dao;

import cn.shnu.ssm.pojo.Teacher;

import java.util.List;

/**
 * @Author: Hanwen
 * @Date: 2018/4/7 上午10:02
 */
public interface TeamDao {
    List<Teacher> findTeacher();
}
