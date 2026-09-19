public class Leitor {
    private int idLeitor;
    private String nomeCompleto;
    private String contacto;

    public Leitor(int idLeitor, String nomeCompleto, String contacto) {
        this.idLeitor = idLeitor;
        this.nomeCompleto = nomeCompleto;
        this.contacto = contacto;
    }

    public int getIdLeitor() { return idLeitor; }
    public String getNomeCompleto() { return nomeCompleto; }
    public String getContacto() { return contacto; }

    @Override
    public String toString() {
        return String.format("ID: %03d | Nome: %-25s | Contacto: %s", idLeitor, nomeCompleto, contacto);
    }
}