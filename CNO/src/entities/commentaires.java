/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
/**
 *
 * @author DELL
 */
public class commentaires {
    
    private int id;
    private int id_publication;
    private String nom;
    private String comment;
    private Date date_com;
    private int note;

    public commentaires() {
    }

    public commentaires(int id, int id_publication, String nom, String comment, Date date_com, int note) {
        this.id = id;
        this.id_publication = id_publication;
        this.nom = nom;
        this.comment = comment;
        this.date_com = date_com;
        this.note = note;
    }

    public commentaires(int id_publication, String nom, String comment, Date date_com, int note) {
        this.id_publication = id_publication;
        this.nom = nom;
        this.comment = comment;
        this.date_com = date_com;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public int getId_publication() {
        return id_publication;
    }

    public String getNom() {
        return nom;
    }

    public String getComment() {
        return comment;
    }

    public Date getDate_com() {
        return date_com;
    }

    public int getNote() {
        return note;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_publication(int id_publication) {
        this.id_publication = id_publication;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate_com(Date date_com) {
        this.date_com = date_com;
    }

    public void setNote(int note) {
        this.note = note;
    }

  
   
    
    
    
    
}
