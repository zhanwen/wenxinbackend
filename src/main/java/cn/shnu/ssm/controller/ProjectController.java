package cn.shnu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Hanwen
 * @Date: 2018/4/7 下午1:58
 */
@Controller
@RequestMapping("project")
public class ProjectController {
    @RequestMapping("scienceProject")
    public ModelAndView scienceProject(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().setAttribute("active", "project");
        modelAndView.setViewName("/project/scienceProject");
        return modelAndView;
    }




}
