package org.esisalama.org.database.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import org.esisalama.org.database.database.entity.Etudiant;

@Dao
public interface EtudiantDao {

    @Insert
    void insert(Etudiant etudiant);
}
