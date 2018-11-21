package br.com.aula1.Interface;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.aula1.Adapter.EditoraListAdapter;
import br.com.aula1.Model.Editora;
import br.com.aula1.R;
import br.com.aula1.Repository.EditoraRepository;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Editoras extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.txt_nome_pesquisa)
    EditText txt_pesquisa;

    @BindView(R.id.list_editoras)
    ListView list_editoras;

    private EditoraRepository repository;
    private List<Editora> editoras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editoras);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        repository = new EditoraRepository(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        editoras = repository.listarTodos();
        popularLista();
    }

    public void popularLista() {
        EditoraListAdapter adapter = new EditoraListAdapter(this, this, editoras);
        list_editoras.setAdapter(adapter);
    }

    private void dialogNovaEditora(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Nova editora");
        alertDialog.setMessage(R.string.hint_txt_pesquisa_editora);
        final EditText input = new EditText(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);

        alertDialog.setPositiveButton("Salvar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        String nome = input.getText().toString().trim();

                        Editora editora = new Editora();
                        editora.setNome(nome);

                        if (repository.salvar(editora)){
                            Toast.makeText(Editoras.this, "Editora salva com sucesso!", Toast.LENGTH_LONG).show();
                            editoras = repository.listarTodos();
                            popularLista();
                        }else {
                            Toast.makeText(Editoras.this, "Houve um erro ao salvar a editora!", Toast.LENGTH_LONG).show();
                        }

                    }
                });
        alertDialog.show();

    }

    @OnClick(R.id.fab)
    public void adicionar(){
        dialogNovaEditora();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
