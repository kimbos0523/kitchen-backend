package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.MenuDTO;
import com.example.demo.service.MenuService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("http://localhost:4200")
@Slf4j
public class MenuRestController {
	private MenuService menuService;
    public MenuRestController(MenuService menuService){
        this.menuService = menuService;
    }

    @GetMapping("/menus")
    public List<MenuDTO> listMenus(){
        return menuService.listMenus();
    }
    
    @GetMapping("/menus/{id}")
    public MenuDTO getMenuById(@PathVariable(name="id") Long menuId) {
        return menuService.getMenuById(menuId);
    }
    
    @PostMapping("/menus")
    public MenuDTO saveMenu(@RequestBody MenuDTO menuDTO){
        return menuService.saveMenu(menuDTO);
    }
}
