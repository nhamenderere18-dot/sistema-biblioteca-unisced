public class Principal {
    public static void main(String[] args) {
        GestorBiblioteca gestor = new GestorBiblioteca(100, 50, 200);

        // Carga Inicial de Dados
        gestor.cadastrarObra("Estruturas de Dados em Java", "E. Horowitz", 2019, 3);
        gestor.cadastrarObra("Algoritmos: Teoria e Prática", "T. Cormen", 2021, 2);
        gestor.cadastrarLeitor("Igor Gervasio", "igor.gervasio@unisced.ac.mz");
        gestor.cadastrarLeitor("Maria Machava", "+258 84 100 2000");

        int opcao = -1;
        do {
            exibirMenu();
            opcao = ValidadorEntrada.lerInteiroPositivo("Selecione uma opção: ");

            switch (opcao) {
                case 1 -> {
                    String t = ValidadorEntrada.lerTextoNaoVazio("Título da Obra: ");
                    String a = ValidadorEntrada.lerTextoNaoVazio("Autor: ");
                    int ano = ValidadorEntrada.lerInteiroPositivo("Ano de Publicação: ");
                    int q = ValidadorEntrada.lerInteiroPositivo("Quantidade de Exemplares: ");
                    if (gestor.cadastrarObra(t, a, ano, q)) {
                        System.out.println("\n[SUCESSO] Obra registada no acervo!");
                    }
                }
                case 2 -> gestor.listarCatalogo();
                case 3 -> {
                    String termo = ValidadorEntrada.lerTextoNaoVazio("Digite o título ou autor para pesquisa: ");
                    gestor.pesquisarObras(termo);
                }
                case 4 -> {
                    String nome = ValidadorEntrada.lerTextoNaoVazio("Nome do Leitor: ");
                    String contacto = ValidadorEntrada.lerTextoNaoVazio("Contacto: ");
                    if (gestor.cadastrarLeitor(nome, contacto)) {
                        System.out.println("\n[SUCESSO] Leitor registado com sucesso!");
                    }
                }
                case 5 -> {
                    int idLeitor = ValidadorEntrada.lerInteiroPositivo("ID do Leitor: ");
                    int codObra = ValidadorEntrada.lerInteiroPositivo("Código da Obra: ");
                    if (gestor.emitirEmprestimo(idLeitor, codObra)) {
                        System.out.println("\n[SUCESSO] Requisição registada com sucesso!");
                    } else {
                        System.out.println("\n[ERRO] Não foi possível emitir a requisição (Obra sem stock ou IDs inválidos).");
                    }
                }
                case 6 -> {
                    int idReq = ValidadorEntrada.lerInteiroPositivo("Número da Requisição: ");
                    if (gestor.registarDevolucao(idReq)) {
                        System.out.println("\n[SUCESSO] Devolução efetuada e exemplar reposto no acervo!");
                    } else {
                        System.out.println("\n[ERRO] Requisição não encontrada ou já encerrada.");
                    }
                }
                case 7 -> gestor.exibirEstatisticasGerais();
                case 0 -> System.out.println("\n[SISTEMA] A conceptualizar encerramento... Até à próxima!");
                default -> System.out.println("\n[ERRO] Opção inválida. Escolha um número de 0 a 7.");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n==================================================");
        System.out.println("   SISTEMA MUNICIPAL DE GESTÃO DE BIBLIOTECA    ");
        System.out.println("==================================================");
        System.out.println("1. Cadastrar Nova Obra");
        System.out.println("2. Consultar Acervo Completo");
        System.out.println("3. Pesquisar Obra (Título / Autor)");
        System.out.println("4. Cadastrar Novo Leitor");
        System.out.println("5. Emitir Requisição de Empréstimo");
        System.out.println("6. Registrar Devolução");
        System.out.println("7. Exibir Painel Estatístico");
        System.out.println("0. Sair do Sistema");
        System.out.println("==================================================");
    }
}