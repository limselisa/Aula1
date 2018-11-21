package br.com.aula1.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Volumes",
        foreignKeys = {@ForeignKey(parentColumns = "id", entity = Titulo.class, childColumns = "id_titulo")},
        indices = {@Index(value = "id", unique = true), @Index(value = "id_titulo")})
public class Volume {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private long id;

    @NonNull
    private int num;

    @NonNull
    private String nomeDoVolume;

    @NonNull
    @ColumnInfo(name = "id_titulo")
    private long id_titulo;

    public Volume() {
    }

    @Ignore
    public Volume(@NonNull int num, @NonNull String nomeDoVolume, @NonNull long id_titulo) {
        this.num = num;
        this.nomeDoVolume = nomeDoVolume;
        this.id_titulo = id_titulo;
    }

    @NonNull
    public long getId() {
        return id;
    }

    public void setId(@NonNull long id) {
        this.id = id;
    }

    @NonNull
    public int getNum() {
        return num;
    }

    public void setNum(@NonNull int num) {
        this.num = num;
    }

    @NonNull
    public String getNomeDoVolume() {
        return nomeDoVolume;
    }

    public void setNomeDoVolume(@NonNull String nomeDoVolume) {
        this.nomeDoVolume = nomeDoVolume;
    }

    @NonNull
    public long getId_titulo() {
        return id_titulo;
    }

    public void setId_titulo(@NonNull long id_titulo) {
        this.id_titulo = id_titulo;
    }

    @Override
    public String toString() {
        return "Volume{" +
                "id=" + id +
                ", num=" + num +
                ", nomeDoVolume='" + nomeDoVolume + '\'' +
                ", id_titulo=" + id_titulo +
                '}';
    }
}
