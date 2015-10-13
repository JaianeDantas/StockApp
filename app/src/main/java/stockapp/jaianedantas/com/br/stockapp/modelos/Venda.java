package stockapp.jaianedantas.com.br.stockapp.modelos;

import android.content.ContentValues;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Jaiane on 19/06/2015.
 */
public class Venda {

    private String cliente;
    private String pagamento;
    private List<ItemVenda> itensVenda;

    public Venda() {
        this.itensVenda = new ArrayList<ItemVenda>();
    }

    @Override
    public String toString() {
        return "Venda{" +
                "Cliente='" + cliente + "'" +
                ", Pagamento='" + pagamento + "'" +
                "}";
    }

    public void addItemVenda(ItemVenda itemVenda) {
        this.getItensVenda().add(itemVenda);
    }

    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getPagamento() {
        return pagamento;
    }
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
    public List<ItemVenda> getItensVenda() {
        return this.itensVenda;
    }
    public void setItensVenda(ArrayList<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
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
