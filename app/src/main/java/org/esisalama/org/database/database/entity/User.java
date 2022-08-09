package org.esisalama.org.database.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class User {
    @PrimaryKey(autoGenerate = true) public int id;
    public String nom;
    public String postNom;
    public String email;
    public String matricule;

    public User(String nom, String postNom, String email, String matricule) {
        this.nom = nom;
        this.postNom = postNom;
        this.email = email;
        this.matricule = matricule;
    }
    public User(int id, String nom, String postNom, String email, String matricule) {
        this.id = id;
        this.nom = nom;
        this.postNom = postNom;
        this.email = email;
        this.matricule = matricule;
    }

    public User() {
    }
}