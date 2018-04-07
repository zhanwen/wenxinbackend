package cn.shnu.ssm.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Hanwen
 * @Date: 2018/4/7 下午2:28
 */
@Controller
@RequestMapping("school")
public class ScholarCtroller {

    @RequestMapping("schoolResult")
    public ModelAndView schoolResult(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().setAttribute("active", "school");
        request.getSession().setAttribute("link","patent");
        modelAndView.setViewName("/school/schoolResult");
        return modelAndView;
    }

    @RequestMapping("software")
    public ModelAndView researchPages(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().setAttribute("link","software");
        modelAndView.setViewName("/school/softwareResult");
        return modelAndView;
    }

    @RequestMapping("researchPages")
    public ModelAndView researchPages2017(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().setAttribute("link","research");
        request.getSession().setAttribute("pages","2017");
        modelAndView.setViewName("/school/researchPages");
        return modelAndView;
    }
    @RequestMapping("researchPages/2016")
    public ModelAndView researchPages2016(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().setAttribute("pages","2016");
        modelAndView.setViewName("/school/page2016");
        return modelAndView;
    }

    @RequestMapping("researchPages/2015")
    public ModelAndView researchPages2015(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().setAttribute("pages","2015");
        modelAndView.setViewName("/school/page2015");
        return modelAndView;
    }

    @RequestMapping("researchPages/2014")
    public ModelAndView researchPages2014(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().setAttribute("pages","2014");
        modelAndView.setViewName("/school/page2014");
        return modelAndView;
    }

    @RequestMapping("researchPages/2013")
    public ModelAndView researchPages2013(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().setAttribute("pages","2013");
        modelAndView.setViewName("/school/page2013");
        return modelAndView;
    }

    @RequestMapping("academicPages")
    public ModelAndView academicPages(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().setAttribute("pages","2017");
        request.getSession().setAttribute("link", "academic");
        modelAndView.setViewName("/school/academicPages");
        return modelAndView;
    }

    @RequestMapping("academicPages/2016")
    public ModelAndView academicPages2016(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().setAttribute("pages","2016");
        modelAndView.setViewName("/school/academicPages2016");
        return modelAndView;
    }

    @RequestMapping("academicPages/2015")
    public ModelAndView academicPages2015(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().setAttribute("pages","2015");
        modelAndView.setViewName("/school/academicPages2015");
        return modelAndView;
    }

    @RequestMapping("academicPages/2014")
    public ModelAndView academicPages2014(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().setAttribute("pages","2014");
        modelAndView.setViewName("/school/academicPages2014");
        return modelAndView;
    }

    @RequestMapping("academicPages/2013")
    public ModelAndView academicPages2013(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        request.getSession().setAttribute("pages","2013");
        modelAndView.setViewName("/school/academicPages2013");
        return modelAndView;
    }
}
