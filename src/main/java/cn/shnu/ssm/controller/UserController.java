package cn.shnu.ssm.controller;

import cn.shnu.ssm.pojo.User;
import cn.shnu.ssm.service.UserService;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: Hanwen
 * @Date: 2018/4/5 下午1:08
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping("/findUser")
//    public ModelAndView findUser() throws Exception{
//        ModelAndView modelAndView = new ModelAndView();
//        List<User> users = userService.findUser();
//        modelAndView.addObject("users", users);
//        modelAndView.setViewName("findUser");
//
//        return modelAndView;
//    }

    @RequestMapping("loginPage")
    public ModelAndView loginPage() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("home")
    public void home(HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.getSession().setAttribute("active", "home");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    @ResponseBody
    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response, String studentNo, String pwd) throws Exception{
        Map<String, String> msg = new HashMap<String, String>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", "");
        User user = userService.findUser(studentNo);
        if(user == null) {
            jsonObject.put("result", "studentNoFalse");
            return jsonObject.toString();
        }else {
            if(pwd.equals(user.getPassword())) {
                //存入session
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("active", "home");
                //使用cookies记录
                String flag = request.getParameter("flag");
                request.getSession().setAttribute("flag", flag);
                //set cookie
                if(flag!=null && flag.equals("1")){
                    Cookie cookie = new Cookie("cookie_user", user.getStudentNo()+"-"+user.getPassword());
                    cookie.setMaxAge(60*60*24*30); //cookie 保存30天
                    response.addCookie(cookie);
                }else{
                    Cookie cookie = new Cookie("cookie_user",user.getStudentNo()+"-"+null);
                    cookie.setMaxAge(60*60*24*30); //cookie 保存30天
                    response.addCookie(cookie);
                }
            }else {
                jsonObject.put("result", "pwdFalse");
                return jsonObject.toString();
            }
        }
        return jsonObject.toString();
    }

    @RequestMapping("logout")
    public ModelAndView logout(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        // 设置session为空
        request.getSession().setAttribute("user", null);
        // 页面跳转
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("profile")
    public ModelAndView profile(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        User user = (User)request.getSession().getAttribute("user");
        request.getSession().setAttribute("active", "profile");
        if(user == null) {
            modelAndView.setViewName("login");
        }else {
            modelAndView.setViewName("profile");
        }
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("uploadImagePage")
    public ModelAndView uploadImagePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("uploadImage");
        return modelAndView;
    }

    @RequestMapping("uploadImage")
    public ModelAndView uploadImage(MultipartFile uploadFile, HttpServletRequest request) throws Exception{
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String responseStr = "";
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        // 获取上传文件存放的 目录 , 无则创建
        String configPath = request.getSession().getServletContext().getRealPath( "/static/upload/images/");
        // 创建文件夹
        File file = new File(configPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = null;
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            // 上传文件名
            // System.out.println("key: " + entity.getKey());
            MultipartFile mf = entity.getValue();
            fileName = mf.getOriginalFilename();
            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
            responseStr = "/static/upload/images/" + newFileName ;
            File uploadFile2 = new File(configPath+"/" + newFileName);
            try {
                FileCopyUtils.copy(mf.getBytes(), uploadFile2);
            } catch (Exception e) {
                responseStr = "上传失败";
                e.printStackTrace();
            }
        }

        user.setImagepath(responseStr);
        userService.updateUser(user);
        modelAndView.setViewName("profile");
        return modelAndView;
    }
}
