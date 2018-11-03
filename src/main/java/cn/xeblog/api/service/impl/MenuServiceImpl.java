package cn.xeblog.api.service.impl;

import cn.xeblog.api.dao.MenuMapper;
import cn.xeblog.api.domain.bo.PageList;
import cn.xeblog.api.domain.dto.MenuDTO;
import cn.xeblog.api.domain.dto.admin.MenuAdminDTO;
import cn.xeblog.api.domain.model.Menu;
import cn.xeblog.api.domain.request.AddOrUpdateMenu;
import cn.xeblog.api.domain.request.Pagination;
import cn.xeblog.api.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yanpanyi
 * @date 2018/10/3
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<MenuDTO> listMenu() throws Exception {
        List<Menu> menuList = this.menuMapper.listMenu();

        if (menuList.isEmpty()) {
            return null;
        }

        List<MenuDTO> menuDTOList = new ArrayList<>(menuList.size());

        for (Menu menu : menuList) {
            menuDTOList.add(MenuDTO.toMenuDTO(menu));
        }

        return menuDTOList;
    }

    @Override
    public boolean addMenu(AddOrUpdateMenu addOrUpdateMenu) throws Exception {
        return 1 == this.menuMapper.addMenu(addOrUpdateMenu);
    }

    @Override
    public boolean updateMenu(AddOrUpdateMenu addOrUpdateMenu) throws Exception {
        return 1 == this.menuMapper.updateMenu(addOrUpdateMenu);
    }

    @Override
    public boolean deleteMenu(Integer id) throws Exception {
        return 1 == this.menuMapper.deleteMenu(id);
    }

    @Override
    public PageList listMenuAdmin(Pagination pagination) throws Exception {
        PageHelper.startPage(pagination.getPageIndex(), pagination.getPageSize());
        List<Menu> menuList = this.menuMapper.listMenuAdmin();

        if (menuList.isEmpty()) {
            return null;
        }

        PageInfo pageInfo = new PageInfo(menuList);

        List<MenuAdminDTO> menuAdminDTOList = new ArrayList<>(menuList.size());
        for (Menu menu : menuList) {
            menuAdminDTOList.add(MenuAdminDTO.toMenuAdminDTO(menu));
        }

        return new PageList(menuAdminDTOList, pageInfo.getPageNum(), pageInfo.getPages());
    }
}
