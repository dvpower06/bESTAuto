package aluguer;

import pds.util.Validator;


public class PrecoExtensao {


    private final String tipoPagamento;
    private final long valorFixo; 

    public PrecoExtensao(String tipoPagamento, long valorFixo) {
        this.tipoPagamento = Validator.requireNonBlank(tipoPagamento);
        this.valorFixo = Validator.requirePositiveOrZero(valorFixo);
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public long getValorFixo() {
        return valorFixo;
    }
}
    
    


