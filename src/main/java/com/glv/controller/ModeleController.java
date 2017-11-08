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

import com.glv.Model.Modele;
import com.glv.service.ModeleService;
import com.glv.service.ModeleServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Modele")
public class ModeleController {

    private List<Modele> modeles = new ArrayList<>();
    @Autowired
    private ModeleService modeleService;

    @RequestMapping("modelelist.json")
    public @ResponseBody
    List<Modele> getModelesList() {
        System.out.println("  " + modeles.size());
        if (modeles.isEmpty()) {
            modeles = modeleService.findAll();
            System.out.println(" n'est pas vide " + modeles.size());
        } else {
            System.out.println("est vide " + modeles.size());
        }

        return modeles;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    void addModele(@RequestBody Modele modele) {
        System.out.println("modele " + modele);
        modeleService.create(modele);
        modeles.add(modele);

    }

    @RequestMapping(value = "/update/{index}", method = RequestMethod.PUT)
    public @ResponseBody
    void updateModele(@RequestBody Modele modele, @PathVariable("index") int index) {

//        for (Map.Entry<Integer, Modele> entry : map.entrySet()) {
//            int index = entry.getKey();
//            Modele modele = entry.getValue();
        modeleService.edit(modele);
        modeles.set(index, modele);
        System.out.println("Modele before " + modeleService);
        System.out.println(" modeles "+modeles.get(index));
        // do something with key and/or tab
//        }

    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void removeModele(@PathVariable("id") Long id) {
        Modele cat = modeleService.findByID(id);
        modeleService.remove(cat);
        modeles.remove(cat);
    }

//    @RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
//    public @ResponseBody void removeAllModeles() {
//        modeleService.deleteAll();
//    }
    @RequestMapping("/layout")
    public String getModelePartialPage(ModelMap modelMap) {
        return "Modele/layout";
    }

    class mapModele {

        private Modele cat;
        private int index;
    }
}
