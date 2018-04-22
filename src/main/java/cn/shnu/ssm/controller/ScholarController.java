package cn.shnu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Hanwen
 * @Date: 2018/4/22 上午8:48
 */
@Controller
@RequestMapping("/scholar")
public class ScholarController {


    @RequestMapping("patent")
    public ModelAndView patent() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("scholar");
        return modelAndView;
    }
    @RequestMapping("softwareCopyright")
    public ModelAndView softwareCopyright() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("softwareCopyright");
        return modelAndView;
    }
    @RequestMapping("researchPages")
    public ModelAndView researchPages() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("researchPages");
        return modelAndView;
    }

    @RequestMapping("researchPages/page2013")
    public ModelAndView page2013() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("scholar/page2013");
        return modelAndView;
    }
    @RequestMapping("researchPages/page2014")
    public ModelAndView page2014() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("scholar/page2014");
        return modelAndView;
    }
    @RequestMapping("researchPages/page2015")
    public ModelAndView page2015() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("scholar/page2015");
        return modelAndView;
    }
    @RequestMapping("researchPages/page2016")
    public ModelAndView page2016() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("scholar/page2016");
        return modelAndView;
    }


    @RequestMapping("academicDissertations")
    public ModelAndView academicDissertations() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("academicDissertations");
        return modelAndView;
    }

    @RequestMapping("academicDissertations/academic2013")
    public ModelAndView academic20132013() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("scholar/academic2013");
        return modelAndView;
    }
    @RequestMapping("academicDissertations/academic2014")
    public ModelAndView academic2014() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("scholar/academic2014");
        return modelAndView;
    }
    @RequestMapping("academicDissertations/academic2015")
    public ModelAndView academic2015() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("scholar/academic2015");
        return modelAndView;
    }
    @RequestMapping("academicDissertations/academic2016")
    public ModelAndView academic2016() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("scholar/academic2016");
        return modelAndView;
    }


}
