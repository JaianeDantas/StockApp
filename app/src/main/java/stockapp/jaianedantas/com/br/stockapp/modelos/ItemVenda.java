package stockapp.jaianedantas.com.br.stockapp.modelos;

/**
 * Created by André on 13/10/2015.
 */
public class ItemVenda {

    private int quant;
    private Produto produto;

    public ItemVenda() {

    }

    @Override
    public String toString() {
        return "Item{" +
                "CodProduto='" + this.getProduto().getCod() + "'" +
                ", NomeProduto='" + this.getProduto().getNome() + "'" +
                ", Quantidade='" + this.getQuant() + "'" +
                "}";
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }
    public int getQuant() {
        return this.quant;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Produto getProduto() {
        return this.produto;
    }
}
