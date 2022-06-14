import java.math.BigDecimal;

public class App {
        public static void main(String[] args) throws Exception {

                System.out.print(
                                "\n############################### START ###############################\n");
                System.out.println(
                                "\n********************* Bem-vindo ao Seu Banco *********************");

                Banco banco1 = new Banco("Banco do Distrito Federal");
                ClientePessoaFisica cliente1 = new ClientePessoaFisica(
                                "Vinícius de Sousa Santana", "03579526189",
                                new BigDecimal(8000.00).setScale(2));
                ClientePessoaFisica cliente2 = new ClientePessoaFisica(
                                "Cristiano Ronaldo dos Santos Aveiro",
                                "83718237469",
                                new BigDecimal(13500000.00).setScale(2));

                banco1.abrirConta(1, 1, cliente1,
                                Banco.TipoDeConta.CONTA_CORRENTE);
                banco1.abrirConta(2, 1, cliente2,
                                Banco.TipoDeConta.CONTA_POUPANCA);

                for (ClientePessoaFisica cliente : banco1.clientesPf) {
                        System.out.println(cliente.toString());
                }

                for (ContaCorrentePf conta : banco1.contasCorrentePf) {
                        System.out.println(conta.toString());
                }

                for (ContaPoupancaPf conta : banco1.contasPoupancaPf) {
                        System.out.println(conta.toString());
                }

                System.out.print(
                                "\n############################### END ###############################\n");

        }
}
