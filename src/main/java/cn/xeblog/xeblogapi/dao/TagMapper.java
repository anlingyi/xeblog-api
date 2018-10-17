package cn.xeblog.xeblogapi.dao;

import cn.xeblog.xeblogapi.domain.model.Tag;

import java.util.List;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
public interface TagMapper {

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
    List<Tag> listTag() throws Exception;

    /**
     * 添加标签
     *
     * @param name
     * @return
     * @throws Exception
     */
    Integer addTag(String name) throws Exception;

    /**
     * 删除标签
     *
     * @param id
     * @return
     * @throws Exception
     */
    Integer deleteTagById(Integer id) throws Exception;

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
     * @return
     * @throws Exception
     */
    List<Tag> listTagAdmin() throws Exception;
}
