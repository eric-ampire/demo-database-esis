package org.esisalama.org.database.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Etudiant {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String nom;
    public String matricule;
    public int idPromotion;

    public Etudiant(
        int id,
        String nom,
        String matricule,
        int idPromo
    ) {
        this.id = id;
        this.nom = nom;
        this.matricule = matricule;
        this.idPromotion = idPromo;
    }

    public Etudiant() {}
}
