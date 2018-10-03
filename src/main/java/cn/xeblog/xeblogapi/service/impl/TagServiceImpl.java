package cn.xeblog.xeblogapi.service.impl;

import cn.xeblog.xeblogapi.dao.TagMapper;
import cn.xeblog.xeblogapi.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    public Integer getCount() throws Exception {
        return this.tagMapper.getCount();
    }
}
