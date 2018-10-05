package cn.xeblog.xeblogapi.domain.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * 查询文章列表
 *
 * @author yanpanyi
 * @date 2018/10/4
 */
public class QueryArticle extends Pagination {

    @ApiModelProperty("查询关键字")
    private String query;
    @ApiModelProperty("标签")
    private String tag;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "QueryArticle{" +
                "query='" + query + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
