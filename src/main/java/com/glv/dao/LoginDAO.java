/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glv.dao;

import com.glv.Model.UserInfo;
import java.util.List;

/**
 *
 * @author nelmoudden
 */
public interface LoginDAO {
    public UserInfo findUserInfo(String username);
    public List<String> getUserRoles username);
}
