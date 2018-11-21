package br.com.aula1.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.aula1.Model.Editora;

@Dao
public interface EditoraDao {

    @Insert
    void salvar(Editora editora);

    @Delete
    void deletarLista(List<Editora> editoras);

    @Query("SELECT * FROM Editoras ORDER BY nome ASC")
    List<Editora> getAll();

    @Query("SELECT * FROM Editoras WHERE nome LIKE :nome ORDER BY nome ASC")
    List<Editora> pesquisa(String nome);

}
