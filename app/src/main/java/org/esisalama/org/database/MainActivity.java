package org.esisalama.org.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.esisalama.org.database.database.AppDatabase;
import org.esisalama.org.database.database.dao.EtudiantDao;
import org.esisalama.org.database.database.dao.PromotionDao;
import org.esisalama.org.database.database.entity.Etudiant;
import org.esisalama.org.database.database.entity.EtudiantPromotion;
import org.esisalama.org.database.database.entity.Promotion;
import org.esisalama.org.database.database.entity.User;
import org.esisalama.org.database.database.dao.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edNom;
    EditText edPosnom;
    EditText edEmail;
    EditText edMatricule;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setup();
    }

    private void init() {
        edEmail = findViewById(R.id.edMail);
        edPosnom = findViewById(R.id.edPostNom);
        edMatricule = findViewById(R.id.edMatricule);
        edNom = findViewById(R.id.edNom);
        btnSave = findViewById(R.id.btnSave);
    }

    private void setup() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = edNom.getText().toString();
                String postNom = edPosnom.getText().toString();
                String matricule = edMatricule.getText().toString();
                String email = edEmail.getText().toString();

                enregistrer(nom, postNom, matricule, email);
            }
        });
    }

    private void enregistrer(
        String nom,
        String postNom,
        String matricule,
        String email
    ) {

        AppDatabase db = Room
            .databaseBuilder(this, AppDatabase.class, "db")
            .allowMainThreadQueries()
            .build();

        // Recuperer le DAO
        PromotionDao promotionDao = db.promotionDao();
        EtudiantDao etudiantDao = db.etudiantDao();

        // Request d'insertion Promotion


        db.runInTransaction(() -> {
            Promotion g2Si = new Promotion(2, "G3 SI");
            promotionDao.insert(g2Si);
        });

        //
        Etudiant etudiant1 = new Etudiant(2, "Etudiant 2", "1324", 2);
        etudiantDao.insert(etudiant1);
        List<EtudiantPromotion> data = promotionDao.findPromotionAndEtudian();
        for (EtudiantPromotion e: data) {
            Log.e("esis", e.etudiant.nom + " " + e.promotion.nom);
        }
    }
}













/*
AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name")
            .allowMainThreadQueries()
            .build();

        UserDao doa = db.userDao();
        doa.insert();
 */