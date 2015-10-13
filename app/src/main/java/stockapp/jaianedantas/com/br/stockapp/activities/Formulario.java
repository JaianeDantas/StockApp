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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import stockapp.jaianedantas.com.br.stockapp.Mask;
import stockapp.jaianedantas.com.br.stockapp.R;
import stockapp.jaianedantas.com.br.stockapp.modelos.Contato;


public class Formulario extends ActionBarActivity {
    private MeuOpenHelper db;
    private List<Contato> contatos = new ArrayList<Contato>();

    EditText campoNome;
    EditText campoEmail;
    EditText campoTelefone;
    EditText campoDataNascimento;
    RadioGroup campoSexo;
    Switch campoPromocoes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        db = new MeuOpenHelper(this);
        carregarcampos();
        configurarBotoes();
    }


    private void carregarcampos() {
        campoNome = (EditText) findViewById(R.id.cpNome);
        campoEmail = (EditText) findViewById(R.id.cpEmail);
        campoTelefone = (EditText) findViewById(R.id.cpTelefone);
        campoTelefone.addTextChangedListener(Mask.insert("(##)#####-####", campoTelefone));
        campoDataNascimento = (EditText) findViewById(R.id.cpNascimento);
        campoDataNascimento.addTextChangedListener(Mask.insert("##/##/####", campoDataNascimento));
        campoSexo = (RadioGroup) findViewById(R.id.sexo);
        campoPromocoes =(Switch) findViewById(R.id.stPromocoes);
    }

    private void resetCampos(){
        campoNome.setText(null);
        campoEmail.setText(null);
        campoTelefone.setText(null);
        campoDataNascimento.setText(null);
        campoSexo.clearCheck();
        campoPromocoes.setChecked(true);
    }

    private void configurarBotoes(){
        Button bt_cancelar = (Button) findViewById(R.id.btLimpar);
        bt_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCampos();
            }
        });

        Button bt_salvar = (Button) findViewById(R.id.btSalvar);

        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    private void salvar() {

        try{
            Contato contato = new Contato();
            contato.setNome(campoNome.getText().toString());
            contato.setEmail(campoEmail.getText().toString());
            contato.setTelefone(campoTelefone.getText().toString());
            contato.setDataNasc(campoDataNascimento.getText().toString());

            int selectedId = campoSexo.getCheckedRadioButtonId();
            RadioButton radioButton = (RadioButton) findViewById(selectedId);
            contato.setSexo(radioButton.getText().toString());

            contato.setPromocao(Boolean.valueOf(campoPromocoes.getText().toString()));

            db.salvarContato(contato);
            resetCampos();

        }catch (Exception e){
            Toast.makeText(this, "Falha na Gravacao!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
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
                        Formulario.this.finish();
                    }

                })
                .setNegativeButton(getString(R.string.mensagem_cancelar), null)
                .show();
    }
}
