package cn.xeblog.api.dao;

import cn.xeblog.api.domain.model.Link;
import cn.xeblog.api.domain.request.AddOrUpdateLink;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
public interface LinkMapper {

    /**
     * 链接列表
     *
     * @return
     * @throws Exception
     */
    List<Link> listLink() throws Exception;

    /**
     * 链接列表cms
     *
     * @return
     * @throws Exception
     */
    List<Link> listLinkAdmin() throws Exception;

    /**
     * 添加链接信息
     *
     * @param addOrUpdateLink
     * @return
     * @throws Exception
     */
    Integer addLink(@Param("add") AddOrUpdateLink addOrUpdateLink) throws Exception;

    /**
     * 更新链接信息
     *
     * @param addOrUpdateLink
     * @return
     * @throws Exception
     */
    Integer updateLinkById(@Param("up") AddOrUpdateLink addOrUpdateLink) throws Exception;

    /**
     * 通过id删除链接
     *
     * @param id
     * @return
     * @throws Exception
     */
    Integer deleteLinkById(Integer id) throws Exception;

}
