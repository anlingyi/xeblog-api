package cn.xeblog.api.service;

import cn.xeblog.api.domain.bo.PageList;
import cn.xeblog.api.domain.dto.LinkDTO;
import cn.xeblog.api.domain.request.AddOrUpdateLink;
import cn.xeblog.api.domain.request.Pagination;

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

    /**
     * 链接列表cms
     *
     * @param pagination
     * @return
     * @throws Exception
     */
    PageList listLinkAdmin(Pagination pagination) throws Exception;

    /**
     * 添加链接信息
     *
     * @param addOrUpdateLink
     * @return
     * @throws Exception
     */
    boolean addLink(AddOrUpdateLink addOrUpdateLink) throws Exception;

    /**
     * 更新链接信息
     *
     * @param addOrUpdateLink
     * @return
     * @throws Exception
     */
    boolean updateLink(AddOrUpdateLink addOrUpdateLink) throws Exception;

    /**
     * 通过id删除链接
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteLinkById(Integer id) throws Exception;
}
