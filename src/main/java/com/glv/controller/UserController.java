package com.glv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.glv.Model.User;
//import com.glv.service.UserService;
//import com.glv.service.UserServiceImpl;
import java.util.ArrayList;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/layout")
    public String getCategoriePartialPage(ModelMap modelMap) {
        return "User/layout";
    }
}
