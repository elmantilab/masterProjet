package com.glv.dao;

import com.glv.Model.Telephone;
import com.glv.dao.AbstractDAO;
import com.glv.dao.TelephoneDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA. User: xvitcoder Date: 12/20/12 Time: 11:14 PM
 */
@Repository("telephoneDAO")
public class TelephoneDAOImpl extends AbstractDAO<Telephone> implements TelephoneDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public TelephoneDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
