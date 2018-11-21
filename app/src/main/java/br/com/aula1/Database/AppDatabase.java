package br.com.aula1.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import br.com.aula1.Dao.EditoraDao;
import br.com.aula1.Model.Editora;
import br.com.aula1.Model.Titulo;
import br.com.aula1.Model.Volume;

@Database(entities = {Editora.class, Titulo.class, Volume.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EditoraDao editoraDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "livroapp")
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}

