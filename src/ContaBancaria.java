public class ContaBancaria {

    private String numeroConta;
    private String titular;
    private String cpf;
    private double saldo;
    private double limiteSaque;
    private String agencia;

    private Historico historico;

    // stat,,cont.
    private static int totalContas = 0;

    // c.1s
    public ContaBancaria(String numeroConta, String titular, String cpf) {

        this.numeroConta = numeroConta;
        this.titular = titular;
        this.cpf = cpf;
        this.agencia = "0001";
        this.limiteSaque = 1000;
        this.saldo = 0;
        this.historico = new Historico();

        historico.adicionar("Conta criada.");

        totalContas++;
    }

    // c.2desc
    public ContaBancaria(String numeroConta,
                         String titular,
                         String cpf,
                         String agencia,
                         double limiteSaque) {

        this.numeroConta = numeroConta;
        this.titular = titular;
        this.cpf = cpf;
        this.agencia = agencia;
        this.limiteSaque = limiteSaque;
        this.saldo = 0;
        this.historico = new Historico();

        historico.adicionar("Conta criada.");

        totalContas++;
    }

    // deposit. simples
    public void depositar(double valor) {

        if (!Utilitarios.validarValor(valor)) {
            System.out.println("Valor inválido.");
            return;
        }

        saldo += valor;

        historico.adicionar("Depósito: " +
                Utilitarios.formatarMoeda(valor));

        System.out.println("Depósito realizado com sucesso.");
    }

    // descriçao
    public void depositar(double valor, String descricao) {

        if (!Utilitarios.validarValor(valor)) {
            System.out.println("Valor inválido.");
            return;
        }

        saldo += valor;

        historico.adicionar("Depósito (" + descricao + "): " +
                Utilitarios.formatarMoeda(valor));

        System.out.println("Depósito realizado com sucesso.");
    }

    // saq
    public void sacar(double valor) {

        if (!Utilitarios.validarValor(valor)) {
            System.out.println("Valor inválido.");
            return;
        }

        double tarifa = Utilitarios.calcularTarifa(valor);
        double total = valor + tarifa;

        if (valor > limiteSaque) {
            System.out.println("Valor acima do limite de saque.");
            return;
        }

        if (saldo >= total) {

            saldo -= total;

            historico.adicionar("Saque: " +
                    Utilitarios.formatarMoeda(valor));

            System.out.println("Saque realizado com sucesso.");

        } else {

            System.out.println("Saldo insuficiente.");

        }
    }

    // Ttrnsfrencia
    public void transferir(double valor) {

        if (!Utilitarios.validarValor(valor)) {
            System.out.println("Valor inválido.");
            return;
        }

        if (saldo >= valor) {

            saldo -= valor;

            historico.adicionar("Transferência: " +
                    Utilitarios.formatarMoeda(valor));

            System.out.println("Transferência realizada com sucesso.");

        } else {

            System.out.println("Saldo insuficiente.");

        }
    }

    // c.sald
    public void consultarSaldo() {

        System.out.println("Saldo: " +
                Utilitarios.formatarMoeda(saldo));

    }

    // dados
    public void exibirDadosConta() {

        System.out.println("Titular: " + titular);
        System.out.println("CPF: " + cpf);
        System.out.println("Conta: " + numeroConta);
        System.out.println("Agência: " + agencia);
        System.out.println("Limite de saque: " +
                Utilitarios.formatarMoeda(limiteSaque));

    }

    // historic
    public void exibirHistorico() {
        historico.exibirHistorico();
    }

    // gtst

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {

        if (Utilitarios.validarNome(titular)) {
            this.titular = titular;
        } else {
            System.out.println("Nome inválido.");
        }

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {

        if (Utilitarios.validarCPF(cpf)) {
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido.");
        }

    }

    public String getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }

    public static int getTotalContas() {
        return totalContas;
    }
}