package cn.xeblog.api.service.impl;

import cn.xeblog.api.dao.EmailSendStatusMapper;
import cn.xeblog.api.domain.model.EmailSendStatus;
import cn.xeblog.api.service.EmailSendStatusService;
import cn.xeblog.api.util.MyBatisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author anlingyi
 * @date 2020/3/17
 */
@Service
public class EmailSendStatusServiceImpl implements EmailSendStatusService {

    @Resource
    private EmailSendStatusMapper emailSendStatusMapper;

    @Override
    public boolean addEmailSendStatus(Integer subId, Integer articleId, Integer status) {
        return MyBatisUtils.retBool(emailSendStatusMapper.addEmailSendStatus(new EmailSendStatus(subId, articleId, status)));
    }

    @Override
    public List<Integer> listSendStatusByArticleId(Integer articleId) {
        return emailSendStatusMapper.listSendStatusByArticleId(articleId);
    }
}
