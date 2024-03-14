package com.example.demo.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MenuDTO;
import com.example.demo.entity.Menu;

@Service
public class MenuMapperImpl {
	
	public Menu fromMenuDTO(MenuDTO menuDTO){
		Menu menu = new Menu();
        BeanUtils.copyProperties(menuDTO, menu);
        return menu;
    }

    public MenuDTO fromMenu(Menu menu){
    	MenuDTO menuDTO = new MenuDTO();
        BeanUtils.copyProperties(menu, menuDTO);
        return menuDTO;
    }

}
