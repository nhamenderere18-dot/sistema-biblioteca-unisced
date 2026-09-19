public class Requisicao {
    private int idRequisicao;
    private Leitor leitor;
    private Obra obra;
    private boolean estadoAtivo;

    public Requisicao(int idRequisicao, Leitor leitor, Obra obra) {
        this.idRequisicao = idRequisicao;
        this.leitor = leitor;
        this.obra = obra;
        this.estadoAtivo = true;
    }

    public int getIdRequisicao() { return idRequisicao; }
    public Leitor getLeitor() { return leitor; }
    public Obra getObra() { return obra; }
    public boolean isEstadoAtivo() { return estadoAtivo; }

    public void encerrarRequisicao() {
        if (this.estadoAtivo) {
            this.estadoAtivo = false;
            this.obra.devolverExemplar();
        }
    }

    @Override
    public String toString() {
        String status = estadoAtivo ? "PENDENTE (Em posse do leitor)" : "CONCLUÍDO (Devolvido)";
        return String.format("Req #%03d | Leitor: %-20s | Obra: %-25s | Status: %s", 
                idRequisicao, leitor.getNomeCompleto(), obra.getTitulo(), status);
    }
}