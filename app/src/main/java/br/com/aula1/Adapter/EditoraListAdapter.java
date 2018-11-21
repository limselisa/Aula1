package br.com.aula1.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.aula1.Model.Editora;
import br.com.aula1.R;

public class EditoraListAdapter extends BaseAdapter {

    private Activity activity;
    private Context mContext;
    private List<Editora> editoras;

    public EditoraListAdapter(Activity a, Context context, List<Editora> editoras) {
        activity = a;
        mContext = context;
        this.editoras = editoras;

    }

    public int getCount() {
        // TODO Auto-generated method stub
        return editoras.size();
    }

    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.icone_texto_layout, parent, false);

        TextView nome = (TextView) vi.findViewById(R.id.nome); // title
        ImageView icone = (ImageView) vi.findViewById(R.id.icone); // thumb image

        nome.setText(editoras.get(position).getNome());
        icone.setImageResource(R.drawable.ic_right_arrow);
        return vi;
    }
}
