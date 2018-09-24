package com.example.alunos.feedbook;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Database;
import android.os.AsyncTask;

import java.util.List;

public class LivroRepository {
    private LivroSQL livroSQL;
    private LiveData<List<Livro>> listaLivros;

    LivroRepository(Application application){
        Database db = Database.getDatabase(application);
        LivroSQL = db.livroSQL();
        listaLivros = livroSQL.getAllLivros();
    }

    LiveData<List<Livro>> getAllLivros(){
        return listaLivros;
    }

    public void insert (Livro livro){
        new insertAsyncTask(livroSQL).execute(Livro);
    }

    private static class insertAsyncTask extends AsyncTask<Livro, Void, Void>{
        private LivroSQL mAsyncTaskSQL;

        insertAsyncTask(LivroSQL sql){
            mAsyncTaskSQL = sql;
        }

        @Override
        protected Void doInBackground(final Livro... params){
            mAsyncTaskSQL.insert(params[0]);
            return null;
        }
    }
}
