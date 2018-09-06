package com.example.alunos.feedbook.dominio.cruds;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.alunos.feedbook.dominio.tabelas.Livro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Crud_livro {

    private SQLiteDatabase conexao;

    public Crud_livro(SQLiteDatabase conexao) {
        this.conexao = conexao;
    }

    public void inserir(Livro livro) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", livro.nome);
        contentValues.put("numero", livro.autor);
        try {

            conexao.insert("Livro", null, contentValues);

            Toast.makeText(this, "Inserido com sucesso !", Toast.LENGTH_LONG).show();

        } catch (SQLException ex) {

            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            msg.setTitle("ⓘ");
            msg.setMessage("Erro ao inserir no banco de dados!");
            msg.setNeutralButton("Ok", null);
            msg.show();
        }
    }

    public void excluir(int id) {
        String[] alterar = new String[1];
        alterar[0] = String.valueOf(id);

        try {
            conexao.delete("Livro", "id = ?", alterar);

            Toast.makeText(this, "Deletado com sucesso !", Toast.LENGTH_LONG).show();

        } catch (SQLException ex) {
            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            msg.setTitle("ⓘ");
            msg.setMessage("Erro ao deletar no banco de dados!");
            msg.setNeutralButton("Ok", null);
            msg.show();
        }
    }

    public void alterar(Livro livro) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", livro.nome);
        contentValues.put("numero", livro.autor);

        String[] alterar = new String[1];
        alterar[0] = String.valueOf(livro.id);

        try {
            conexao.update("Titulo", contentValues, "id = ?", alterar);

            Toast.makeText(this, "Atualizado com sucesso !", Toast.LENGTH_LONG).show();

        } catch (SQLException ex) {
            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            msg.setTitle("ⓘ");
            msg.setMessage("Erro ao atualizar o banco de dados!");
            msg.setNeutralButton("Ok", null);
            msg.show();
        }

    }

    public List<Livro> buscarTodos() {
        List<Livro> livros = new ArrayList<Livro>();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT nome, autor");
        sql.append("FROM Livro");

        Cursor resultado = conexao.rawQuery(sql.toString(), null);

        if (resultado.getCount() > 0) {

            resultado.moveToFirst();

            do {

                Livro livro = new Livro();

                livro.id = resultado.getInt(resultado.getColumnIndexOrThrow("id"));
                livro.nome= resultado.getString(resultado.getColumnIndexOrThrow("nome"));
                livro.autor= resultado.getString(resultado.getColumnIndexOrThrow("autor"));

                livros.add(livro);

            } while (resultado.moveToNext());
        }
    }

    public Livro buscarLivro(int id) {

        Livro livro = new Livro();

        StringBuilder sql = new StringBuilder();

        sql.append("SELECT nome, autor");
        sql.append("FROM Livro");
        sql.append("WHERE id = ? ");

        String[] buscar = new String[1];
        buscar[0] = String.valueOf(id);

        Cursor resultado = conexao.rawQuery(sql.toString(), buscar);

        if (resultado.getCount() > 0) {

            resultado.moveToFirst();


            livro.id = resultado.getInt(resultado.getColumnIndexOrThrow("id"));
            livro.nome = resultado.getString(resultado.getColumnIndexOrThrow("nome"));
            livro.autor = resultado.getString(resultado.getColumnIndexOrThrow("autor"));

        }

        return livro;
    }
}
