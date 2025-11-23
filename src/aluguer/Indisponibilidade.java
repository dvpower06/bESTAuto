package aluguer;

import java.time.LocalDateTime;

public class Indisponibilidade {

    private final String descricao;
    private final LocalDateTime inicio;
    private final LocalDateTime fim;

    public Indisponibilidade(String descricao, LocalDateTime inicio, LocalDateTime fim) {
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }
    
}
