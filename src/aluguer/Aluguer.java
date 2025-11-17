package aluguer;

import pds.tempo.IntervaloTempo;

public class Aluguer {

    private Viatura viatura;
    private Estacao estacao;
    private double preco;
    private String codigo;
    private IntervaloTempo intervaloTempo;

    public Aluguer(Viatura viatura, Estacao estacao, double preco, String codigo, IntervaloTempo intervaloTempo) {
        this.viatura = viatura;
        this.estacao = estacao;
        this.preco = preco;
        this.codigo = codigo;
        this.intervaloTempo = intervaloTempo;
    }

    public Viatura getViatura() {
        return viatura;
    }

    public Estacao getEstacao() {
        return estacao;
    }

    public double getPreco() {
        return preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public IntervaloTempo getIntervaloTempo() {
        return intervaloTempo;
    }

    

    


    
}
