/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.Date;

/**
 *
 * @author pc
 */
public class events {
private int ideven;
private Date dateeven;
private String descri;
private String nom;
private int prix;

    public int getIdeven() {
        return ideven;
    }

    public void setIdeven(int ideven) {
        this.ideven = ideven;
    }

    public Date getDateeven() {
        return dateeven;
    }

    public void setDateeven(Date dateeven) {
        this.dateeven = dateeven;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "events{" + "ideven=" + ideven + ", dateeven=" + dateeven + ", descri=" + descri + ", nom=" + nom + ", prix=" + prix + '}';
    }

}