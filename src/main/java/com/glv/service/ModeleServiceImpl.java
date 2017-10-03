package com.glv.service;

import com.glv.Model.Marque;
import com.glv.Model.Modele;
import com.glv.dao.ModeleDAO;
import com.glv.service.ModeleService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA. User: xvitcoder Date: 12/20/12 Time: 11:14 PM
 */
@Service("ModeleService")
public class ModeleServiceImpl implements ModeleService {

    //@Autowired
    private ModeleDAO dao;

    @Override
    public void create(Modele entityClass) {
        dao.create(entityClass);

    }

    @Override
    public void edit(Modele entityClass) {
        dao.edit(entityClass); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Modele entityClass) {
        dao.remove(entityClass);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Modele findByID(Object id) {
        return dao.findByID(id);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Modele> findAll() {
        return dao.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

}
