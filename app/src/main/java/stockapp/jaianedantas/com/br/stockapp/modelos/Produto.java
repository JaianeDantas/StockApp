package stockapp.jaianedantas.com.br.stockapp.modelos;

import android.content.ContentValues;

/**
 * Created by Jaiane on 19/06/2015.
 */
public class Produto {
    private String cod;
    private String nome;
    private String descricao;
    private String estoque;
    private String valor;

    public Produto() {
    }

    @Override
    public String toString() {
        return "Produto{" +
                "cod='" + cod + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", estoque='" + estoque + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }

    public void atualizaEstoque(String valor){
        int s = Integer.parseInt(this.estoque) - Integer.parseInt(valor);
        this.estoque = s+"";
    }
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEstoque() {
        return estoque;
    }

    public void setEstoque(String estoque) {
        this.estoque = estoque;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ContentValues getContentValues(){
        ContentValues campos = new ContentValues();
        campos.put("cod", this.cod);
        campos.put("nome", this.nome);
        campos.put("descricao", this.descricao);
        campos.put("estoque", this.estoque);
        campos.put("valor", this.valor);
        return campos;
    }

}
