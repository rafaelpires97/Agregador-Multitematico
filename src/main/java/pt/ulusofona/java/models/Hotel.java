package pt.ulusofona.java.models;

public class Hotel {
    int id;
    String name;
    String cidade;
    String rua;
    String codepostal;
    int preco;
    int estrelas;
    String tipo;


    public Hotel(int id, String name, String cidade, String rua, String codepostal, int preco, int estrelas, String tipo) {
        this.id = id;
        this.name = name;
        this.cidade = cidade;
        this.rua = rua;
        this.codepostal = codepostal;
        this.preco = preco;
        this.estrelas = estrelas;
        this.tipo = tipo;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public void setEstrelas(int estrelas) {
        this.estrelas = estrelas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEstrelas() {
        return estrelas;
    }

    public int getId() {
        return id;
    }

    public int getPreco() {
        return preco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public String getName() {
        return name;
    }

    public String getRua() {
        return rua;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return id + "_" + name + "_" + cidade + "_" + rua + "_" + codepostal + "_" + preco + "_" + estrelas + "_" + tipo;
    }
}
