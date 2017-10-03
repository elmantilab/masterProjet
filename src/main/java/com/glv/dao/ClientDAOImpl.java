package com.glv.dao;

import com.glv.Model.Client;
import com.glv.dao.AbstractDAO;
import com.glv.dao.ClientDAO;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA. User: xvitcoder Date: 12/20/12 Time: 11:14 PM
 */
@Repository("clientDAO")
public class ClientDAOImpl extends AbstractDAO<Client> implements ClientDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public ClientDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
