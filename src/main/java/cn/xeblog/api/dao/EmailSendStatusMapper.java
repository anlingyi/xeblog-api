package cn.xeblog.api.dao;

import cn.xeblog.api.domain.bo.ArticlePushStatistics;
import cn.xeblog.api.domain.model.EmailSendStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author anlingyi
 * @date 2020/3/17
 */
public interface EmailSendStatusMapper {

    /**
     * 添加发送状态
     *
     * @param emailSendStatus
     * @return
     */
    Integer addEmailSendStatus(@Param("emailSendStatus") EmailSendStatus emailSendStatus);

    /**
     * 通过文章ID查询发送状态列表
     *
     * @param articleId
     * @return
     */
    List<Integer> listSendStatusByArticleId(Integer articleId);
}
