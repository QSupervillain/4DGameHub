package com.cxk.pojo;

import java.util.List;

/**
 * 视屏分页实体类
 * @param <T>
 */
public class Pagination<T> {
    private int pageIndex;
    private int pageSize;
    private int pages;
    private int total;
    private List<T> list;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Pagination(int pageIndex, int pageSize, int pages, int total, List<T> list) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.pages = pages;
        this.total = total;
        this.list = list;
    }

    public Pagination() {

    }

    @Override
    public String toString() {
        return "Pagination{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", pages=" + pages +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
