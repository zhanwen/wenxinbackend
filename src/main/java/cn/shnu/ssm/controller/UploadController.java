package cn.shnu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Hanwen
 * @Date: 2018/4/20 上午10:21
 */
@Controller
@RequestMapping("/new")
public class UploadController {

    @RequestMapping("home")
    public ModelAndView home(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping("direction")
    public ModelAndView direction(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("direction");
        return modelAndView;
    }
    @RequestMapping("researchProject")
    public ModelAndView researchProject(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("researchProject");
        return modelAndView;
    }
    @RequestMapping("successResult")
    public ModelAndView successResult(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("successResult");
        return modelAndView;
    }
    @RequestMapping("team")
    public ModelAndView team(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("team");
        return modelAndView;
    }

}
