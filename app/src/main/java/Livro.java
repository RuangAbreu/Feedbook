import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Livro {
    @PrimaryKey(autoGenerate = true)
    @NonNull

    private String titulo;
    private String numero;
    private String epigrafe;
    private String resumo;
    private int id;

    public Livro(@NonNull String titulo, @NonNull String numero, @NonNull String epigrafe, @NonNull int id, @NonNull String resumo){
    this.titulo = titulo;
        this.numero = numero;
        this.epigrafe = epigrafe;
        this.resumo =  resumo;
        this.id = id;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getNumero(){
        return numero;
    }
    public String getEpigrafe(){
        return epigrafe;
    }
    public String getResumo(){
        return resumo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
}