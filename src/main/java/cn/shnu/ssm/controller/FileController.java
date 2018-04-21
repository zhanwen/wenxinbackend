package cn.shnu.ssm.controller;

import cn.shnu.ssm.pojo.FileBean;
import cn.shnu.ssm.service.FileService;
import cn.shnu.ssm.util.FileUploadingUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

/**
 * @Author: Hanwen
 * @Date: 2018/4/21 上午10:18
 */
@Controller
@RequestMapping("fileOperator")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping("fileList")
    public ModelAndView fileList(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if(request.getSession().getAttribute("admin") == null) {
            modelAndView.setViewName("/admin/login");
        }else{
            List<FileBean> fileList = fileService.findAll();
            modelAndView.addObject("fileList", fileList);
            modelAndView.setViewName("/admin/fileList");
        }
        return modelAndView;
    }
    @RequestMapping("addFile")
    public ModelAndView addFile(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if(request.getSession().getAttribute("admin") == null) {
            modelAndView.setViewName("/admin/login");
        }else{
            modelAndView.setViewName("/admin/addFile");
        }
        return modelAndView;
    }

    @RequestMapping("saveFile")
    public ModelAndView saveFile(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if(request.getSession().getAttribute("admin") == null) {
            modelAndView.setViewName("/admin/login");
        }
        String tempPath = "";
        String fileName = "";
        String virtualName = "";
        String categoryId = "";
        try {
            // 1. 文件上传工厂
            FileItemFactory factory = new DiskFileItemFactory();
            // 2. 创建文件上传核心工具类
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 一、设置单个文件允许的最大的大小： 30M
            upload.setFileSizeMax(30*1024*1024);
            // 二、设置文件上传表单允许的总大小: 80M
            upload.setSizeMax(80*1024*1024);
            // 三、 设置上传表单文件名的编码
            // 相当于：request.setCharacterEncoding("UTF-8");
            upload.setHeaderEncoding("UTF-8");

            // 3. 判断： 当前表单是否为文件上传表单
            if (upload.isMultipartContent(request)){
                // 4. 把请求数据转换为一个个FileItem对象，再用集合封装
                List<FileItem> list = upload.parseRequest(request);
                // 遍历： 得到每一个上传的数据
                for (FileItem item: list){
                    // 判断：普通文本数据
                    if (item.isFormField()){
                        // 普通文本数据
                        String fieldName = item.getFieldName();    // 表单元素名称
                        String content = item.getString();        // 表单元素名称， 对应的数据
                        categoryId = content;
                    }
                    // 上传文件(文件流) ----> 上传到upload目录下
                    else {
                        // 普通文本数据
                        String fieldName = item.getFieldName();    // 表单元素名称
                        String name = item.getName();            // 文件名
                        String content = item.getString();        // 表单元素名称， 对应的数据
                        String type = item.getContentType();    // 文件类型
                        InputStream in = item.getInputStream(); // 上传文件流

                        /*
                         *  四、文件名重名
                         *  对于不同用户readme.txt文件，不希望覆盖！
                         *  后台处理： 给用户添加一个唯一标记!
                         */
                        virtualName = name;
                        // a. 随机生成一个唯一标记
                        String id = UUID.randomUUID().toString();
                        // b. 与文件后锥名拼接
                        String suffix = name.substring(name.lastIndexOf(".") + 1);
                        fileName = id+"."+suffix;
                        // 获取上传基路径
                        String path = request.getSession().getServletContext().getRealPath( "/static/upload/file/");
                        tempPath = path;
                        // 创建目标文件
                        // 创建文件夹
                        File file2 = new File(path);
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        File file = new File(path,fileName);
                        // 工具类，文件上传
                        item.write(file);
                        item.delete();   //删除系统产生的临时文件
                    }
                }
            }
            else {
                System.out.println("当前表单不是文件上传表单，处理失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileBean fileBean = new FileBean();
        fileBean.setName(fileName);
        fileBean.setFileName(virtualName);
        fileBean.setFilePath(tempPath);
        fileBean.setCategory(categoryId);
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        fileBean.setDate(dateString);
        fileService.save(fileBean);
        List<FileBean> fileList = fileService.findAll();
        modelAndView.addObject("fileList", fileList);
        modelAndView.setViewName("redirect:/admin/fileList");
        return modelAndView;
    }

    @RequestMapping("deleteFile")
    public ModelAndView deleteFile(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if(request.getSession().getAttribute("admin") == null) {
            modelAndView.setViewName("/admin/login");
        }else{
            String fileId = request.getParameter("id");
            FileBean fileBean = new FileBean();
            fileBean.setId(Integer.valueOf(fileId));
            fileService.delete(fileBean);
            List<FileBean> fileList = fileService.findAll();
            modelAndView.addObject("fileList", fileList);
            modelAndView.setViewName("redirect:/admin/fileList");
        }
        return modelAndView;
    }



    private void iniFileDir(HttpServletRequest request) {
        FileUploadingUtil.FILEDIR = request.getSession().getServletContext().getRealPath("/") + "files/";
        if (FileUploadingUtil.FILEDIR == null) {
            FileUploadingUtil.FILEDIR = request.getSession().getServletContext().getRealPath("/") + "files/";
        }
    }

    @RequestMapping("downloadFile")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        try {
            // 打开文件
            // 获取到要下载文件的全路径
            String destinationfileName = request.getParameter("fileName");
            String filename = request.getParameter("name").trim();
            String uploadpath = request.getParameter("filePath");
            // 得到要下载的文件
            File file = new File(uploadpath + "/" + destinationfileName);
            //如果文件不存在，则显示下载失败
            if (!file.exists()) {
                request.getSession().setAttribute("message", "下载失败");
                request.getRequestDispatcher("/404.jsp").forward(request, response);
                return;
            } else {
                // 设置相应头，控制浏览器下载该文件，这里就是会出现当你点击下载后，出现的下载地址框
                response.setHeader("content-disposition",
                        "attachment;filename=" + filename);
                // 读取要下载的文件，保存到文件输入流
                FileInputStream in = new FileInputStream(uploadpath + "/" + destinationfileName);
                // 创建输出流
                OutputStream out = response.getOutputStream();
                // 创建缓冲区
                byte buffer[] = new byte[1024];
                int len = 0;
                // 循环将输入流中的内容读取到缓冲区中
                while ((len = in.read(buffer)) > 0) {
                    // 输出缓冲区内容到浏览器，实现文件下载
                    out.write(buffer, 0, len);
                }
                // 关闭文件流
                in.close();
                // 关闭输出流
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
