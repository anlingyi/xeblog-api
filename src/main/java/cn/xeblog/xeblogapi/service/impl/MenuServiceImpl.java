package cn.xeblog.xeblogapi.service.impl;

import cn.xeblog.xeblogapi.dao.MenuMapper;
import cn.xeblog.xeblogapi.domain.dto.MenuDTO;
import cn.xeblog.xeblogapi.domain.model.Menu;
import cn.xeblog.xeblogapi.domain.request.AddOrUpdateMenu;
import cn.xeblog.xeblogapi.service.MenuService;
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
}
