package cn.shnu.ssm.service.impl;

import cn.shnu.ssm.dao.TeamDao;
import cn.shnu.ssm.pojo.Teacher;
import cn.shnu.ssm.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Hanwen
 * @Date: 2018/4/7 上午10:01
 */
@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    private TeamDao teamDao;

    public List<Teacher> findTeacher() {
        return teamDao.findTeacher();
    }

}
