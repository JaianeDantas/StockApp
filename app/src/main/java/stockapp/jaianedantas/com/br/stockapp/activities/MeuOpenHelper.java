package stockapp.jaianedantas.com.br.stockapp.activities;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import stockapp.jaianedantas.com.br.stockapp.modelos.Contato;
import stockapp.jaianedantas.com.br.stockapp.modelos.ItemVenda;
import stockapp.jaianedantas.com.br.stockapp.modelos.Produto;
import stockapp.jaianedantas.com.br.stockapp.modelos.Venda;


/**
 * Created by Jaiane on 22/06/2015.
 */
public class MeuOpenHelper extends SQLiteOpenHelper {
    public static final String NOME_BANCO = "db_appStockIII";
    public static final  int VERSAO_BANCO = 1;
    final Context context;
    public SQLiteDatabase db = null;
    public String tabelaContato = "contatos";
    public String tabelaProduto = "produtos";
    public String tabelaVenda = "vendas";
    public String tabelaItemVenda = "item_venda";

    public MeuOpenHelper(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            db.execSQL(criaTabelaContato());
            db.execSQL(criaTabelaProduto());
            db.execSQL(criaTabelaVenda());
            db.execSQL(criaTabelaItemVenda());
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contatos");
        db.execSQL("DROP TABLE IF EXISTS produtos");
        db.execSQL("DROP TABLE IF EXISTS vendas");
        db.execSQL("DROP TABLE IF EXISTS item_venda");
        onCreate(db);
    }



    public String criaTabelaContato(){
        String KEY_ID = "id";
        String KEY_NOME = "nome";
        String KEY_EMAIL = "email";
        String KEY_DATNASC = "dataNasc";
        String KEY_TELEFONE = "telefone";
        String KEY_SEXO = "sexo";
        String KEY_PROMOCAO = "promocao";
        String SQL_CREATE_TABLE = "CREATE TABLE contatos(" +
                ""+KEY_ID+" integer primary key autoincrement," +
                ""+KEY_NOME+" text not null, " +
                ""+KEY_EMAIL+" text," +
                " "+KEY_TELEFONE+" text," +
                ""+KEY_DATNASC+" text, "
                +KEY_SEXO+" text,"
                +KEY_PROMOCAO+" boolean);";
        return SQL_CREATE_TABLE;
    }

    public  void abrirDB() throws SQLException{
        if(this.db == null){
            this.db = this.getWritableDatabase();
        }
    }

    public  void fecharDB() throws SQLException{
        if(this.db != null){
            if(this.db.isOpen()){
                this.db.close();
            }
        }
    }

    public void salvarContato(Contato contato) throws SQLException{
        abrirDB();
        db.insert(tabelaContato, null, contato.getContentValues());
        Toast.makeText(context, contato.getNome()+" Cadastrado.", Toast.LENGTH_LONG).show();
        fecharDB();
    }
/*
    public boolean apagarContato(long id) throws SQLException{
        return db.delete(tabelaContato,"id ="+ id, null)>0;

    }

    public Cursor retornaTodosContatos(){
        return db.query(tabelaContato, new String[] {"id", "nome", "email", "dataNasc", "telefone", "sexo", "promocao"}, null, null, null, null, null);
    }

    public boolean atualizaContato(Contato contato){
        return db.update(tabelaContato, contato.getContentValues(), "id =" + contato.get, null)>0;
    }*/


    public String criaTabelaProduto(){
        String SQL_CREATE_TABLE = "CREATE TABLE produtos(id integer primary key autoincrement,cod TEXT NOT NULL,nome TEXT,descricao TEXT, estoque TEXT,valor TEXT);";
        return SQL_CREATE_TABLE;
    }

    public void salvarProduto(Produto produto) throws SQLException{
        abrirDB();
        db.insert(tabelaProduto, null, produto.getContentValues());
        Toast.makeText(context, produto.getNome()+" Cadastrado.", Toast.LENGTH_LONG).show();
        fecharDB();
    }

    public String criaTabelaItemVenda() {
        return "CREATE TABLE item_venda(id integer primary key autoincrement, id_venda integer NOT NULL foreign key id_produto integer NOT NULL foreign key, quantidade integer NOT NULL);";
    }

    public void salvarItemVenda(ItemVenda itemVenda) throws SQLException {
        abrirDB();
        //db.insert(tabelaItemVenda)
        Toast.makeText(context, "Item Adicionado", Toast.LENGTH_LONG).show();
        fecharDB();
    }

    public String criaTabelaVenda(){
        String SQL_CREATE_TABLE = "CREATE TABLE vendas(id integer primary key autoincrement,cliente TEXT NOT NULL,produto TEXT,quantidade TEXT,pagamento TEXT);";
        return SQL_CREATE_TABLE;
    }

    public void salvarVenda(Venda venda) throws SQLException{
        abrirDB();
        db.insert(tabelaVenda, null, venda.getContentValues());
        Toast.makeText(context, "Venda Cadastrada.", Toast.LENGTH_LONG).show();
        fecharDB();
    }

    public ArrayList<String> getDBContatos(){
        ArrayList<String> meusContatos = new ArrayList<String>();
        SQLiteDatabase meuBanco = getReadableDatabase();
        Cursor minhaConsulta = meuBanco.rawQuery("SELECT nome FROM contatos ORDER BY nome", null);
        minhaConsulta.moveToFirst();
        while (! minhaConsulta.isAfterLast()){
            meusContatos.add(minhaConsulta.getString(0));
            minhaConsulta.moveToNext();
        }
        meuBanco.close();
        minhaConsulta.close();
        return meusContatos;
    }

    public List<String> getContatos(){
        List<String> meusContatos = new ArrayList<String>();
        SQLiteDatabase meuBanco = getReadableDatabase();
        Cursor minhaConsulta = meuBanco.rawQuery("SELECT nome FROM contatos ORDER BY nome", null);
        minhaConsulta.moveToFirst();
        while (! minhaConsulta.isAfterLast()){
            meusContatos.add(minhaConsulta.getString(0));
            minhaConsulta.moveToNext();
        }
        meuBanco.close();
        minhaConsulta.close();
        return meusContatos;
    }

    public ArrayList<String> getProdutos(){
        ArrayList<String> meusProdutos = new ArrayList<String>();
        SQLiteDatabase meuBanco = getReadableDatabase();
        Cursor minhaConsulta = meuBanco.rawQuery("SELECT nome FROM produtos ORDER BY nome", null);
        minhaConsulta.moveToFirst();
        while (! minhaConsulta.isAfterLast()){
            meusProdutos.add(minhaConsulta.getString(0));
            minhaConsulta.moveToNext();
        }
        meuBanco.close();
        minhaConsulta.close();
        return meusProdutos;
    }

    public String[] getProdutosS(){
        int i =0;
        String[] meusProdutos = new String[]{};
        SQLiteDatabase meuBanco = getReadableDatabase();
        Cursor minhaConsulta = meuBanco.rawQuery("SELECT nome FROM produtos ORDER BY nome;", meusProdutos);
        minhaConsulta.moveToFirst();
        while (! minhaConsulta.isAfterLast()){
            meusProdutos[i] = (minhaConsulta.getString(0));
            minhaConsulta.moveToNext();
            i++;
        }
        meuBanco.close();
        minhaConsulta.close();
        return meusProdutos;
    }

    public String[] getContatosS(){
        int i =0;
        String[] meusClientes = new String[]{};
        SQLiteDatabase meuBanco = getReadableDatabase();
        Cursor minhaConsulta = meuBanco.rawQuery("SELECT nome FROM contatos ORDER BY nome;", meusClientes);
        minhaConsulta.moveToFirst();
        while (! minhaConsulta.isAfterLast()){
            meusClientes[i] = (minhaConsulta.getString(0));
            minhaConsulta.moveToNext();
            i++;
        }
        meuBanco.close();
        minhaConsulta.close();
        return meusClientes;
    }

    public ArrayList<String> getDBProdutos(){
        Log.d("Erro", "Linha 1es");
        ArrayList<String> meusProdutos = new ArrayList<String>();
        Log.d("Erro", "Linha 2es");
        SQLiteDatabase meuBanco = getReadableDatabase();
        Log.d("Erro", "Linha 3es");
        Cursor minhaConsulta = meuBanco.rawQuery("SELECT nome FROM produtos ORDER BY nome", null);
        Log.d("Erro", "Linha 4es");
        minhaConsulta.moveToFirst();
        Log.d("Erro", "Linha 5es");
        while (! minhaConsulta.isAfterLast()){
            meusProdutos.add(minhaConsulta.getString(0));
            minhaConsulta.moveToNext();
        }
        meuBanco.close();
        minhaConsulta.close();
        return meusProdutos;
    }

    public ArrayList<String> getDBVendas(){
        ArrayList<String> meusProdutos = new ArrayList<String>();
        SQLiteDatabase meuBanco = getReadableDatabase();
        Cursor minhaConsulta = meuBanco.rawQuery("SELECT produto FROM vendas ORDER BY produto",null);
        minhaConsulta.moveToFirst();
        while (! minhaConsulta.isAfterLast()){
            meusProdutos.add(minhaConsulta.getString(0));
            minhaConsulta.moveToNext();
        }
        minhaConsulta.close();
        meuBanco.close();

        return meusProdutos;
    }
}