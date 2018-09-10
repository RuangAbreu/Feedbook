package com.example.alunos.feedbook;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.EditText;
import com.example.alunos.feedbook.dominio.cruds.Crud_capitulo;
import com.example.alunos.feedbook.dominio.cruds.Crud_livro;


public class Cadastrar extends AppCompatActivity {
    private EditText titulo_entrada;
    private EditText numero_entrada;
    private EditText epigrafe_entrada;
    private EditText resumo_entrada;
    private EditText comentario_entrada;
    //private EditText nota_entrada;

    boolean res = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titulo_entrada = (EditText)findViewById(R.id.titulo_entrada);
        numero_entrada = (EditText)findViewById(R.id.numero_entrada);
        epigrafe_entrada = (EditText)findViewById(R.id.epigrafe_entrada);
        resumo_entrada = (EditText)findViewById(R.id.comentario_entrada);
        comentario_entrada = (EditText)findViewById(R.id.comentario_entrada);
        //nota_entrada = (EditText)findViewById(R.id.nota_entrada);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cadastrar, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public void validaCampos(){
        String titulo = titulo_entrada.getText().toString();
        String numero = numero_entrada.getText().toString();
        String epigrafe = epigrafe_entrada.getText().toString();
        String resumo = resumo_entrada.getText().toString();
        String comentario = comentario_entrada.getText().toString();
        //String nota = nota_entrada.getText().toString();


        if (res = campoVazio(titulo)){

            titulo_entrada.requestFocus();

        }else if (res = campoVazio(numero)){

            numero_entrada.requestFocus();

        }else if (res = campoVazio(epigrafe)){

            epigrafe_entrada.requestFocus();

        }else if (res = campoVazio(resumo)){

            resumo_entrada.requestFocus();

        }else if (res = campoVazio(comentario)){

            comentario_entrada.requestFocus();

        }
        //else if (res = campoVazio(nota)){

            //nota_entrada.requestFocus();}

        if(res){
            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            msg.setTitle("Warning");
            msg.setMessage("Há campos inválidos ou em branco");
            msg.setNeutralButton("Ok", null);
            msg.show();
        }

    }

    private boolean campoVazio(String valor){
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }


}
