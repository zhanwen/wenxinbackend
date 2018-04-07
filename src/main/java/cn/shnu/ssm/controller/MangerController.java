package cn.shnu.ssm.controller;

import cn.shnu.ssm.pojo.Teacher;
import cn.shnu.ssm.pojo.User;
import cn.shnu.ssm.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Hanwen
 * @Date: 2018/4/7 下午4:33
 */
@Controller
@RequestMapping("admin")
public class MangerController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/login");
        return modelAndView;
    }

    @RequestMapping("bWFuYWdlcjEyMw==")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/manager");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("manager")
    public String manager(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "");
        String username = request.getParameter("studentNo");
        String password = request.getParameter("pwd");
        boolean succ = userService.findManager(username, password);
        if(succ){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            request.getSession().setAttribute("admin", user);
            jsonObject.put("result", "admin");
            return jsonObject.toString();
        }
        return jsonObject.toString();
    }

    @RequestMapping("logout")
    public ModelAndView logout(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        // 设置session为空
        request.getSession().setAttribute("admin", null);
        // 页面跳转
        modelAndView.setViewName("/admin/login");
        return modelAndView;
    }

    @RequestMapping("teacher")
    public ModelAndView teacher(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        if(request.getSession().getAttribute("admin") == null) {
            modelAndView.setViewName("/admin/login");
        }else {
            List<Teacher> teacherList = userService.findAllTeacher();
            request.getSession().setAttribute("active", "teacher");
            modelAndView.addObject("teacherList", teacherList);
            modelAndView.setViewName("/admin/teacher");
        }
        return modelAndView;
    }

    @RequestMapping("students")
    public ModelAndView students(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        if(request.getSession().getAttribute("admin") == null) {
            modelAndView.setViewName("/admin/login");
        }else {
            List<User> userList = userService.findAllUser();
            request.getSession().setAttribute("active", "student");
            modelAndView.addObject("userList", userList);
            modelAndView.setViewName("/admin/student");
        }
        return modelAndView;
    }

}
