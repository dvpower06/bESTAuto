package aluguer;

import pds.util.Validator;

public class Viatura {

    private String matricula;
    private Modelo modelo;
    private Estacao estacao;

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

    //TODO metodo não confirmado
    public Categoria getCategoria() {
        BESTAuto b = new BESTAuto(); 
        for (Modelo m : b.modelos) {
            if (m.getId() == modelo.getId()) {
                return m.getCategoria();
            }
        }
        return null;
    }



}
