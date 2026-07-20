public class Historico {

    private String historico = "";

    public void adicionar(String texto) {
        historico += texto + "\n";
    }

    public void exibirHistorico() {
        System.out.println(historico);
    }

}