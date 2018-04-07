package cn.shnu.ssm.controller;

import cn.shnu.ssm.pojo.Teacher;
import cn.shnu.ssm.pojo.User;
import cn.shnu.ssm.service.TeamService;
import cn.shnu.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author: Hanwen
 * @Date: 2018/4/7 上午8:50
 */
@Controller()
@RequestMapping("team")
public class TeamController {

    @Autowired
    private TeamService teamService;
    @Autowired
    private UserService userService;

    @RequestMapping("researhchTeam")
    public ModelAndView researhchTeam(HttpServletRequest request) {
         ModelAndView modelAndView = new ModelAndView();
         request.getSession().setAttribute("active", "team");
         List<Teacher> teacherList = teamService.findTeacher();

         List<User> users = userService.findAllUser();
         Map<String, List<User>> finishStudents = new HashMap<String, List<User>>();
         Map<String, List<User>> notFinishStudents = new HashMap<String, List<User>>();
         for(User user : users) {
             if(user.getIsFinish() == 1) {
                 List<User> tempList = finishStudents.get(user.getGrade());
                 addList(finishStudents, user, tempList);
             }else {
                 List<User> tempList = notFinishStudents.get(user.getGrade());
                 addList(notFinishStudents, user, tempList);
             }
         }
         modelAndView.addObject("finishStudents", finishStudents);
         modelAndView.addObject("notFinishStudents", notFinishStudents);
         modelAndView.addObject("teachers", teacherList);
         modelAndView.setViewName("team/team");
         return modelAndView;
    }

    private void addList(Map<String, List<User>> finishStudents, User user, List<User> tempList) {
        if(tempList == null) {
            tempList = new ArrayList<User>();
            tempList.add(user);
            finishStudents.put(user.getGrade(), tempList);
        }else {
            tempList.add(user);
        }
    }


}
