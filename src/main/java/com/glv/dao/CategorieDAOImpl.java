package com.glv.dao;

import com.glv.Model.Categorie;
import com.glv.Model.Categorie;
import com.glv.dao.AbstractDAO;
import com.glv.dao.CategorieDAO;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA. User: xvitcoder Date: 12/20/12 Time: 11:14 PM
 */
@Repository
public class CategorieDAOImpl extends AbstractDAO<Categorie> implements CategorieDAO {

    @Autowired
    private final SessionFactory sessionFactory;

    public CategorieDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

}
