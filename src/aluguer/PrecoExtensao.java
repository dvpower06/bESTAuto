package aluguer;

import pds.util.Validator;

/*Estando presente, indica como se pagam as horas extras. Se o 
horário tem extensão é obrigatório ter esta chave. 
O atendimento extra é pago com uma taxa, dada como opção. 
O  atendimento  extra  é  pago  com  metade  do  valor  diário  da 
viatura */

public class PrecoExtensao {

    //if Extensao.temExtensao, precoExtensao

    private final String tipoPagamento;
    private final long valorFixo; // Em cêntimos

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
    
    


