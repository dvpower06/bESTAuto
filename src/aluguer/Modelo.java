package aluguer;

import pds.util.Validator;

public class Modelo {

    private  String id;
    private String modelo;
    private Categoria categoria;
    private String marca;
    private int lotacao;
    private int bagagem;
    private long preco;

    public Modelo(String id, String modelo, Categoria categoria, String marca, int lotacao, int bagagem, long preco) {
        this.id = Validator.requireNonBlank(id);
        this.modelo = Validator.requireNonBlank(modelo);
        this.categoria = categoria;
        this.marca = Validator.requireNonBlank(marca);
        this.lotacao = Validator.requirePositive(lotacao);
        this.bagagem = Validator.requirePositiveOrZero(bagagem);
        this.preco = Validator.requirePositive(preco);
    }

    public String getId() {
        return id;
    }
    public String getModelo() {
        return modelo;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public String getMarca() {
        return marca;
    }
    public int getLotacao() {
        return lotacao;
    }
    public int getBagagem() {
        return bagagem;
    }
    public long getPreco() {
        return preco;
    }
    
}
