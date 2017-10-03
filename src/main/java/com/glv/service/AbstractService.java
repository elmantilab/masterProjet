/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glv.service;

import com.glv.dao.InterfaceImpl;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.id.PersistentIdentifierGenerator.PK;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author yftaich
 * @param <T>
 */
public abstract class AbstractService<T extends Serializable, ID extends Serializable> implements InterfaceImpl<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public AbstractService() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    //protected abstract EntityManager getEntityManager();
    @Override
    public void create(T entity) {
        getSession().persist(entity);
        System.out.println(" entity " + entity);
//        getEntityManager().persist(entity);
//        getEntityManager().flush();
//        getEntityManager().refresh(entity);
    }

    @Override
    public void edit(T entity) {
        //   Session session = getEntityManager().unwrap(Session.class);

        getSession().merge(entity);
    }

    @Override
    public void remove(T entity) {
        getSession().delete(entity);//remove(getSession().merge(entity));
    }

  

    @Override
    public List<T> findAll() {
        Criteria criteria = createEntityCriteria();
        return criteria.list();

    }

 

    @SuppressWarnings("unchecked")
    public T getByKey(ID key) {
        return (T) getSession().get(entityClass, key);
    }

    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(entityClass);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
