package com.example.alunos.feedbook;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface LivroSQL {
    @Insert
    void Insert(Livro livro);
    @Query("SELECT * FROM Livro ORDER BY titulo ASC")
    LiveData<List<Livro>> getAllLivros();
}
