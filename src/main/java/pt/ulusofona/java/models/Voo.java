package pt.ulusofona.java.models;

public class Voo {
    int id;
    String hora_partida;
    String origem;
    String hora_chegada;
    String destino;
    String diaPartida;
    String diaChegada;
    boolean escalas;
    int classe;
    int preco;


    public Voo(int id, String hora_partida, String origem, String hora_chegada, String destino, boolean escalas, int classe, int preco, String diaPartida, String diaChegada) {
        this.id = id;
        this.hora_partida = hora_partida;
        this.origem = origem;
        this.hora_chegada = hora_chegada;
        this.destino = destino;
        this.escalas = escalas;
        this.classe = classe;
        this.preco = preco;
        this.diaPartida = diaPartida;
        this.diaChegada = diaChegada;
    }

    public void setDiaChegada(String diaChegada) {
        this.diaChegada = diaChegada;
    }

    public void setDiaPartida(String diaPartida) {
        this.diaPartida = diaPartida;
    }

    public String getDiaChegada() {
        return diaChegada;
    }

    public String getDiaPartida() {
        return diaPartida;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setEscalas(boolean escalas) {
        this.escalas = escalas;
    }

    public void setHora_chegada(String hora_chegada) {
        this.hora_chegada = hora_chegada;
    }

    public void setHora_partida(String hora_partida) {
        this.hora_partida = hora_partida;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public int getId() {
        return id;
    }

    public int getPreco() {
        return preco;
    }

    public int getClasse() {
        return classe;
    }

    public String getDestino() {
        return destino;
    }

    public String getHora_chegada() {
        return hora_chegada;
    }

    public String getHora_partida() {
        return hora_partida;
    }

    public String getOrigem() {
        return origem;
    }

    @Override
    public String toString() {
        return id + "_" + hora_partida + "_" + origem + "_" + hora_chegada + "_" + destino + "_" + diaPartida + "_" + diaChegada + "_" + escalas + "_" + classe + "_" + preco;
    }
}
