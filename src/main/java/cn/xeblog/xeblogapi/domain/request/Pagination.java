package cn.xeblog.xeblogapi.domain.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * 分页
 *
 * @author yanpanyi
 * @date 2018/9/5
 */
public class Pagination {
    /**
     * 页码
     */
    @ApiModelProperty("页码")
    private Integer pageIndex = 1;
    /**
     * 每页显示数据数
     */
    @ApiModelProperty("每页显示数据数")
    private Integer pageSize = 20;

    public Pagination() {
    }

    public Pagination(Integer pageIndex, Integer pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                '}';
    }
}
