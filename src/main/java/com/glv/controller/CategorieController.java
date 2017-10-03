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

import com.glv.Model.Categorie;
import com.glv.service.CategorieService;
import com.glv.service.CategorieServiceImpl;

@Controller
@RequestMapping("/categories")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @RequestMapping("categorielist.json")
    public @ResponseBody
    List<Categorie> getCategoriesList() {

        List<Categorie> categories = categorieService.findAll();
        System.out.println("categories " + categories.size());
        return categorieService.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    void addCategorie(@RequestBody Categorie categorie) {
        System.out.println("categorie " + categorie);
        categorieService.create(categorie);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    void updateCategorie(@RequestBody Categorie categorie) {
        categorieService.edit(categorie);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void removeCategorie(@PathVariable("id") Long id) {

        categorieService.remove(categorieService.findByID(id));
    }

//    @RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
//    public @ResponseBody void removeAllCategories() {
//        categorieService.deleteAll();
//    }
    @RequestMapping("/layout")
    public String getCategoriePartialPage(ModelMap modelMap) {
        return "categories/layout";
    }
}
