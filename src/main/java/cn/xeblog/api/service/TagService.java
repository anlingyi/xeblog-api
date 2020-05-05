package cn.xeblog.api.service;

import cn.xeblog.api.domain.bo.PageList;
import cn.xeblog.api.domain.dto.TagDTO;
import cn.xeblog.api.domain.request.Pagination;

import java.util.List;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
public interface TagService {

    /**
     * 获取标签总数
     *
     * @return
     * @throws Exception
     */
    Integer getCount() throws Exception;

    /**
     * 标签列表
     *
     * @return
     * @throws Exception
     */
    List<TagDTO> listTag() throws Exception;

    /**
     * 添加标签
     *
     * @param name
     * @return
     * @throws Exception
     */
    boolean addTag(String name) throws Exception;

    /**
     * 删除标签
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteTagById(Integer id) throws Exception;

    /**
     * 通过name获取标签
     *
     * @param name
     * @return
     * @throws Exception
     */
    Integer getTagIdByName(String name) throws Exception;

    /**
     * 标签列表cms
     *
     * @param pagination
     * @return
     * @throws Exception
     */
    PageList listTagAdmin(Pagination pagination) throws Exception;

    /**
     * 模糊查询标签
     *
     * @param tag
     * @return
     */
    List<String> blurryQueryTags(String tag);
}
