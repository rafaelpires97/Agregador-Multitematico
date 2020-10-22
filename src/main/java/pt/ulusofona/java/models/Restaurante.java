package pt.ulusofona.java.models;

public class Restaurante {
    int id;
    String name;
    String cidade;
    String rua;
    String codpostal;
    String especialidade;

    public Restaurante(int id, String name, String cidade, String rua, String codpostal, String especialidade
    ) {
        this.id = id;
        this.name = name;
        this.cidade = cidade;
        this.rua = rua;
        this.codpostal = codpostal;
        this.especialidade = especialidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getRua() {
        return rua;
    }

    public String getName() {
        return name;
    }

    public String getCidade() {
        return cidade;
    }

    public int getId() {
        return id;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public String toString() {
        return id + "_" + name + "_" + cidade + "_" + rua + "_" + codpostal + "_" + especialidade;
    }
}
