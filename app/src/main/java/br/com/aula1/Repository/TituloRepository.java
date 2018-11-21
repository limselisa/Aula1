package br.com.aula1.Repository;

import android.content.Context;

import br.com.aula1.Model.Titulo;

public class TituloRepository {

    private Context context;

    public TituloRepository(Context context) {
        this.context = context;
    }


    public boolean salvar(Titulo titulo){
        return true;
    }

}
