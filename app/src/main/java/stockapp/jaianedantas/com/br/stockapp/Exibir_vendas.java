package stockapp.jaianedantas.com.br.stockapp;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Jaiane on 26/06/2015.
 */
public class Exibir_vendas extends ListActivity {

    private MeuOpenHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new MeuOpenHelper(this);
        ArrayList<String> vendas = db.getDBVendas();
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, vendas);
        setListAdapter(adp);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getString(R.string.app_name));
        alertDialog.setMessage("Produto: "+getListView().getItemAtPosition(position));
        alertDialog.setButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.setIcon(R.drawable.ic_launcher);
        alertDialog.show();

        // Toast.makeText(this.getApplication(), "Selecionado: "+getListView().getItemAtPosition(position), Toast.LENGTH_SHORT).show();
    }


}
