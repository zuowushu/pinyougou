package com.pinyougou.shop.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * LoginController class
 *
 * @Author: lonelywind
 * @Date: 2018/12/17 20:57
 */

@RequestMapping("/login")
@RestController
public class LoginController {
    @GetMapping("/getUsername")
    public Map<String,Object> getUsername() {
        Map<String, Object> map = new HashMap<String, Object>();

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        map.put("username",username);
        return map;
    }
}
