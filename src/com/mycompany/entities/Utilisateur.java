/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author rayan
 */
public class Utilisateur {
     private int idUser ;  
    private String nom ;
    private String prenom ;
    private String email ;
    private String mdp ;
    private int numero ;
    private String adresse ;
    private int age ;
    private  String image  ;

    public Utilisateur() {
    }

    public Utilisateur(int idUser, String nom, String prenom, String email, String mdp, int numero, String adresse, int age, String image) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.numero = numero;
        this.adresse = adresse;
        this.age = age;
        this.image = image;
    }

    public Utilisateur(String nom, String prenom, String email, String mdp, int numero) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.numero = numero;
    }
    

    public int getId_user() {
        return idUser;
    }

    public void setId_user(int idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
}
