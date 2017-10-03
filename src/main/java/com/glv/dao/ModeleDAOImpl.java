package com.glv.dao;

import com.glv.Model.Modele;
import com.glv.dao.AbstractDAO;
import com.glv.dao.ModeleDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA. User: xvitcoder Date: 12/20/12 Time: 11:14 PM
 */
@Repository("modeleDAO")
public class ModeleDAOImpl extends AbstractDAO<Modele> implements ModeleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public ModeleDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
