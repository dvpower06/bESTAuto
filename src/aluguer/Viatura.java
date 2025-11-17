package aluguer;

import pds.util.Validator;

public class Viatura {

    private String matricula;
    private String modelo;
    private String estacao;

    public Viatura(String matricula, String modelo, String estacao) {
        this.matricula = Validator.requireNonBlank(matricula);
        this.modelo = Validator.requireNonBlank(modelo);
        this.estacao = Validator.requireNonBlank(estacao);
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public String getEstacao() {
        return estacao;
    } 

    
    
}
