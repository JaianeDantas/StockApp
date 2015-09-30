package stockapp.jaianedantas.com.br.stockapp;

import android.content.ContentValues;

/**
 * Created by Jaiane on 17/06/2015.
 */
public class Contato {
    private String nome;
    private String email;
    private String dataNasc;
    private String telefone;
    private String sexo;
    private boolean promocao;

    public Contato() {
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataNasc='" + dataNasc + '\'' +
                ", telefone='" + telefone + '\'' +
                ", sexo='" + sexo + '\'' +
                ", promocao=" + promocao +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isPromocao() {
        return promocao;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }

    public ContentValues getContentValues(){
        ContentValues campos = new ContentValues();
        campos.put("nome", this.nome);
        campos.put("email", this.email);
        campos.put("dataNasc", this.dataNasc);
        campos.put("telefone", this.telefone);
        campos.put("sexo", this.sexo);
        campos.put("promocao", this.promocao);
        return campos;
    }
}
