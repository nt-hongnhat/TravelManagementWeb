package com.lth.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model,
                        @RequestParam(required = false) Map<String, String> params) {
        return "admin.index";
    }
}
