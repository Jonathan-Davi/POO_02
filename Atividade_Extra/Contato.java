public class Contato {
    private String nome;
    private Integer telefone;
    private Email email;

    public Contato(String nome, Integer telefone, Email email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email.toString();
    }
}