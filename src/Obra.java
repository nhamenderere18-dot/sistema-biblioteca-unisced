public class Obra {
    private int codigo;
    private String titulo;
    private String autor;
    private int ano;
    private int exemplaresDisponiveis;
    private int contagemEmprestimos;

    public Obra(int codigo, String titulo, String autor, int ano, int exemplaresDisponiveis) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
        this.contagemEmprestimos = 0;
    }

    public int getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAno() { return ano; }
    public int getExemplaresDisponiveis() { return exemplaresDisponiveis; }
    public int getContagemEmprestimos() { return contagemEmprestimos; }

    public boolean emprestarExemplar() {
        if (exemplaresDisponiveis > 0) {
            exemplaresDisponiveis--;
            contagemEmprestimos++;
            return true;
        }
        return false;
    }

    public void devolverExemplar() {
        exemplaresDisponiveis++;
    }

    @Override
    public String toString() {
        return String.format("[%03d] %-30s | Autor: %-20s | Ano: %d | Stock: %d ex.", 
                codigo, titulo, autor, ano, exemplaresDisponiveis);
    }
}