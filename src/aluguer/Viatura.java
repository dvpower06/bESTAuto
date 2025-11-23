package aluguer;

import pds.util.Validator;

public class Viatura {

    private final String matricula;
    private final Modelo modelo;
    private final Estacao estacao;

    public Viatura(String matricula, Modelo modelo, Estacao estacao) {
        this.matricula = Validator.requireNonBlank(matricula);
        this.modelo = modelo;
        this.estacao = estacao;
    }

    public String getMatricula() {
        return matricula;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Estacao getEstacao() {
        return estacao;
    }


}
