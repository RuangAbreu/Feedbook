package com.example.alunos.feedbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }
}
