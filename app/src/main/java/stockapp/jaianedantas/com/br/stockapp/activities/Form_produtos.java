package stockapp.jaianedantas.com.br.stockapp.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import stockapp.jaianedantas.com.br.stockapp.R;
import stockapp.jaianedantas.com.br.stockapp.modelos.Produto;


public class Form_produtos extends ActionBarActivity {

    EditText campoCod;
    EditText campoProd;
    EditText campDescricao;
    EditText campEstoque;
    EditText campValor;
    private MeuOpenHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_produtos);
        db = new MeuOpenHelper(this);
        carregarcampos();
        configurarBotoes();
    }


    private void carregarcampos() {

        campoCod = (EditText) findViewById(R.id.campCod);
        campoProd =(EditText) findViewById(R.id.campProduto);
        campDescricao = (EditText) findViewById(R.id.campDescricao);
        campEstoque = (EditText) findViewById(R.id.campEstoque);
        campValor= (EditText) findViewById(R.id.campValor);
    }

    private void resetCampos(){
        campoCod.setText(null);
        campoProd.setText(null);
        campDescricao.setText(null);
        campEstoque.setText(null);
        campValor.setText(null);
    }

    private void configurarBotoes(){
        Button bt_cancelar = (Button) findViewById(R.id.butLimpar);
        bt_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCampos();
            }
        });

        Button bt_salvar = (Button) findViewById(R.id.butCasdastrar);

        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    private void salvar() {
        try {
            Produto produto = new Produto();

            produto.setCod(campoCod.getText().toString());
            produto.setNome(campoProd.getText().toString());
            produto.setDescricao(campDescricao.getText().toString());
            produto.setEstoque(campEstoque.getText().toString());
            produto.setValor(campValor.getText().toString());

            db.salvarProduto(produto);
            resetCampos();

        } catch (Exception e) {
            Toast.makeText(this, "Falha na Gravacao!", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form_produtos, menu);
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
    @Override
    public void onBackPressed(){
        sair();
    }

    public void sair(){
        new AlertDialog.Builder(this).setMessage(R.string.mensagem_sair).setCancelable(false)
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Form_produtos.this.finish();
                    }

                })
                .setNegativeButton(getString(R.string.mensagem_cancelar), null)
                .show();
    }
}
