package cn.xeblog.xeblogapi.service.impl;

import cn.xeblog.xeblogapi.dao.LinkMapper;
import cn.xeblog.xeblogapi.domain.dto.LinkDTO;
import cn.xeblog.xeblogapi.domain.model.Link;
import cn.xeblog.xeblogapi.service.LinkService;
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
}
