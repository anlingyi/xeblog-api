package cn.xeblog.api.service;

import cn.xeblog.api.domain.bo.PageList;
import cn.xeblog.api.domain.dto.MenuDTO;
import cn.xeblog.api.domain.request.AddOrUpdateMenu;
import cn.xeblog.api.domain.request.Pagination;

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

    /**
     * 菜单列表
     *
     * @param pagination
     * @return
     * @throws Exception
     */
    PageList listMenuAdmin(Pagination pagination) throws Exception;
}
