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
public class CaracSport {
    private int id,taille,poids,prtoNeeds,calorieNeed,age;
    private String genre;

    public CaracSport(int id, int taille, int poids, int prtoNeeds, int calorieNeed, int age, String genre) {
        this.id = id;
        this.taille = taille;
        this.poids = poids;
        this.prtoNeeds = prtoNeeds;
        this.calorieNeed = calorieNeed;
        this.age = age;
        this.genre = genre;
    }
    public CaracSport( int taille, int poids, int age, String genre) {
        this.taille = taille;
        this.poids = poids;
        this.age = age;
        this.genre = genre;
    }
    
    public CaracSport( int taille, int poids, int age) {
        this.taille = taille;
        this.poids = poids;
        this.age = age;
    
    }

    public CaracSport() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getPrtoNeeds() {
        return prtoNeeds;
    }

    public void setPrtoNeeds(int prtoNeeds) {
        this.prtoNeeds = prtoNeeds;
    }

    public int getCalorieNeed() {
        return calorieNeed;
    }

    public void setCalorieNeed(int calorieNeed) {
        this.calorieNeed = calorieNeed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "CaracSport{" + "taille=" + taille + ", poids=" + poids + ", prtoNeeds=" + prtoNeeds + ", calorieNeed=" + calorieNeed + ", age=" + age + ", genre=" + genre + '}';
    }
    
}
