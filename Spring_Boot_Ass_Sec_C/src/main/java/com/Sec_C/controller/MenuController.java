package com.Sec_C.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sec_C.model.Menuitems;

@RestController
@RequestMapping("/menu")
public class MenuController {
 
    private final List<Menuitems> menuItems = List.of(
            new Menuitems(1L, "Margherita Pizza", new BigDecimal("8.99")),
            new Menuitems(2L, "Cheeseburger", new BigDecimal("6.49")),
            new Menuitems(3L, "Caesar Salad", new BigDecimal("5.25")),
            new Menuitems(4L, "Veggie Burrito", new BigDecimal("7.75"))
    );
 
    /**
     * GET /menu
     * Returns the full hardcoded menu.
     */
    @GetMapping
    public List<Menuitems> getMenu() {
        return menuItems;
    }
}
