package com.example.alunos.feedbook;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Feedbook extends AppCompatActivity {
    private FloatingActionButton cadastro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbook);

        cadastro = (FloatingActionButton) findViewById(R.id.cadastro);
    }

    public void cadastrar(View view){
        Intent intent = new Intent(Feedbook.this, Cadastrar.class);
    }
}
