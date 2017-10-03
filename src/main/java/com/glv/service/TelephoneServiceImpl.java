package com.glv.service;

import com.glv.Model.Telephone;
import com.glv.dao.TelephoneDAO;
import com.glv.service.TelephoneService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA. User: xvitcoder Date: 12/20/12 Time: 11:14 PM
 */
@Service("TelephoneService")
@Transactional
public class TelephoneServiceImpl implements TelephoneService {

   // @Autowired
    private TelephoneDAO dao;

    @Override
    public void create(Telephone entityClass) {
        dao.create(entityClass);

    }

    @Override
    public void edit(Telephone entityClass) {
        dao.edit(entityClass);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Telephone entityClass) {
        dao.remove(entityClass); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
    public Telephone findByID(Object id) {
        return dao.findByID(id);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Telephone> findAll() {
        return dao.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

   

}
