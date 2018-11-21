package br.com.aula1.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Titulos",
        foreignKeys = {@ForeignKey(childColumns = "id_editora", entity = Editora.class, parentColumns = "id")},
        indices = {@Index(value = "id", unique = true), @Index(value = "id_editora")})
public class Titulo {

    @NonNull
    @PrimaryKey
    private long id;

    @NonNull
    @ColumnInfo(name = "id_editora")
    private long id_editora;

    @NonNull
    private String nome;

    @NonNull
    private int numVolumes;

    @NonNull
    private String tipoDeTitulo;

    @NonNull
    private String andamentoDoTitulo;

    public Titulo() {
    }

    @Ignore
    public Titulo(@NonNull long id_editora, @NonNull String nome, @NonNull int numVolumes, @NonNull String tipoDeTitulo, @NonNull String andamentoDoTitulo) {
        this.id_editora = id_editora;
        this.nome = nome;
        this.numVolumes = numVolumes;
        this.tipoDeTitulo = tipoDeTitulo;
        this.andamentoDoTitulo = andamentoDoTitulo;
    }

    @NonNull
    public long getId() {
        return id;
    }

    public void setId(@NonNull long id) {
        this.id = id;
    }

    @NonNull
    public long getId_editora() {
        return id_editora;
    }

    public void setId_editora(@NonNull long id_editora) {
        this.id_editora = id_editora;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    @NonNull
    public int getNumVolumes() {
        return numVolumes;
    }

    public void setNumVolumes(@NonNull int numVolumes) {
        this.numVolumes = numVolumes;
    }

    @NonNull
    public String getTipoDeTitulo() {
        return tipoDeTitulo;
    }

    public void setTipoDeTitulo(@NonNull String tipoDeTitulo) {
        this.tipoDeTitulo = tipoDeTitulo;
    }

    @NonNull
    public String getAndamentoDoTitulo() {
        return andamentoDoTitulo;
    }

    public void setAndamentoDoTitulo(@NonNull String andamentoDoTitulo) {
        this.andamentoDoTitulo = andamentoDoTitulo;
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "id=" + id +
                ", id_editora=" + id_editora +
                ", nome='" + nome + '\'' +
                ", numVolumes=" + numVolumes +
                ", tipoDeTitulo='" + tipoDeTitulo + '\'' +
                ", andamentoDoTitulo='" + andamentoDoTitulo + '\'' +
                '}';
    }
}
