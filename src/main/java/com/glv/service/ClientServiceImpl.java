package com.glv.service;

import com.glv.Model.Client;
import com.glv.dao.ClientDAO;
import com.glv.service.ClientService;
import java.util.List;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA. User: xvitcoder Date: 12/20/12 Time: 11:14 PM
 */
@Service("ClientService")
@Transactional
public class ClientServiceImpl implements ClientService {

    // @Autowired
    private ClientDAO dao;

    @Override
    public void create(Client entityClass) {
        dao.create(entityClass);

    }

    @Override
    public void edit(Client entityClass) {
        dao.edit(entityClass); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Client entityClass) {
        dao.remove(entityClass);//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client findByID(Object id) {
        return dao.findByID(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Client> findAll() {
        return dao.findAll();//To change body of generated methods, choose Tools | Templates.
    }

}
