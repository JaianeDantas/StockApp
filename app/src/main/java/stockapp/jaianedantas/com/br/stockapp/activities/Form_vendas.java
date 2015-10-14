package stockapp.jaianedantas.com.br.stockapp.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;

import stockapp.jaianedantas.com.br.stockapp.R;
import stockapp.jaianedantas.com.br.stockapp.modelos.Venda;
import stockapp.jaianedantas.com.br.stockapp.modelos.ItemVenda;


public class Form_vendas extends ActionBarActivity {

    private MeuOpenHelper db;
    private List<ItemVenda> itensVenda;
    //private ArrayList<String> clientes = new ArrayList<String>();
    //private ArrayList<String> produtos = new ArrayList<String>();
    //private static final String[] clientes = new String[]{};
    //private static final String[] produtos = new String[]{};


    Spinner campoCliente;
    Spinner campoProduto;
    EditText quantidade;
    RadioGroup pagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_vendas);
        db = new MeuOpenHelper(this);
        carregarCampos();
        configurarBotoes();
    }

    private void configurarBotoes() {

        Button bt_cancelar;
        bt_cancelar = (Button) findViewById(R.id.vendaLimpar);
        bt_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCampos();
            }
        });

        Button bt_salvar = (Button) findViewById(R.id.vendaSalvar);

        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    private void salvar() {
        try {
            Venda venda = new Venda();

            Spinner s = (Spinner) findViewById(R.id.completeCliente);
            String text = s.getSelectedItem().toString();
            venda.setCliente(text);

            Spinner p = (Spinner) findViewById(R.id.completeProduto);
            String t = p.getSelectedItem().toString();
            venda.setProduto(t);

            venda.setQuantidade(quantidade.getText().toString());

            int selectedId = pagamento.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) findViewById(selectedId);
            venda.setPagamento(radioButton.getText().toString());

            //aqui comandos para o bd
            db.salvarVenda(venda);
            resetCampos();

        }catch (Exception e){
            Toast.makeText(this, "Falha na Gravacao!", Toast.LENGTH_LONG).show();
        }
    }

    public void carregarCampos(){
        ArrayAdapter<String> adp;
        ArrayList<String> lista = db.getDBContatos();
        adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
        campoCliente = (Spinner) findViewById(R.id.completeCliente);
        campoCliente.setAdapter(adp);

        lista = db.getDBProdutos();
        ArrayAdapter<String> adpp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
        campoProduto = (Spinner) findViewById(R.id.completeProduto);

        campoProduto.setAdapter(adpp);

        quantidade = (EditText) findViewById(R.id.campoQuantidade);
        pagamento = (RadioGroup) findViewById(R.id.pagamento);

    }

    private void resetCampos(){
        campoCliente.setSelection(-1);
        campoProduto.setSelection(-1);
        quantidade.setText(null);
        pagamento.clearCheck();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form_vendas, menu);
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
    public void onBackPressed(){ sair();
    }

    public void sair(){
        new AlertDialog.Builder(this).setMessage(R.string.mensagem_sair).setCancelable(false)
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Form_vendas.this.finish();
                    }

                })
                .setNegativeButton(getString(R.string.mensagem_cancelar), null)
                .show();
    }

}
