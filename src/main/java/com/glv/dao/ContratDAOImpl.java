package com.glv.dao;

import com.glv.Model.Contrat;
import com.glv.dao.AbstractDAO;
import com.glv.dao.ContratDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA. User: xvitcoder Date: 12/20/12 Time: 11:14 PM
 */
@Repository("contratDAO")
public class ContratDAOImpl extends AbstractDAO<Contrat> implements ContratDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public ContratDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
