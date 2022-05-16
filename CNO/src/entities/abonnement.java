/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author MSI
 */
public class abonnement {
     private int id,ab_prix;
    private String ab_nom,ab_type;

    public int getId() {
        return id;
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAb_prix() {
        return ab_prix;
    }

    public void setAb_prix(int ab_prix) {
        this.ab_prix = ab_prix;
    }

    public String getAb_nom() {
        return ab_nom;
    }

    public void setAb_nom(String ab_nom) {
        this.ab_nom = ab_nom;
    }

    public String getAb_type() {
        return ab_type;
    }

    public void setAb_type(String ab_type) {
        this.ab_type = ab_type;
    }

    public abonnement() {
    }

    public abonnement( int ab_prix, String ab_nom, String ab_type) {
        
        this.ab_prix = ab_prix;
        this.ab_nom = ab_nom;
        this.ab_type = ab_type;
    }
     public abonnement(int id, int ab_prix, String ab_nom, String ab_type) {
        this.id = id;
        this.ab_prix = ab_prix;
        this.ab_nom = ab_nom;
        this.ab_type = ab_type;
    }
    
}
