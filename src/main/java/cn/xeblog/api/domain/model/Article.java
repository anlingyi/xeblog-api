package cn.xeblog.api.domain.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * 文章
 *
 * @author yanpanyi
 */
@Data
public class Article extends Model<Article> {

    private Integer id;
    private String title;
    private String content;
    private String cover;
    private Integer isTop;
    private Integer isPrivate;
    private Integer categoryId;
    private String tag;
    private Integer pageviews;
    private String author;
    private Date createTime;
    private Date updateTime;
    private String brief;
    @TableField(exist = false)
    private String categoryName;
    private Integer wordCount;
    private Integer isRcmd;
    private Integer deleteFlag;

}
