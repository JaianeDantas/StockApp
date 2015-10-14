package stockapp.jaianedantas.com.br.stockapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import stockapp.jaianedantas.com.br.stockapp.R;
import stockapp.jaianedantas.com.br.stockapp.modelos.Produto;
import stockapp.jaianedantas.com.br.stockapp.modelos.Venda;

public class activity_form_itemVenda extends AppCompatActivity {

    private MeuOpenHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_form_item_venda);
        db = new MeuOpenHelper(this);
        carregarCampos();
        configurarBotoes();

        Venda venda = new Venda();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_form_item_venda, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void configurarBotoes() {
        Button addProduto = (Button) findViewById(R.id.addProduto);
        addProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregarTelaNovoProduto();
            }
        });
        Button botaoContinuar = (Button) findViewById(R.id.botaoContinuar);
        botaoContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carregarTelaVenda();
            }
        });
    }

    public void carregarCampos() {
        //ArrayList<Produto> produtos = ;
    }

    public void carregarTelaNovoProduto() {
        Intent intent = new Intent(this, activity_form_itemVenda_produto.class);
        startActivity(intent);
    }
    public void carregarTelaVenda() {
        Intent intent = new Intent(this, Form_vendas.class);
        startActivity(intent);
    }

}
