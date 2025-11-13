package aluguer;

import pds.tempo.HorarioSemanal;

public class Estacao {
    String id;
    String nome;
    HorarioSemanal horario;
    String central;

    public Estacao(String id, String nome, HorarioSemanal horario, String central) {
        this.id = id;
        this.nome = nome;
        this.horario = horario;
        this.central = central;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public HorarioSemanal getHorario() {
        return horario;
    }

    public void setHorario(HorarioSemanal horario) {
        this.horario = horario;
    }

    public String getCentral() {
        return central;
    }

    public void setCentral(String central) {
        this.central = central;
    }

    
    

}
