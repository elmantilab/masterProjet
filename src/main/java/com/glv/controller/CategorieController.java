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
import java.util.ArrayList;

@Controller
@RequestMapping("/categories")
public class CategorieController {

    private List<Categorie> categories = new ArrayList<>();
    @Autowired
    private CategorieService categorieService;

    @RequestMapping("categorielist.json")
    public @ResponseBody
    List<Categorie> getCategoriesList() {
        System.out.println("  " + categories.size());
        if (categories.isEmpty()) {
            categories = categorieService.findAll();
            System.out.println(" n'est pas vide " + categories.size());
        } else {
            System.out.println("est vide " + categories.size());
        }

        return categories;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    void addCategorie(@RequestBody Categorie categorie) {
        System.out.println("categorie " + categorie);
        categorieService.create(categorie);
        categories.add(categorie);

    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public @ResponseBody
    void updateCategorie( @RequestBody int index) {

//        categorieService.edit(categorie);
//        categories.set(index, categorie);
        System.out.println("Categorie before " + index );
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void removeCategorie(@PathVariable("id") Long id) {
        Categorie cat = categorieService.findByID(id);
        categorieService.remove(cat);
        categories.remove(cat);
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
