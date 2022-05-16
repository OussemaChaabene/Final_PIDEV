/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.util.Date;

/**
 *
 * @author mayro
 */
public class Seance {
    private int id_seance;
    private Date date;
    private String typeseance;

    public Seance(int id_seance, Date date, String typeseance) {
        this.id_seance = id_seance;
        this.date = date;
        this.typeseance = typeseance;
    }

    public Seance(Date date, String typeseance) {
        this.date = date;
        this.typeseance = typeseance;
    }

    public Seance() {
        
    }

    public int getId_seance() {
        return id_seance;
    }

    public void setId_seance(int id_seance) {
        this.id_seance = id_seance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTypeseance() {
        return typeseance;
    }

    public void setTypeseance(String typeseance) {
        this.typeseance = typeseance;
    }

    @Override
    public String toString() {
        return "Seance{" + "id_seance=" + id_seance + ", date=" + date + ", typeseance=" + typeseance + '}';
    }
    
    
}
