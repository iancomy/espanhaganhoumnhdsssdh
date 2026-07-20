import java.text.DecimalFormat;

public class Utilitarios {

    public static boolean validarCPF(String cpf) {
        return cpf != null && cpf.length() == 11;
    }

    public static boolean validarValor(double valor) {
        return valor > 0;
    }

    public static double calcularTarifa(double valor) {
        return valor * 0.02; // 2%
    }

    public static String formatarMoeda(double valor) {
        DecimalFormat df = new DecimalFormat("R$ #,##0.00");
        return df.format(valor);
    }

    public static void exibirCabecalho() {
        System.out.println("==================================");
        System.out.println(Banco.NOME);
        System.out.println(Banco.SLOGAN);
        System.out.println("==================================");
    }

    // dddd
    public static void linha() {
        System.out.println("--------------------------------");
    }

    public static boolean validarNome(String nome) {
        return nome != null && !nome.isBlank();
    }
    public static boolean validarNumeroConta(String numeroConta) {

        if (numeroConta == null || numeroConta.isBlank()) {
            return false;
        }

        for (int i = 0; i < numeroConta.length(); i++) {

            if (!Character.isDigit(numeroConta.charAt(i))) {
                return false;
            }

        }

        return true;
    }
}