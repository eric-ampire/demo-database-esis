package org.esisalama.org.database.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import org.esisalama.org.database.database.entity.EtudiantPromotion;
import org.esisalama.org.database.database.entity.Promotion;

import java.util.List;

@Dao
public interface PromotionDao {

    @Insert
    void insert(Promotion promotion);

    @Query("SELECT * FROM Promotion")
    List<Promotion> findAll();

    @Transaction
    @Query("SELECT * FROM Promotion")
    List<EtudiantPromotion> findPromotionAndEtudian();
}
