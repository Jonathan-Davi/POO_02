public class Email {
    private String nomeEmail;
    private String dominio;

    public Email(String nomeEmail, String dominio) {
        this.nomeEmail = nomeEmail;
        this.dominio = dominio;
    }

    public String getNomeEmail() {
        return nomeEmail;
    }

    public void setNomeEmail(String nomeEmail) {
        this.nomeEmail = nomeEmail;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String toString() {
        return nomeEmail + "@" + dominio;
    }
}