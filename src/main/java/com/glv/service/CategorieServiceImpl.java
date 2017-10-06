package com.glv.service;

import com.glv.Model.Categorie;
import com.glv.dao.CategorieDAO;
import com.glv.service.CategorieService;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA. User: xvitcoder Date: 12/20/12 Time: 11:14 PM
 */
@Service("categorieService")
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    private CategorieDAO dao;

    @Override
    @Transactional
    public void create(Categorie entityClass) {
        System.out.println(" entityClass " + entityClass);
        dao.create(entityClass);

    }
    

    @Override
    @Transactional
    public void edit(Categorie entityClass) {
        dao.edit(entityClass); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public void remove(Categorie entityClass) {
        dao.remove(entityClass);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Categorie> findAll() {
        return dao.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Categorie findByID(Object id) {
        return dao.findByID(id);//To change body of generated methods, choose Tools | Templates.
    }

}
