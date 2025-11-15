package aluguer;

public class Viatura {

    private String matricula;
    private String modelo;
    private String estacao;

    public Viatura(String matricula, String modelo, String estacao) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.estacao = estacao;
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
