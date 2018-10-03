package cn.xeblog.xeblogapi.service;

import cn.xeblog.xeblogapi.domain.dto.MenuDTO;
import cn.xeblog.xeblogapi.domain.request.AddOrUpdateMenu;

import java.util.List;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
public interface MenuService {

    /**
     * 菜单列表
     *
     * @return
     * @throws Exception
     */
    List<MenuDTO> listMenu() throws Exception;

    /**
     * 添加菜单
     *
     * @param addOrUpdateMenu
     * @return
     * @throws Exception
     */
    boolean addMenu(AddOrUpdateMenu addOrUpdateMenu) throws Exception;

    /**
     * 修改菜单
     *
     * @param addOrUpdateMenu
     * @return
     * @throws Exception
     */
    boolean updateMenu(AddOrUpdateMenu addOrUpdateMenu) throws Exception;

    /**
     * 删除菜单
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteMenu(Integer id) throws Exception;
}
