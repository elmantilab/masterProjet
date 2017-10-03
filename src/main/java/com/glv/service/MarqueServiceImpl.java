package com.glv.service;

import com.glv.Model.Marque;
import com.glv.dao.MarqueDAO;
import org.springframework.stereotype.Service;
import com.glv.service.MarqueService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA. User: xvitcoder Date: 12/20/12 Time: 11:14 PM
 */
@Service("MarqueService")
public class MarqueServiceImpl implements MarqueService {

    //@Autowired
    private MarqueDAO dao;
    
    @Override
    public void create(Marque entityClass) {
        dao.create(entityClass);
        
    }
    
    @Override
    public void edit(Marque entityClass) {
        dao.edit(entityClass); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void remove(Marque entityClass) {
        dao.remove(entityClass);//To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Marque> findAll() {
        return dao.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Marque findByID(Object id) {
        return dao.findByID(id) ;//To change body of generated methods, choose Tools | Templates.
    }
    
}
