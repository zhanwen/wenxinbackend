package cn.shnu.ssm.controller;

import cn.shnu.ssm.pojo.FileBean;
import cn.shnu.ssm.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Hanwen
 * @Date: 2018/4/20 上午10:21
 */
@Controller
@RequestMapping("/new")
public class UploadController {

    @Autowired
    private FileService fileService;

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
    @RequestMapping("download")
    public ModelAndView download(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<FileBean> lists = fileService.findAll();
        Map<String, String> map = new HashMap<String, String>();
        int socialNetwork=0, nlp=0, machineLearn=0, informationRecommend=0, deepLearn=0, computerVision=0, bigDataDig=0;
        for(FileBean bean : lists){
           switch (Integer.valueOf(bean.getCategory())) {
               case 1: socialNetwork++; break;
               case 2: nlp++; break;
               case 3: machineLearn++; break;
               case 4: informationRecommend++; break;
               case 5: deepLearn++; break;
               case 6: computerVision++; break;
               case 7: bigDataDig++; break;
            }
        }
        map.put("socialNetwork", String.valueOf(socialNetwork));
        map.put("npl", String.valueOf(nlp));
        map.put("machineLearn", String.valueOf(machineLearn));
        map.put("informationRecommend", String.valueOf(informationRecommend));
        map.put("deepLearn", String.valueOf(deepLearn));
        map.put("computerVision", String.valueOf(computerVision));
        map.put("bigDataDig", String.valueOf(bigDataDig));
        FileBean fileBean = new FileBean();
        int pageNos;
        String pageNum = request.getParameter("pageNos");
        if(pageNum == null || Integer.valueOf(pageNum) < 1) {
            pageNos = 1;
        }else {
            pageNos = Integer.valueOf(pageNum);
        }
        fileBean.setPageNos(pageNos);
        fileBean.setCategory("1");
        int totalSize;
        totalSize = fileService.findAllByCategory(fileBean.getCategory());
        FileBean files = fileService.findFile(fileBean);
        files.setPageNos(pageNos);
        files.setTotalPage(totalSize/fileBean.getPageSize() + 1);
        request.getSession().setAttribute("map", map);
        modelAndView.addObject("fileBean", files);
        modelAndView.setViewName("download");
        return modelAndView;
    }
    @RequestMapping("download/nlp")
    public ModelAndView nlp(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        FileBean fileBean = new FileBean();
        int pageNos;
        String pageNum = request.getParameter("pageNos");
        if(pageNum == null || Integer.valueOf(pageNum) < 1) {
            pageNos = 1;
        }else {
            pageNos = Integer.valueOf(pageNum);
        }
        fileBean.setPageNos(pageNos);
        fileBean.setCategory("2");
        int totalSize;
        totalSize = fileService.findAllByCategory(fileBean.getCategory());
        FileBean files = fileService.findFile(fileBean);
        files.setPageNos(pageNos);
        files.setTotalPage(totalSize/fileBean.getPageSize() + 1);
        modelAndView.addObject("fileBean", files);
        modelAndView.setViewName("download/nlp");
        return modelAndView;
    }
    @RequestMapping("download/machineLearn")
    public ModelAndView machineLearn(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        FileBean fileBean = new FileBean();
        int pageNos;
        String pageNum = request.getParameter("pageNos");
        if(pageNum == null || Integer.valueOf(pageNum) < 1) {
            pageNos = 1;
        }else {
            pageNos = Integer.valueOf(pageNum);
        }
        fileBean.setPageNos(pageNos);
        fileBean.setCategory("3");
        int totalSize;
        totalSize = fileService.findAllByCategory(fileBean.getCategory());
        FileBean files = fileService.findFile(fileBean);
        files.setTotalPage(totalSize/fileBean.getPageSize() + 1);
        files.setPageNos(pageNos);
        modelAndView.addObject("fileBean", files);
        modelAndView.setViewName("download/machineLearn");
        return modelAndView;
    }
    @RequestMapping("download/informationRecommend")
    public ModelAndView informationRecommend(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        FileBean fileBean = new FileBean();
        int pageNos;
        String pageNum = request.getParameter("pageNos");
        if(pageNum == null || Integer.valueOf(pageNum) < 1) {
            pageNos = 1;
        }else {
            pageNos = Integer.valueOf(pageNum);
        }
        fileBean.setPageNos(pageNos);
        fileBean.setCategory("4");
        int totalSize;
        totalSize = fileService.findAllByCategory(fileBean.getCategory());
        FileBean files = fileService.findFile(fileBean);
        files.setTotalPage(totalSize/fileBean.getPageSize() + 1);
        files.setPageNos(pageNos);
        modelAndView.addObject("fileBean", files);
        modelAndView.setViewName("download/informationRecommend");
        return modelAndView;
    }
    @RequestMapping("download/deepLearning")
    public ModelAndView deepLearning(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        FileBean fileBean = new FileBean();
        int pageNos;
        String pageNum = request.getParameter("pageNos");
        if(pageNum == null || Integer.valueOf(pageNum) < 1) {
            pageNos = 1;
        }else {
            pageNos = Integer.valueOf(pageNum);
        }
        fileBean.setPageNos(pageNos);
        fileBean.setCategory("5");
        int totalSize;
        totalSize = fileService.findAllByCategory(fileBean.getCategory());
        FileBean files = fileService.findFile(fileBean);
        files.setTotalPage(totalSize/fileBean.getPageSize() + 1);
        files.setPageNos(pageNos);
        modelAndView.addObject("fileBean", files);
        modelAndView.setViewName("download/deepLearning");
        return modelAndView;
    }
    @RequestMapping("download/computerVision")
    public ModelAndView computerVision(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        FileBean fileBean = new FileBean();
        int pageNos;
        String pageNum = request.getParameter("pageNos");
        if(pageNum == null || Integer.valueOf(pageNum) < 1) {
            pageNos = 1;
        }else {
            pageNos = Integer.valueOf(pageNum);
        }
        fileBean.setPageNos(pageNos);
        fileBean.setCategory("6");
        int totalSize;
        totalSize = fileService.findAllByCategory(fileBean.getCategory());
        FileBean files = fileService.findFile(fileBean);
        files.setTotalPage(totalSize/fileBean.getPageSize() + 1);
        files.setPageNos(pageNos);
        modelAndView.addObject("fileBean", files);
        modelAndView.setViewName("download/computerVision");
        return modelAndView;
    }
    @RequestMapping("download/bigDataDig")
    public ModelAndView bigDataDig(HttpServletRequest request) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        FileBean fileBean = new FileBean();
        int pageNos;
        String pageNum = request.getParameter("pageNos");
        if(pageNum == null || Integer.valueOf(pageNum) < 1) {
            pageNos = 1;
        }else {
            pageNos = Integer.valueOf(pageNum);
        }
        fileBean.setPageNos(pageNos);
        fileBean.setCategory("7");
        int totalSize;
        totalSize = fileService.findAllByCategory(fileBean.getCategory());
        FileBean files = fileService.findFile(fileBean);
        files.setTotalPage(totalSize/fileBean.getPageSize() + 1);
        files.setPageNos(pageNos);
        modelAndView.addObject("fileBean", files);
        modelAndView.setViewName("download/bigDataDig");
        return modelAndView;
    }



}
