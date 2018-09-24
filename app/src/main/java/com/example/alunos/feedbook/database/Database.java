import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.alunos.feedbook.Livro;
import com.example.alunos.feedbook.LivroSQL;

@Database(entities = {Livro.class}, version = 1)
public abstract class Database extends RoomDatabase{
    public abstract LivroSQL livroSQL();

    private static Database INSTANCE;

    public static Database getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (Database.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Database.class, "database").build();
                }
            }
        }
        return INSTANCE;
    }
}