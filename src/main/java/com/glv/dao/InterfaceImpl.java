/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glv.dao;

import java.util.List;

/**
 *
 * @author yftaich
 */
public  interface InterfaceImpl<T> {

    public void create(T entityClass);

    public void edit(T entityClass);

    public void remove(T entityClass);

    T findByID(Object id);

    List< T> findAll();

//    List< T> findRange(int[] range);
//
//    int count();
}
