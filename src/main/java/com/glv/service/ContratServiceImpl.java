package com.glv.service;

import com.glv.Model.Contrat;

import com.glv.dao.ContratDAO;
import com.glv.service.ContratService;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA. User: xvitcoder Date: 12/20/12 Time: 11:14 PM
 */
@Service("ContratService")
@Transactional
public class ContratServiceImpl implements ContratService {

    // @Autowired
    private ContratDAO dao;

    @Override
    public void create(Contrat entityClass) {
        dao.create(entityClass);

    }

    @Override
    public void edit(Contrat entityClass) {
        dao.edit(entityClass); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Contrat entityClass) {
        dao.remove(entityClass);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contrat> findAll() {
        return dao.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contrat findByID(Object id) {
        return dao.findByID(id);//To change body of generated methods, choose Tools | Templates.
    }

}
