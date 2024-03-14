package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MenuDTO;
import com.example.demo.entity.Kitchen;
import com.example.demo.entity.Menu;
import com.example.demo.mapper.MenuMapperImpl;
import com.example.demo.repository.KitchenRepository;
import com.example.demo.repository.MenuRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class MenuServiceImpl implements MenuService{

	MenuRepository menuRepository;
	KitchenRepository kitchenRepository;
	
	MenuMapperImpl dtoMapperMenu;
	
	public MenuServiceImpl(MenuRepository menuRepository, KitchenRepository kitchenRepository, MenuMapperImpl dtoMapperKitchen){
        this.menuRepository = menuRepository;
        this.kitchenRepository = kitchenRepository;
        this.dtoMapperMenu = dtoMapperKitchen;
    }
	
	@Override
	public List<MenuDTO> listMenus() {
		List<Menu> listMenus = menuRepository.findAll();
        List<MenuDTO> listMenuDTOS = new ArrayList<>();
        for(Menu menu:listMenus){
        	MenuDTO menuDTO = dtoMapperMenu.fromMenu(menu);
        	System.out.println("---------------------------------------");
//        	System.out.println("menu: "+menu.);
//        	System.out.println("menu DTO: "+menuDTO);
        	System.out.println("---------------------------------------");
            listMenuDTOS.add(menuDTO);
        }
        return listMenuDTOS; 
	}

	@Override
	public MenuDTO saveMenu(MenuDTO menuDTO) {
		Menu menu = dtoMapperMenu.fromMenuDTO(menuDTO);
		Kitchen k = kitchenRepository.findById(menuDTO.getKitchen_id()).orElse(null);
		//System.out.println("k: "+k.getName()+" - "+k.get);
		menu.setKitchen(k);
		
		Menu savedMenu = menuRepository.save(menu);
		return dtoMapperMenu.fromMenu(savedMenu);
	}

	@Override
	public MenuDTO getMenuById(Long menuId) {
		Menu menu = menuRepository.findById(menuId).orElseThrow(null);
        return dtoMapperMenu.fromMenu(menu);
	}

}
