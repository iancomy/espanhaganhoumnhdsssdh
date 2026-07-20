import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Utilitarios.exibirCabecalho();

        System.out.print("Número da conta: ");
        String numero = sc.nextLine();

        System.out.print("Nome do titular: ");
        String nome = sc.nextLine();

        while (!Utilitarios.validarNome(nome)) {
            System.out.print("Nome inválido! Digite novamente: ");
            nome = sc.nextLine();
        }

        System.out.print("CPF (11 números): ");
        String cpf = sc.nextLine();

        while (!Utilitarios.validarCPF(cpf)) {
            System.out.print("CPF inválido!!! Digite novamente: ");
            cpf = sc.nextLine();
        }

        ContaBancaria conta = new ContaBancaria(numero, nome, cpf);

        int opcao;

        do {

            Utilitarios.linha();

            System.out.println("1 - Consultar dados");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Exibir histórico");
            System.out.println("7 - Alterar dados");
            System.out.println("0 - Encerrar");

            System.out.print("Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    conta.exibirDadosConta();
                    break;

                case 2:
                    conta.consultarSaldo();
                    break;

                case 3:

                    System.out.print("Valor do depósito: ");
                    double deposito = sc.nextDouble();

                    conta.depositar(deposito);

                    break;

                case 4:

                    System.out.print("Valor do saque: ");
                    double saque = sc.nextDouble();

                    conta.sacar(saque);

                    break;

                case 5:

                    System.out.print("Valor da transferência: ");
                    double transferencia = sc.nextDouble();

                    conta.transferir(transferencia);

                    break;

                case 6:

                    conta.exibirHistorico();

                    break;

                case 7:

                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    nome = sc.nextLine();

                    conta.setTitular(nome);

                    while (!Utilitarios.validarNome(conta.getTitular())) {
                        System.out.print("Nome inválido! Digite novamente: ");
                        nome = sc.nextLine();
                        conta.setTitular(nome);
                    }

                    System.out.print("Novo CPF: ");
                    cpf = sc.nextLine();

                    conta.setCpf(cpf);

                    while (!Utilitarios.validarCPF(conta.getCpf())) {
                        System.out.print("CPF inválido! Digite novamente: ");
                        cpf = sc.nextLine();
                        conta.setCpf(cpf);
                    }

                    System.out.println("Dados alterados com sucesso.");

                    break;

                case 0:

                    System.out.println("Programa encerrado.");

                    break;

                default:

                    System.out.println("Opção inválida.");

            }

        } while (opcao != 0);

        System.out.println("Total de contas criadas: " + ContaBancaria.getTotalContas());

        sc.close();
    }

}