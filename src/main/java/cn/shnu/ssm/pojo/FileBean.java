package cn.shnu.ssm.pojo;

import java.util.Date;
import java.util.List;

/**
 * @Author: Hanwen
 * @Date: 2018/4/21 上午11:03
 */
public class FileBean {
    private int id;
    private String fileName;
    private String filePath;
    private String category;
    private String date;
    private String name;

    private int totalPage;
    private int totalSize;
    private int pageSize = 10;
    private List<FileBean> resultList;
    private int pageNos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNos() {
        return pageNos;
    }

    public void setPageNos(int pageNos) {
        this.pageNos = pageNos;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<FileBean> getResultList() {
        return resultList;
    }

    public void setResultList(List<FileBean> resultList) {
        this.resultList = resultList;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
