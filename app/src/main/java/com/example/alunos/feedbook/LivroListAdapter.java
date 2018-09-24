package com.example.alunos.feedbook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.List;

public class LivroListAdapter extends RecyclerView.Adapter<LivroListAdapter>.ListViewHolder{

    class LivroViewHolder extends RecyclerView.ViewHolder{

        private EditText titulo_entrada;
        private EditText numero_entrada;
        private EditText epigrafe_entrada;
        private EditText resumo_entrada;
        private EditText comentario_entrada;
        private EditText nota_entrada;

        private LivroViewHolder(View v){
            super(v);
            titulo_entrada = v.findViewById(R.id.titulo_entrada);
            numero_entrada = v.findViewById(R.id.numero_entrada);
            epigrafe_entrada= v.findViewById(R.id.epigrafe_entrada);
            resumo_entrada= v.findViewById(R.id.resumo_entrada);
            comentario_entrada = v.findViewById(R.id.comentario_entrada);
            nota_entrada= v.findViewById(R.id.nota_entrada);
        }
    }

    private final LayoutInflater inflater;
    private List<Livro> lisaLivros;

    LivroListAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }

    @Override
    @NonNull
    public LivroViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View v = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new LivroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LivroViewHolder holder, int position) {
        if (lisaLivros != null) {
            Livro current = lisaLivros.get(position);
            holder.titulo_entrada.setText(current.getTitulo());
            holder.numero_entrada.setText(current.getNumero());
            holder.epigrafe_entrada.setText(current.getEpigrafe());
            holder.resumo_entrada.setText(current.getResumo());
            holder.comentario_entrada.setText(current.getComentario());
            holder.nota_entrada.setText(current.getNota());
        } else {
            holder.titulo_entrada.setText("Sem dados");
            holder.numero_entrada.setText("Sem dados");
            holder.epigrafe_entrada.setText("Sem dados");
            holder.resumo_entrada.setText("Sem dados");
            holder.comentario_entrada.setText("Sem dados");
            holder.nota_entrada.setText("Sem dados");
        }
    }

    void setWords(List<Livro> livros){
        lisaLivros = livros;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        if(lisaLivros != null)
            return lisaLivros.size();
        else
            return 0;
        }

    }


