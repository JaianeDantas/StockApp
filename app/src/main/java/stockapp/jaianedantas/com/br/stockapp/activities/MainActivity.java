package stockapp.jaianedantas.com.br.stockapp.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import stockapp.jaianedantas.com.br.stockapp.R;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle(R.string.titulo);
        ab.setSubtitle(R.string.subtitulo);
        ab.setBackgroundDrawable(getResources().getDrawable(R.color.blue));
        ab.setIcon(R.mipmap.ic_launcher);
        ab.setDisplayShowHomeEnabled(true);
        ConfigurarButoes();
    }

    private void ConfigurarButoes() {
        Button btCadastro = (Button) findViewById(R.id.btCadastro);
        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregarTelaCadastro();
            }
        });

        Button btExContatos = (Button) findViewById(R.id.btRelatorioClientes);
        btExContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregarConsultaCliente();
            }
        });

        Button btExEstoque = (Button) findViewById(R.id.btRelatorioEstoque);
        btExEstoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregarConsultaEstoque();
            }
        });

        Button btExVendas = (Button) findViewById(R.id.btRelatorioVendas);
        btExVendas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregarConsultaVenda();
            }
        });


        Button btCadastroProdutos = (Button) findViewById(R.id.btCadastroProdutos);
        btCadastroProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregarTelaCadastroProduto();
            }
        });

        Button btCadastrarVenda = (Button) findViewById(R.id.btCadastroVendas);
        btCadastrarVenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregarTelaCadastroVenda();
            }
        });
    }

    private void carregarConsultaVenda() {
        Intent intent = new Intent(this, Exibir_vendas.class);
        startActivity(intent);
    }

    private void carregarConsultaCliente() {
        Intent intent = new Intent(this, Consulta.class);
        startActivity(intent);
    }

    private void carregarConsultaEstoque() {
        Intent intent = new Intent(this, Exibir_estoque.class);
        startActivity(intent);
    }

    private void carregarTelaCadastroVenda() {
        Intent intent = new Intent(this, Form_vendas.class);
        startActivity(intent);
    }

    public void carregarTelaCadastro(){
        Intent intent = new Intent(this, Formulario.class);
        startActivity(intent);
    }

    public void carregarTelaCadastroProduto(){
        Intent intent = new Intent(this, Form_produtos.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.sair) {
            sair();
            return true;
        }

        else if (id == R.id.sobre) {
            mensagemSobre();
            return true;
        }

        else if (id == R.id.compartilhar) {
            Intent sendIntent = new Intent();

            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.mensagem_compartilhar));
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
            sendIntent.setType("text/plain");

            startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.action_share)));

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void mensagemSobre(){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        //alertDialog.setTitle("Sua mensagem");
        alertDialog.setTitle(getString(R.string.app_name));
        alertDialog.setMessage(getString(R.string.mensagem_sobre));
        alertDialog.setButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.setIcon(R.drawable.ic_launcher);
        alertDialog.show();

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
                        MainActivity.this.finish();
                    }

                })
                .setNegativeButton(getString(R.string.mensagem_cancelar), null)
                .show();
    }
}
