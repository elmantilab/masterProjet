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
import com.glv.Model.Marque;
import com.glv.service.MarqueService;
import java.util.ArrayList;

@Controller
@RequestMapping("/Marque") 
public class MarqueController {

    private List<Marque> marques = new ArrayList<>();
    @Autowired
    private MarqueService marqueService;

    @RequestMapping("Marquelist.json")
    public @ResponseBody
    List<Marque> getMarquesList() {
        System.out.println("  " + marques.size());
        if (marques.isEmpty()) {
            marques = marqueService.findAll();
            System.out.println(" n'est pas vide " + marques.size());
        } else {
            System.out.println("est vide " + marques.size());
        }

        return marques;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    void addMarque(@RequestBody Marque marque) {
        System.out.println("marque " + marque);
        marqueService.create(marque);
        marques.add(marque);

    }

    @RequestMapping(value = "/update/{index}", method = RequestMethod.PUT)
    public @ResponseBody
    void updateMarque(@RequestBody Marque marque, @PathVariable("index") int index) {

//        for (Map.Entry<Integer, Marque> entry : map.entrySet()) {
//            int index = entry.getKey();
//            Marque marque = entry.getValue();
        marqueService.edit(marque);
        marques.set(index, marque);
        System.out.println("Marque before " + marqueService);
        System.out.println(" marques " + marques.get(index));
        // do something with key and/or tab
//        }

    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void removeMarque(@PathVariable("id") Long id) {
        Marque cat = marqueService.findByID(id);
        marqueService.remove(cat);
        marques.remove(cat);
    }

//    @RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
//    public @ResponseBody void removeAllMarques() {
//        marqueService.deleteAll();
//    }
    @RequestMapping("/layout")
    public String getMarquePartialPage(ModelMap modelMap) {
        return "Marque/layout";
    }

    class mapMarque {

        private Marque cat;
        private int index;
    }
}
