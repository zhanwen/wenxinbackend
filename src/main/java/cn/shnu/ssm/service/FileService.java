package cn.shnu.ssm.service;

import cn.shnu.ssm.pojo.FileBean;
import cn.shnu.ssm.pojo.Teacher;
import cn.shnu.ssm.pojo.User;

import java.util.List;

/**
 * @Author: Hanwen
 * @Date: 2018/4/4 下午3:08
 */
public interface FileService {

    void save(FileBean fileBean);
    void delete(FileBean fileBean);

    List<FileBean> findAll();

    FileBean findFile(FileBean fileBean);

    int findAllByCategory(String category);
}
