package cn.xeblog.xeblogapi.service.impl;

import cn.xeblog.xeblogapi.dao.TagMapper;
import cn.xeblog.xeblogapi.domain.dto.TagDTO;
import cn.xeblog.xeblogapi.domain.model.Tag;
import cn.xeblog.xeblogapi.enums.Code;
import cn.xeblog.xeblogapi.exception.CustomException;
import cn.xeblog.xeblogapi.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<TagDTO> listTag() throws Exception {
        List<Tag> tagList = this.tagMapper.listTag();

        if (tagList.isEmpty()) {
            return null;
        }

        List<TagDTO> tagDTOList = new ArrayList<>(tagList.size());
        for (Tag tag : tagList) {
            tagDTOList.add(TagDTO.toTagDTO(tag));
        }
        return tagDTOList;
    }

    @Override
    public boolean addTag(String name) throws Exception {
        if (null != this.getTagIdByName(name)) {
            // 标签已存在
            throw new CustomException(Code.TAG_ALREADY_EXISTS);
        }

        return 1 == this.tagMapper.addTag(name);
    }

    @Override
    public boolean deleteTagById(Integer id) throws Exception {
        return 1 == this.tagMapper.deleteTagById(id);
    }

    @Override
    public Integer getTagIdByName(String name) throws Exception {
        return this.tagMapper.getTagIdByName(name);
    }
}