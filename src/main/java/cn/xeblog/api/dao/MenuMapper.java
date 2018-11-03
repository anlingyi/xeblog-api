package cn.xeblog.api.dao;

import cn.xeblog.api.domain.model.Menu;
import cn.xeblog.api.domain.request.AddOrUpdateMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
public interface MenuMapper {

    /**
     * 菜单列表
     *
     * @return
     * @throws Exception
     */
    List<Menu> listMenu() throws Exception;

    /**
     * 添加菜单
     *
     * @param addOrUpdateMenu
     * @return
     * @throws Exception
     */
    Integer addMenu(@Param("add") AddOrUpdateMenu addOrUpdateMenu) throws Exception;

    /**
     * 修改菜单
     *
     * @param addOrUpdateMenu
     * @return
     * @throws Exception
     */
    Integer updateMenu(@Param("ud") AddOrUpdateMenu addOrUpdateMenu) throws Exception;

    /**
     * 删除菜单
     *
     * @param id
     * @return
     * @throws Exception
     */
    Integer deleteMenu(Integer id) throws Exception;

    /**
     * 菜单列表cms
     *
     * @return
     * @throws Exception
     */
    List<Menu> listMenuAdmin() throws Exception;
}
