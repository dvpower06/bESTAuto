package aluguer;

import pds.util.Validator;

public class Extensao {

    private String tipoExtensao;
    private int maxHoras;

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


    public boolean temExtensao() {
        return tipoExtensao != null;
    }

  
}
