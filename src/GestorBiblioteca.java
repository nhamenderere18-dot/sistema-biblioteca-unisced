public class GestorBiblioteca {
    private Obra[] acervoObras;
    private Leitor[] registoLeitores;
    private Requisicao[] historicoRequisicoes;
    private int[][] matrizTransacoes;

    private int totalObras;
    private int totalLeitores;
    private int totalRequisicoes;

    public GestorBiblioteca(int maxObras, int maxLeitores, int maxTransacoes) {
        this.acervoObras = new Obra[maxObras];
        this.registoLeitores = new Leitor[maxLeitores];
        this.historicoRequisicoes = new Requisicao[maxTransacoes];
        this.matrizTransacoes = new int[maxTransacoes][4];
        
        this.totalObras = 0;
        this.totalLeitores = 0;
        this.totalRequisicoes = 0;
    }

    public boolean cadastrarObra(String titulo, String autor, int ano, int quantidade) {
        if (totalObras >= acervoObras.length) return false;
        int codigo = totalObras + 1;
        acervoObras[totalObras++] = new Obra(codigo, titulo, autor, ano, quantidade);
        return true;
    }

    public boolean cadastrarLeitor(String nome, String contacto) {
        if (totalLeitores >= registoLeitores.length) return false;
        int id = totalLeitores + 1;
        registoLeitores[totalLeitores++] = new Leitor(id, nome, contacto);
        return true;
    }

    public Obra buscarObraPorCodigo(int codigo) {
        for (int i = 0; i < totalObras; i++) {
            if (acervoObras[i].getCodigo() == codigo) return acervoObras[i];
        }
        return null;
    }

    public Leitor buscarLeitorPorId(int id) {
        for (int i = 0; i < totalLeitores; i++) {
            if (registoLeitores[i].getIdLeitor() == id) return registoLeitores[i];
        }
        return null;
    }

    public boolean emitirEmprestimo(int idLeitor, int codigoObra) {
        if (totalRequisicoes >= historicoRequisicoes.length) return false;
        
        Leitor leitor = buscarLeitorPorId(idLeitor);
        Obra obra = buscarObraPorCodigo(codigoObra);

        if (leitor != null && obra != null && obra.emprestarExemplar()) {
            int idReq = totalRequisicoes + 1;
            Requisicao req = new Requisicao(idReq, leitor, obra);
            
            historicoRequisicoes[totalRequisicoes] = req;
            
            matrizTransacoes[totalRequisicoes][0] = idReq;
            matrizTransacoes[totalRequisicoes][1] = idLeitor;
            matrizTransacoes[totalRequisicoes][2] = codigoObra;
            matrizTransacoes[totalRequisicoes][3] = 1;

            totalRequisicoes++;
            return true;
        }
        return false;
    }

    public boolean registarDevolucao(int idRequisicao) {
        for (int i = 0; i < totalRequisicoes; i++) {
            if (matrizTransacoes[i][0] == idRequisicao && matrizTransacoes[i][3] == 1) {
                historicoRequisicoes[i].encerrarRequisicao();
                matrizTransacoes[i][3] = 0;
                return true;
            }
        }
        return false;
    }

    public void listarCatalogo() {
        System.out.println("\n--- ACERVO DA BIBLIOTECA MUNICIPAL ---");
        if (totalObras == 0) {
            System.out.println("Nenhuma obra registada.");
            return;
        }
        for (int i = 0; i < totalObras; i++) {
            System.out.println(acervoObras[i]);
        }
    }

    public void pesquisarObras(String termo) {
        System.out.println("\n--- RESULTADOS DA PESQUISA ---");
        boolean encontrado = false;
        String busca = termo.toLowerCase();
        for (int i = 0; i < totalObras; i++) {
            if (acervoObras[i].getTitulo().toLowerCase().contains(busca) || 
                acervoObras[i].getAutor().toLowerCase().contains(busca)) {
                System.out.println(acervoObras[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum resultado encontrado para: '" + termo + "'");
        }
    }

    public void exibirEstatisticasGerais() {
        System.out.println("\n==================================================");
        System.out.println("        RELATÓRIO ESTATÍSTICO DA BIBLIOTECA       ");
        System.out.println("==================================================");
        System.out.println("Total de Obras Cadastradas: " + totalObras);
        System.out.println("Total de Leitores Registados: " + totalLeitores);
        System.out.println("Total de Recomendações/Requisições: " + totalRequisicoes);

        int ativas = 0;
        for (int i = 0; i < totalRequisicoes; i++) {
            if (matrizTransacoes[i][3] == 1) ativas++;
        }
        System.out.println("Empréstimos Ativos no Momento: " + ativas);

        if (totalObras > 0) {
            Obra maisProcurada = acervoObras[0];
            for (int i = 1; i < totalObras; i++) {
                if (acervoObras[i].getContagemEmprestimos() > maisProcurada.getContagemEmprestimos()) {
                    maisProcurada = acervoObras[i];
                }
            }
            if (maisProcurada.getContagemEmprestimos() > 0) {
                System.out.println("\n--- OBRA MAIS REQUISITADA ---");
                System.out.println("Título: " + maisProcurada.getTitulo());
                System.out.println("Autor: " + maisProcurada.getAutor());
                System.out.println("Requisições Totais: " + maisProcurada.getContagemEmprestimos());
            }
        }
    }
}