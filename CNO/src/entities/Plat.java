/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ASUS
 */
public class Plat {
    int id,poids,sodium,cholesterol,carbohydrate,protein,calories;
    String nom;

    public Plat() {
    }

    
    public Plat(int poids, int sodium, int cholesterol, int carbohydrate, int protein, int calories, String nom) {
        this.poids = poids;
        this.sodium = sodium;
        this.cholesterol = cholesterol;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.calories = calories;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Plat{" + "id=" + id + ", poids=" + poids + ", sodium=" + sodium + ", cholesterol=" + cholesterol + ", carbohydrate=" + carbohydrate + ", protein=" + protein + ", calories=" + calories + ", nom=" + nom + '}';
    }
    
}
