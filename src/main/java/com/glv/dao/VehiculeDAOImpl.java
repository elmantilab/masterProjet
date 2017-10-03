package com.glv.dao;

import com.glv.Model.Vehicule;
import com.glv.dao.AbstractDAO;
import com.glv.dao.VehiculeDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA. User: xvitcoder Date: 12/20/12 Time: 11:14 PM
 */
@Repository("vehiculeDAO")
public class VehiculeDAOImpl extends AbstractDAO<Vehicule> implements VehiculeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public VehiculeDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
