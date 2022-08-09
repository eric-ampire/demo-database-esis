package org.esisalama.org.database.database.entity;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

import java.util.List;


public class EtudiantPromotion {
    @Embedded
    public Promotion promotion;

    @Relation(
        parentColumn = "id",
        entityColumn = "idPromotion"
    )
    public Etudiant etudiant;
}
