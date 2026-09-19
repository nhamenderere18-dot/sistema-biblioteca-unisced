import java.util.Scanner;

public class ValidadorEntrada {
    private static Scanner scanner = new Scanner(System.in);

    public static int lerInteiroPositivo(String mensagem) {
        int valor = -1;
        while (valor < 0) {
            try {
                System.out.print(mensagem);
                valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor < 0) {
                    System.out.println("[ERRO] Introduza um número maior ou igual a zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERRO] Entrada inválida! Digite apenas números inteiros.");
            }
        }
        return valor;
    }

    public static String lerTextoNaoVazio(String mensagem) {
        String texto = "";
        while (texto.trim().isEmpty()) {
            System.out.print(mensagem);
            texto = scanner.nextLine();
            if (texto.trim().isEmpty()) {
                System.out.println("[ERRO] O campo não pode ficar em branco.");
            }
        }
        return texto;
    }
}