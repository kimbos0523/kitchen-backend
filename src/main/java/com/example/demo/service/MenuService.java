package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.KitchenDTO;
import com.example.demo.dto.MenuDTO;

public interface MenuService {
	public List<MenuDTO> listMenus();
	MenuDTO saveMenu(MenuDTO menuDTO);
	MenuDTO getMenuById(Long menuId);
}
