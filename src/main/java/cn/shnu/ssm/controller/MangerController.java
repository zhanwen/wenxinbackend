package cn.shnu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Hanwen
 * @Date: 2018/4/7 下午4:33
 */
@Controller
@RequestMapping("admin")
public class MangerController {

    @RequestMapping("manager")
    public ModelAndView manager() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/manager");
        return modelAndView;
    }

}
