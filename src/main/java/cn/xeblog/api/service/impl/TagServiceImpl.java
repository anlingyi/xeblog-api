package cn.xeblog.api.service.impl;

import cn.xeblog.api.dao.TagMapper;
import cn.xeblog.api.domain.bo.PageList;
import cn.xeblog.api.domain.dto.TagDTO;
import cn.xeblog.api.domain.dto.admin.TagAdminDTO;
import cn.xeblog.api.domain.model.Tag;
import cn.xeblog.api.domain.request.Pagination;
import cn.xeblog.api.service.TagService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public PageList listTagAdmin(Pagination pagination) throws Exception {
        PageHelper.startPage(pagination.getPageIndex(), pagination.getPageSize());
        List<Tag> tagList = this.tagMapper.listTagAdmin();

        if (tagList.isEmpty()) {
            return null;
        }

        PageInfo pageInfo = new PageInfo(tagList);

        List<TagAdminDTO> tagAdminDTOList = new ArrayList<>(tagList.size());
        for (Tag tag : tagList) {
            tagAdminDTOList.add(TagAdminDTO.toTagAdminDTO(tag));
        }

        return new PageList(tagAdminDTOList, pageInfo.getPageNum(), pageInfo.getPages(),
                pageInfo.getTotal());
    }
}
