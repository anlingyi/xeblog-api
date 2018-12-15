package cn.xeblog.api.domain.bo;

import java.util.List;

/**
 * 通用分页显示
 *
 * @author yanpanyi
 * @date 2018/7/23
 */
public class PageList {
    /**
     * 列表
     */
    private List list;
    /**
     * 当前页码
     */
    private Integer pageNum;
    /**
     * 总页数
     */
    private Integer pages;
    /**
     * 总记录数
     */
    private long total;

    public PageList() {
    }

    public PageList(List list, Integer pageNum, Integer pages) {
        this.list = list;
        this.pageNum = pageNum;
        this.pages = pages;
    }

    public PageList(List list, Integer pageNum, Integer pages, long total) {
        this.list = list;
        this.pageNum = pageNum;
        this.pages = pages;
        this.total = total;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "PageList{" +
                "list=" + list +
                ", pageNum=" + pageNum +
                ", pages=" + pages +
                ", total=" + total +
                '}';
    }
}
