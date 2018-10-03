package cn.xeblog.xeblogapi.service;

import cn.xeblog.xeblogapi.domain.dto.LinkDTO;

import java.util.List;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
public interface LinkService {

    /**
     * 链接列表
     *
     * @return
     * @throws Exception
     */
    List<LinkDTO> listLink() throws Exception;
}
