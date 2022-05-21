package com.mm.mmcar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 茂茂
 * @create 2022-05-18 17:46
 */
@Controller
@RequestMapping(value = "/main")
public class MainController {

    @RequestMapping(value = "/order")
    public String order() {
        return "admin/order";
    }

    @RequestMapping(value = "/bulletin")
    public String notice() {
        return "admin/bulletin";
    }

    @RequestMapping(value = "/quit")
    public String quit(HttpSession session) {
        session.removeAttribute("token");
        return "index";
    }

}
