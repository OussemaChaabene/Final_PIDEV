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
public class publication {
       
    private int id;
    private String nom;
    private String description;
    private String image;
    private String adresse;
    private Date datecreation;
    
     public publication() {
        
    }

    public publication(int id, String nom, String description, String image, String adresse, Date datecreation) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.adresse = adresse;
        this.datecreation = datecreation;
    }
     
     
       public publication( String nom, String description, String image, String adresse, Date datecreation) {
        this.nom = nom;
        this.description = description;
        this.image = image;
        this.adresse = adresse;
        this.datecreation = datecreation;
    }
     
     
     public publication( String nom, String description,  String adresse) {
        this.nom = nom;
        this.description = description;
        
        this.adresse = adresse;
        
    }
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    
}
