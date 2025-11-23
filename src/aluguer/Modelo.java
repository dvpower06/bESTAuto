package aluguer;

import pds.util.Validator;

public class Modelo {

    private final String id;
    private final String nome;
    private final Categoria categoria;
    private final String marca;
    private final int lotacao;
    private final int bagagem;
    private final long preco;

    public Modelo(String id, String modelo, Categoria categoria, String marca, int lotacao, int bagagem, long preco) {
        this.id = id;
        this.nome = Validator.requireNonBlank(modelo);
        this.categoria = categoria;
        this.marca = marca;
        this.lotacao = Validator.requirePositiveOrZero(lotacao);
        this.bagagem = Validator.requirePositiveOrZero(bagagem);
        this.preco = Validator.requirePositiveOrZero(preco);
    }

    public String getId() {
        return id;
    }
    public String getNome() {
        return nome;
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
