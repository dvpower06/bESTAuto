package aluguer;

public class Modelo {

    private  String id;
    private String modelo;
    private Categoria categoria;
    private String marca;
    private int lotacao;
    private int bagagem;
    private long preco;

    public Modelo(String id, String modelo, Categoria categoria, String marca, int lotacao, int bagagem, long preco) {
        this.id = id;
        this.modelo = modelo;
        this.categoria = categoria;
        this.marca = marca;
        this.lotacao = lotacao;
        this.bagagem = bagagem;
        this.preco = preco;
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
