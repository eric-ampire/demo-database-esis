package org.esisalama.org.database.database;


import androidx.room.Database;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.room.RoomDatabase;

import org.esisalama.org.database.database.dao.EtudiantDao;
import org.esisalama.org.database.database.dao.PromotionDao;
import org.esisalama.org.database.database.dao.UserDao;
import org.esisalama.org.database.database.entity.Etudiant;
import org.esisalama.org.database.database.entity.EtudiantPromotion;
import org.esisalama.org.database.database.entity.Promotion;
import org.esisalama.org.database.database.entity.User;

import java.util.ArrayList;
import java.util.List;

@Entity
class UserEntity {
    @PrimaryKey int id;
    String login;
}

class UserRepository {
    @Embedded
    UserEntity user;

    @Relation(
        parentColumn = "id",
        entityColumn = "idUser"
    )
    RepositoryEntity repository;
}

@Entity
class RepositoryEntity {
    int id;
    String nom;
    int idUser;
}

class User {
    int id;
    String login;
    List<Repository> repository;
}

class Repository {
    int id;
    String nom;
}










@Database(
    entities = {
        User.class,
        Etudiant.class,
        Promotion.class
    },
    version = 1
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract EtudiantDao etudiantDao();
    public abstract PromotionDao promotionDao();
}
class Test  {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        for (User user: users) {
            UserEntity userEntity = new UserEntity();
            userEntity.id = user.id;
            userEntity.login = user.login;

            userEntityDao.insert(userEntity);

            for (Repository repo: user.repository) {
                RepositoryEntity repositoryEntity = new RepositoryEntity();
                repositoryEntity.id = repo.id;
                repositoryEntity.nom = repo.nom;
                repositoryEntity.idUser = user.id;

                repositoryEntityDao.insert(repositoryEntity);
            }
        }
    }
}

