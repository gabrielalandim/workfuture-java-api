package br.com.fiap.beans;

public class Lead {
    private int id;
    private String nome;
    private String email;
    private String mensagem;

    public Lead() {
    }

    public Lead(int id, String nome, String email, String mensagem) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.mensagem = mensagem;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    @Override
    public String toString() {
        return "Lead{id=" + id + ", nome='" + nome + "', email='" + email + "'}";
    }
}