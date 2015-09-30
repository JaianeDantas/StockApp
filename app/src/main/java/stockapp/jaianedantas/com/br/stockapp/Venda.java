package stockapp.jaianedantas.com.br.stockapp;

import android.content.ContentValues;

/**
 * Created by Jaiane on 19/06/2015.
 */
public class Venda {

    private String cliente;
    private String produto;
    private String quantidade;
    private String pagamento;

    public Venda() {
    }

    @Override
    public String toString() {
        return "Venda{" +
                "cliente='" + cliente + '\'' +
                ", produto='" + produto + '\'' +
                ", quantidade='" + quantidade + '\'' +
                ", pagamento='" + pagamento + '\'' +
                '}';
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public ContentValues getContentValues(){
        ContentValues campos = new ContentValues();
        campos.put("cliente", this.cliente);
        campos.put("produto", this.produto);
        campos.put("quantidade", this.quantidade);
        campos.put("pagamento", this.pagamento);
        return campos;
    }
}
