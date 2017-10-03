package com.glv.dao;

import com.glv.Model.Marque;
import com.glv.dao.AbstractDAO;
import com.glv.dao.MarqueDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA. User: xvitcoder Date: 12/20/12 Time: 11:14 PM
 */
@Repository("marqueDAO")
public class MarqueDAOImpl extends AbstractDAO<Marque> implements MarqueDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public MarqueDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
