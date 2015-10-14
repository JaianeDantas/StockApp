package stockapp.jaianedantas.com.br.stockapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import stockapp.jaianedantas.com.br.stockapp.R;
import stockapp.jaianedantas.com.br.stockapp.modelos.ItemVenda;
import stockapp.jaianedantas.com.br.stockapp.modelos.Produto;
import stockapp.jaianedantas.com.br.stockapp.modelos.Venda;

public class activity_form_itemVenda_produto extends AppCompatActivity {

    Spinner produtos;
    EditText quantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_form_item_venda_produto);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_form_item_venda_produto, menu);
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
        Button bt_salvar, bt_limpar;

        bt_limpar = (Button) findViewById(R.id.ItemVenda2_BotaoLimpar);
        bt_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCampos();
            }
        });
        bt_salvar = (Button) findViewById(R.id.ItemVenda2_BotaoSalvar);
        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    public void resetCampos() {
        produtos.setSelection(-1);
        quantidade.setText(null);
    }
    public void salvar() {
        try {
            ItemVenda itemVenda = new ItemVenda();
            Spinner spinner = (Spinner) findViewById(R.id.ItemVenda2_ProdutoSpinner);
            itemVenda.setProduto((Produto) spinner.getSelectedItem());
            itemVenda.setQuant(Integer.parseInt(quantidade.getText().toString()));

        }catch (Exception e) {
            Toast.makeText(this, "Falha na Gravacao!", Toast.LENGTH_LONG).show();
        }
    }
}
