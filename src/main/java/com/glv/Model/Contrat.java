/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glv.Model;

import java.io.Serializable;
 
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author yftaich
 */
@Entity
public class Contrat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDate")
//    @NotNull
//    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name = "Date_Debut", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut;
    //@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDate")
//    @NotNull
//    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name = "Date_Fin", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datefin;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date dateDebut;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datefin;
    private float prixJour;
    @Column(name = "Date_Contrat", nullable = false)
//    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateContrat;

    private Client client;
    @OneToMany
    private List<Vehicule> vehicules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public float getPrixJour() {
        return prixJour;
    }

    public void setPrixJour(float prixJour) {
        this.prixJour = prixJour;
    }

    public Date getDateContrat() {
        return dateContrat;
    }

    public void setDateContrat(Date dateContrat) {
        this.dateContrat = dateContrat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.dateDebut);
        hash = 97 * hash + Objects.hashCode(this.datefin);
        hash = 97 * hash + Float.floatToIntBits(this.prixJour);
        hash = 97 * hash + Objects.hashCode(this.dateContrat);
        hash = 97 * hash + Objects.hashCode(this.client);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contrat other = (Contrat) obj;
        if (Float.floatToIntBits(this.prixJour) != Float.floatToIntBits(other.prixJour)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        if (!Objects.equals(this.datefin, other.datefin)) {
            return false;
        }
        if (!Objects.equals(this.dateContrat, other.dateContrat)) {
            return false;
        }
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contrat{" + "id=" + id + ", dateDebut=" + dateDebut + ", datefin=" + datefin + ", prixJour=" + prixJour + ", dateContrat=" + dateContrat + ", client=" + client + '}';
    }

}
