package com.example.alunos.feedbook;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.alunos.feedbook.LivroRepository;

import java.util.List;

public class LivroViewModel extends AndroidViewModel{
    private LivroRepository repository;
    private LiveData<List<Livro>> listaLivros;

    public LivroViewModel(@NonNull Application application){
        super(application);
        repository = new LivroRepository(application);
        listaLivros = repository.getAllLivros();
    }

    public LiveData<List<Livro>> getListaLivros() {
        return repository.getAllLivros();
    }

    void insert(Livro livro){
        repository.insert(livro);
    }
}
