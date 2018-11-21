package br.com.aula1.Repository;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import br.com.aula1.Database.AppDatabase;
import br.com.aula1.Model.Editora;

public class EditoraRepository {
    private Context context;

    public EditoraRepository(Context context) {
        this.context = context;
    }

    public boolean salvar(Editora editora){
        try{
            return new Salvar().execute(editora).get();
        }catch (Exception e){
            Log.e("ERRO SALVAR EDITORA", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Editora> listarTodos(){
        try{
            return new ListarTodos().execute().get();
        }catch (Exception e){
            Log.e("ERRO SALVAR EDITORA", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private class Salvar extends AsyncTask <Editora, Void, Boolean>{

        @Override
        protected Boolean doInBackground(Editora... editoras) {

            try{
                AppDatabase.getAppDatabase(context).editoraDao().salvar(editoras[0]);
                return true;
            }catch (Exception e){
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return false;
            }
        }

    }

    private class ListarTodos extends AsyncTask <Void, Void, List<Editora>>{

        @Override
        protected List<Editora> doInBackground(Void... voids) {
            try{
                return AppDatabase.getAppDatabase(context).editoraDao().getAll();
            }catch (Exception e){
                Log.e("ERRO ASYNC EDITORA", e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
    }
}
