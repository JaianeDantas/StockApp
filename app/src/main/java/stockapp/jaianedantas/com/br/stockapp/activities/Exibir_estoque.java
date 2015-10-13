package stockapp.jaianedantas.com.br.stockapp.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class Exibir_estoque extends ListActivity {

    private MeuOpenHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        db = new MeuOpenHelper(this);

        ArrayList<String> produtos = db.getDBProdutos();

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, produtos);

        setListAdapter(adp);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        Toast.makeText(this.getApplication(), "Selecionado: "+getListView().getItemAtPosition(position), Toast.LENGTH_SHORT).show();
    }
}
