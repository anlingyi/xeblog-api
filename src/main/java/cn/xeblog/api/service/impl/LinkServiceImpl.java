package cn.xeblog.api.service.impl;

import cn.xeblog.api.dao.LinkMapper;
import cn.xeblog.api.domain.bo.PageList;
import cn.xeblog.api.domain.dto.LinkDTO;
import cn.xeblog.api.domain.dto.admin.LinkAdminDTO;
import cn.xeblog.api.domain.model.Link;
import cn.xeblog.api.domain.request.AddOrUpdateLink;
import cn.xeblog.api.domain.request.Pagination;
import cn.xeblog.api.service.LinkService;
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
public class LinkServiceImpl implements LinkService {

    @Resource
    private LinkMapper linkMapper;

    @Override
    public List<LinkDTO> listLink() throws Exception {
        List<Link> linkList = this.linkMapper.listLink();
        if (linkList.isEmpty()) {
            return null;
        }

        List<LinkDTO> linkDTOList = new ArrayList<>(linkList.size());
        for (Link link : linkList) {
            linkDTOList.add(LinkDTO.toLinkDTO(link));
        }

        return linkDTOList;
    }

    @Override
    public PageList listLinkAdmin(Pagination pagination) throws Exception {
        PageHelper.startPage(pagination.getPageIndex(), pagination.getPageSize());
        List<Link> linkList = this.linkMapper.listLinkAdmin();

        if (linkList.isEmpty()) {
            return null;
        }

        PageInfo pageInfo = new PageInfo(linkList);
        List<LinkAdminDTO> linkAdminDTOList = new ArrayList<>();
        for (Link link : linkList) {
            linkAdminDTOList.add(LinkAdminDTO.toLinkAdminDTO(link));
        }

        return new PageList(linkAdminDTOList, pageInfo.getPageNum(), pageInfo.getPages());
    }

    @Override
    public boolean addLink(AddOrUpdateLink addOrUpdateLink) throws Exception {
        return 1 == this.linkMapper.addLink(addOrUpdateLink);
    }

    @Override
    public boolean updateLink(AddOrUpdateLink addOrUpdateLink) throws Exception {
        return 1 == this.linkMapper.updateLinkById(addOrUpdateLink);
    }

    @Override
    public boolean deleteLinkById(Integer id) throws Exception {
        return 1 == this.linkMapper.deleteLinkById(id);
    }
}
