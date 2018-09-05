package com.example.alunos.feedbook;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.alunos.feedbook.database.Database;

public class Feedbook extends AppCompatActivity {
    private FloatingActionButton cadastro;
    private RecyclerView lista;
    private SQLiteDatabase conexão;
    private Database dados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbook);

        cadastro = (FloatingActionButton) findViewById(R.id.cadastro);
    }

    public void cadastrar(View view){


        Intent intent = new Intent(Feedbook.this, Cadastrar.class);

        startActivity(intent);
    }

    private void Conectar(){

        try{

            dados = new Database(this);
            conexão = dados.getWritableDatabase();

            Toast.makeText(this, "Conexão criada com sucesso", Toast.LENGTH_SHORT).show();


        }catch(SQLException ex){

            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            msg.setTitle("ⓘ");
            msg.setMessage("Erro ao conectar ao banco de dados!");
            msg.setNeutralButton("Ok", null);
            msg.show();

        }
    }
}
