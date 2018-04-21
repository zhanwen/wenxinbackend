package cn.shnu.ssm.dao;

import cn.shnu.ssm.pojo.FileBean;
import cn.shnu.ssm.pojo.Teacher;
import cn.shnu.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Hanwen
 * @Date: 2018/4/5 下午3:08
 */
public interface FileDao {
    void save(FileBean fileBean);
    void delete(FileBean fileBean);

    List<FileBean> findAll();

    List<FileBean> findFile(FileBean fileBean);

    int findAllByCategory(String category);
}