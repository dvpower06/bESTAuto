package aluguer;

import pds.util.Validator;

/*Se estiver presente, especifica o tipo de extensão ao horário que 
a estação utiliza 
Usa a extensão total, isto é, fora do horário qualquer hora será 
contabilizada como extra 
usa a extensão por horas, isto é, N horas após o fecho ou N 
horas antes da abertura, as horas são consideradas extras. Fora 
desse limite está fechado. Tem como opção o número de horas. */

public class Extensao {

    String tipoExtensao;
    int maxHoras;

    public Extensao(String tipoExtensao, int maxHoras) {
        this.tipoExtensao = Validator.requireNonBlank(tipoExtensao);
        this.maxHoras = Validator.requirePositive(maxHoras);
    }

    public String getTipoExtensao() {
        return tipoExtensao;
    }

    public int getMaxHoras() {
        return maxHoras;
    }

    // Indica se a estação tem extensão de horário configurada. 
    public boolean temExtensao() {
        return tipoExtensao != null;
    }

    // Indica se a extensão é do tipo "horas". 
    public boolean isExtensaoPorHoras() {
        return "horas".equals(tipoExtensao);
    }
    
}
