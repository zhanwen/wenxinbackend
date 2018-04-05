package cn.shnu.ssm.controller;

import cn.shnu.ssm.pojo.User;
import cn.shnu.ssm.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



}
