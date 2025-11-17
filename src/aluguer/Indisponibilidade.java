package aluguer;

public class Indisponibilidade {

    private String descricao;
    private String codigo;

    public Indisponibilidade(String descricao, String codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }
    public String getCodigo() {
        return codigo;
    }
    
}
