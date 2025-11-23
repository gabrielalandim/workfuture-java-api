package br.com.fiap.beans;

public class Vaga {
    private int id;
    private String titulo;
    private String descricao;
    private String nivel; // Ex: Junior, Pleno

    public Vaga() {
    }

    public Vaga(int id, String titulo, String descricao, String nivel) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.nivel = nivel;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    @Override
    public String toString() {
        return "Vaga{id=" + id + ", titulo='" + titulo + "', descricao='" + descricao + "', nivel='" + nivel + "'}";
    }
}