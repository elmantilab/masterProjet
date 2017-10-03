/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glv.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author nelmoudden
 */
@Entity
class Profil implements Serializable {

    public Profil() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @Column(length = 50)
    private String Fonction;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFonction() {
        return Fonction;
    }

    public void setFonction(String Fonction) {
        this.Fonction = Fonction;
    }

    @Override
    public String toString() {
        return "Profil{" + "Id=" + Id + ", Fonction=" + Fonction + '}';
    }
    
}
