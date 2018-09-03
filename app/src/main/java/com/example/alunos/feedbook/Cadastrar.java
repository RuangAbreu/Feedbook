package com.example.alunos.feedbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.EditText;


public class Cadastrar extends AppCompatActivity {
    private EditText titulo_entrada;
    private EditText numero_entrada;
    private EditText epigrafe_entrada;
    private EditText resumo_entrada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titulo_entrada = (EditText)findViewById(R.id.titulo_entrada);
        numero_entrada = (EditText)findViewById(R.id.numero_entrada);
        epigrafe_entrada = (EditText)findViewById(R.id.epigrafe_entrada);
        resumo_entrada = (EditText)findViewById(R.id.resumo_entrada);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cadastrar, menu);

        return super.onCreateOptionsMenu(menu);
    }


}
