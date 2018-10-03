package cn.xeblog.xeblogapi.dao;

import cn.xeblog.xeblogapi.domain.model.Link;

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
}
