package cn.shnu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Hanwen
 * @Date: 2018/4/7 下午12:10
 */
@Controller
@RequestMapping("research")
public class ResearchController {

    @RequestMapping("researchDirection")
    public ModelAndView researchDirection(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().setAttribute("active", "research");


        modelAndView.setViewName("/researchDirection/researchDirection");
        return modelAndView;
    }
}
