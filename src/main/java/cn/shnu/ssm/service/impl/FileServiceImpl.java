package cn.shnu.ssm.service.impl;

import cn.shnu.ssm.dao.FileDao;
import cn.shnu.ssm.dao.UserDao;
import cn.shnu.ssm.pojo.FileBean;
import cn.shnu.ssm.pojo.Teacher;
import cn.shnu.ssm.pojo.User;
import cn.shnu.ssm.service.FileService;
import cn.shnu.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Hanwen
 * @Date: 2018/4/4 下午4:08
 */
@Service
public class FileServiceImpl implements FileService{

    @Autowired
    private FileDao fileDao;

    public void save(FileBean fileBean) {
        fileDao.save(fileBean);

    }

    public void delete(FileBean fileBean) {
        fileDao.delete(fileBean);
    }

    public List<FileBean> findAll() {
        return fileDao.findAll();
    }

    public FileBean findFile(FileBean fileBean) {
        int pageNos = fileBean.getPageNos();
        int pageSize = fileBean.getPageSize();
        int start = (pageNos-1)*pageSize;
        fileBean.setPageNos(start);
        List<FileBean> lists = fileDao.findFile(fileBean);
        FileBean bean = new FileBean();
        bean.setResultList(lists);
        return bean;
    }

    public int findAllByCategory(String category) {
        return fileDao.findAllByCategory(category);
    }
}
