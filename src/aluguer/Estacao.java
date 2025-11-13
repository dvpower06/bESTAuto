package aluguer;

import pds.util.Validator;

import pds.tempo.HorarioSemanal;

public class Estacao {
    String id;
    String nome;
    HorarioSemanal horario;
    String central;
    Extensao extensao;
    PrecoExtensao precoExtensao;

    public Estacao(String id, String nome, HorarioSemanal horario, String central , Extensao extensao, PrecoExtensao precoextensao) {
        this.id = Validator.requireNonBlank(id) ;
        this.nome = Validator.requireNonBlank(nome);
        this.horario = horario;
        this.central = central;
        this.extensao = extensao;
        this.precoExtensao = precoextensao;        
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public HorarioSemanal getHorario() {
        return horario;
    }

    public String getCentral() {
        return central;
    }

    public Extensao getExtensao() {
        return extensao;
    }

    public PrecoExtensao getPrecoExtensao() {
        return precoExtensao;
    }   

}
