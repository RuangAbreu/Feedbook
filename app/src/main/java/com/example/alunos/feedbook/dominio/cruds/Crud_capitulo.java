package com.example.alunos.feedbook.dominio.cruds;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.alunos.feedbook.Cadastrar;
import com.example.alunos.feedbook.dominio.tabelas.Capitulo;

import java.sql.SQLData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class Crud_capitulo {

    private SQLiteDatabase conexao;

    public Crud_capitulo(SQLiteDatabase conexao) {
        this.conexao = conexao;
    }

    public void inserir(Capitulo capitulo) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", capitulo.titulo);
        contentValues.put("numero", capitulo.numero);
        contentValues.put("epigrafe", capitulo.epigrafe);
        contentValues.put("resumo", capitulo.resumo);
        contentValues.put("comentario", capitulo.comentario);
        contentValues.put("nota", capitulo.nota);

            conexao.insertOrThrow("Capitulo", null, contentValues);


    }

    public void excluir(int id) {
        String[] alterar = new String[1];
        alterar[0] = String.valueOf(id);


            conexao.delete("Capitulo", "id = ?", alterar);

    }

    public void alterar(Capitulo capitulo) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", capitulo.titulo);
        contentValues.put("numero", capitulo.numero);
        contentValues.put("epigrafe", capitulo.epigrafe);
        contentValues.put("resumo", capitulo.resumo);
        contentValues.put("comentario", capitulo.comentario);
        contentValues.put("nota", capitulo.nota);

        String[] alterar = new String[1];
        alterar[0] = String.valueOf(capitulo.id);


            conexao.update("Capitulo", contentValues, "id = ?", alterar);



    }

    public List<Capitulo> buscarTodos() {
        List<Capitulo> capitulos = new ArrayList<Capitulo>();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT titulo, numero");
        sql.append("FROM Capitulo");

        Cursor resultado = conexao.rawQuery(sql.toString(), null);

        if (resultado.getCount() > 0) {

            resultado.moveToFirst();

            do {

                Capitulo cap = new Capitulo();

                cap.id = resultado.getInt(resultado.getColumnIndexOrThrow("id"));
                cap.titulo = resultado.getString(resultado.getColumnIndexOrThrow("titulo"));
                cap.numero = resultado.getInt(resultado.getColumnIndexOrThrow("numero"));
                cap.epigrafe = resultado.getString(resultado.getColumnIndexOrThrow("epigrafe"));
                cap.resumo = resultado.getString(resultado.getColumnIndexOrThrow("resumo"));
                cap.comentario = resultado.getString(resultado.getColumnIndexOrThrow("comentario"));
                cap.nota = resultado.getInt(resultado.getColumnIndexOrThrow("nota"));

                capitulos.add(cap);

            } while (resultado.moveToNext());
        }
        return  capitulos;
    }

    public Capitulo buscarCapitulo(int id) {

        Capitulo cap= new Capitulo();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT titulo, numero");
        sql.append("FROM Capitulo");
        sql.append("WHERE id = ? ");

        String[] buscar = new String[1];
        buscar[0] = String.valueOf(id);

        Cursor resultado = conexao.rawQuery(sql.toString(), buscar);

        if (resultado.getCount() > 0) {

            resultado.moveToFirst();


            cap.id = resultado.getInt(resultado.getColumnIndexOrThrow("id"));
            cap.titulo = resultado.getString(resultado.getColumnIndexOrThrow("titulo"));
            cap.numero = resultado.getInt(resultado.getColumnIndexOrThrow("numero"));
            cap.epigrafe = resultado.getString(resultado.getColumnIndexOrThrow("epigrafe"));
            cap.resumo = resultado.getString(resultado.getColumnIndexOrThrow("resumo"));
            cap.comentario = resultado.getString(resultado.getColumnIndexOrThrow("comentario"));
            cap.nota = resultado.getInt(resultado.getColumnIndexOrThrow("nota"));


        }

        return cap;
    }
}