import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class App {

        public static Locale ptbr = new Locale("pt", "BR");

        public static void main(String[] args) throws Exception {

                System.out.print(
                                "\n############################################# START #############################################\n");

                Banco banco1 = new Banco("Banco do Distrito Federal");

                System.out.println(
                                "\n************************************ Bem-vindo ao " + banco1.getNome()
                                                + " *************************************");

                ClientePessoaFisica cliente1 = new ClientePessoaFisica(
                                "Lionel Andrés Messi Cuccittini", "65988521479",
                                new BigDecimal(8000.00).setScale(2, RoundingMode.HALF_UP));
                ClientePessoaFisica cliente2 = new ClientePessoaFisica(
                                "Cristiano Ronaldo dos Santos Aveiro",
                                "83718237469",
                                new BigDecimal(13500000.00).setScale(2, RoundingMode.HALF_UP));
                ClientePessoaFisica cliente3 = new ClientePessoaFisica(
                                "Anderson Luiz de Carvalho",
                                "65455892369",
                                new BigDecimal(135000.00).setScale(2, RoundingMode.HALF_UP));

                ClientePessoaJuridica cliente4 = new ClientePessoaJuridica("Clube de Regatas Vasco da Gama",
                                "336174650001", new BigDecimal(15500000.00).setScale(2, RoundingMode.HALF_UP));
                ClientePessoaJuridica cliente5 = new ClientePessoaJuridica("Sport Club Corinthians Paulista",
                                "336174650001", new BigDecimal(37250000.00).setScale(2, RoundingMode.HALF_UP));

                ClientePessoaFisica cliente6 = new ClientePessoaFisica(
                                "Gustavo Maia da Silva",
                                "99827615289",
                                new BigDecimal(6717.04).setScale(2, RoundingMode.HALF_UP));

                banco1.abrirConta(1, 1, cliente1,
                                Banco.TipoDeConta.CONTA_CORRENTE);
                banco1.abrirConta(2, 1, cliente2,
                                Banco.TipoDeConta.CONTA_POUPANCA);
                banco1.abrirConta(3, 1, cliente3, Banco.TipoDeConta.CONTA_INVESTIMENTO);
                banco1.abrirConta(6, 1, cliente6, Banco.TipoDeConta.CONTA_CORRENTE);

                banco1.abrirConta(4, 1, cliente4, Banco.TipoDeConta.CONTA_INVESTIMENTO);
                banco1.abrirConta(5, 1, cliente5, Banco.TipoDeConta.CONTA_CORRENTE);

                System.out.print(
                                "\n##################################### Lista de Clientes PF ######################################\n\n");

                for (ClientePessoaFisica cliente : banco1.clientesPf) {
                        System.out.println(cliente.toString());
                }

                System.out.print(
                                "\n################################## Lista de Contas Corrente PF ##################################\n\n");

                for (ContaCorrentePf conta : banco1.contasCorrentePf) {
                        System.out.println(conta.toString());
                }

                System.out.print(
                                "\n################################## Lista de Contas Poupanca PF ##################################\n\n");

                for (ContaPoupancaPf conta : banco1.contasPoupancaPf) {
                        System.out.println(conta.toString());
                }

                System.out.print(
                                "\n################################ Lista de Contas Investimento PF ################################\n\n");

                for (ContaInvestimentoPf conta : banco1.contasInvestimentoPf) {
                        System.out.println(conta.toString());
                }

                System.out.print(
                                "\n################################ Operações em Conta Corrente PF #################################\n\n");

                banco1.contasCorrentePf.get(0).depositar(new BigDecimal(150000.00));
                System.out.println(
                                "Depósito no valor de " + FormatacaoMonetaria(new BigDecimal(150000.00), ptbr)
                                                + " realizado na conta corrente nº 1.");

                ImprimeSaldoConta(banco1.contasCorrentePf.get(0).consultarSaldo(), Banco.TipoDeConta.CONTA_CORRENTE,
                                banco1.contasCorrentePf.get(0).getNumeroConta());

                System.out.println("Transferindo " + FormatacaoMonetaria(new BigDecimal(25000.00), ptbr)
                                + " da conta corrente n°1 para a conta poupança nº 2.");

                banco1.contasCorrentePf.get(0).transferir(banco1.contasPoupancaPf.get(0), new BigDecimal(25000.00));

                ImprimeSaldoConta(banco1.contasCorrentePf.get(0).consultarSaldo(), Banco.TipoDeConta.CONTA_CORRENTE,
                                banco1.contasCorrentePf.get(0).getNumeroConta());

                ImprimeSaldoConta(banco1.contasPoupancaPf.get(0).consultarSaldo(), Banco.TipoDeConta.CONTA_POUPANCA,
                                banco1.contasPoupancaPf.get(0).getNumeroConta());

                System.out.println("Sacando " + FormatacaoMonetaria(new BigDecimal(5000.00), ptbr)
                                + " da conta corrente n°1.");

                banco1.contasCorrentePf.get(0).sacar(new BigDecimal(5000.00));

                ImprimeSaldoConta(banco1.contasCorrentePf.get(0).consultarSaldo(), Banco.TipoDeConta.CONTA_CORRENTE,
                                banco1.contasCorrentePf.get(0).getNumeroConta());

                System.out.print(
                                "\n################################ Operações em Conta Poupança PF #################################\n\n");

                banco1.contasPoupancaPf.get(0).depositar(new BigDecimal(100000.00));
                System.out.println(
                                "Depósito no valor de " + FormatacaoMonetaria(new BigDecimal(100000.00), ptbr)
                                                + " realizado na conta poupança nº 1.");

                ImprimeSaldoConta(banco1.contasPoupancaPf.get(0).consultarSaldo(), Banco.TipoDeConta.CONTA_POUPANCA,
                                banco1.contasPoupancaPf.get(0).getNumeroConta());

                System.out.println("Transferindo " + FormatacaoMonetaria(new BigDecimal(15000.00), ptbr)
                                + " da conta poupança n°2 para a conta corrente nº 1.");

                banco1.contasPoupancaPf.get(0).transferir(banco1.contasCorrentePf.get(0), new BigDecimal(15000.00));

                ImprimeSaldoConta(banco1.contasPoupancaPf.get(0).consultarSaldo(), Banco.TipoDeConta.CONTA_POUPANCA,
                                banco1.contasPoupancaPf.get(0).getNumeroConta());

                ImprimeSaldoConta(banco1.contasCorrentePf.get(0).consultarSaldo(),
                                Banco.TipoDeConta.CONTA_CORRENTE,
                                banco1.contasCorrentePf.get(0).getNumeroConta());

                System.out.println("Sacando " + FormatacaoMonetaria(new BigDecimal(7000.00), ptbr)
                                + " da conta poupanca n°2.");

                banco1.contasPoupancaPf.get(0).sacar(new BigDecimal(7000.00));

                ImprimeSaldoConta(banco1.contasPoupancaPf.get(0).consultarSaldo(), Banco.TipoDeConta.CONTA_POUPANCA,
                                banco1.contasPoupancaPf.get(0).getNumeroConta());

                System.out.print(
                                "\n############################## Operações em Conta Investimento PF ###############################\n\n");

                banco1.contasInvestimentoPf.get(0).investir(new BigDecimal(50000.00));

                System.out.println(
                                "Investimento no valor de " + FormatacaoMonetaria(new BigDecimal(50000.00), ptbr)
                                                + " realizado na conta investimento nº 3.");

                ImprimeSaldoConta(banco1.contasInvestimentoPf.get(0).consultarSaldo(),
                                Banco.TipoDeConta.CONTA_INVESTIMENTO,
                                banco1.contasInvestimentoPf.get(0).getNumeroConta());

                System.out.println("Transferindo " + FormatacaoMonetaria(new BigDecimal(18000.00), ptbr)
                                + " da conta investimento n°3 para a conta corrente nº 1.");

                banco1.contasInvestimentoPf.get(0).transferir(banco1.contasCorrentePf.get(0), new BigDecimal(18000.00));

                ImprimeSaldoConta(banco1.contasInvestimentoPf.get(0).consultarSaldo(),
                                Banco.TipoDeConta.CONTA_INVESTIMENTO,
                                banco1.contasInvestimentoPf.get(0).getNumeroConta());

                ImprimeSaldoConta(banco1.contasCorrentePf.get(0).consultarSaldo(),
                                Banco.TipoDeConta.CONTA_CORRENTE,
                                banco1.contasCorrentePf.get(0).getNumeroConta());

                System.out.println("Sacando " + FormatacaoMonetaria(new BigDecimal(2525.00), ptbr)
                                + " da conta investimento n°3.");

                banco1.contasInvestimentoPf.get(0).sacar(new BigDecimal(2525.00));

                ImprimeSaldoConta(banco1.contasInvestimentoPf.get(0).consultarSaldo(),
                                Banco.TipoDeConta.CONTA_INVESTIMENTO,
                                banco1.contasInvestimentoPf.get(0).getNumeroConta());

                System.out.print(
                                "\n##################################### Lista de Clientes PJ ######################################\n\n");

                for (ClientePessoaJuridica cliente : banco1.clientesPj) {
                        System.out.println(cliente.toString());
                }

                System.out.print(
                                "\n################################## Lista de Contas Corrente PJ ##################################\n\n");

                for (ContaCorrentePj conta : banco1.contasCorrentePj) {
                        System.out.println(conta.toString());
                }

                System.out.print(
                                "\n################################ Lista de Contas Investimento PJ ################################\n\n");

                for (ContaInvestimentoPj conta : banco1.contasInvestimentoPj) {
                        System.out.println(conta.toString());
                }

                System.out.print(
                                "\n################################ Operações em Conta Corrente PJ #################################\n\n");

                banco1.contasCorrentePj.get(0).depositar(new BigDecimal(1000000.00));
                System.out.println(
                                "Depósito no valor de " + FormatacaoMonetaria(new BigDecimal(1000000.00), ptbr)
                                                + " realizado na conta corrente nº 5.");

                ImprimeSaldoConta(banco1.contasCorrentePj.get(0).consultarSaldo(), Banco.TipoDeConta.CONTA_CORRENTE,
                                banco1.contasCorrentePj.get(0).getNumeroConta());

                System.out.println("Transferindo " + FormatacaoMonetaria(new BigDecimal(250000.00), ptbr)
                                + " da conta corrente n°5 para a conta investimento nº 4.");

                banco1.contasCorrentePj.get(0).transferir(banco1.contasInvestimentoPj.get(0),
                                new BigDecimal(250000.00));

                ImprimeSaldoConta(banco1.contasCorrentePj.get(0).consultarSaldo(), Banco.TipoDeConta.CONTA_CORRENTE,
                                banco1.contasCorrentePj.get(0).getNumeroConta());

                ImprimeSaldoConta(banco1.contasInvestimentoPj.get(0).consultarSaldo(),
                                Banco.TipoDeConta.CONTA_INVESTIMENTO,
                                banco1.contasInvestimentoPj.get(0).getNumeroConta());

                System.out.println("Sacando " + FormatacaoMonetaria(new BigDecimal(100000.00), ptbr)
                                + " da conta corrente n°5.");

                banco1.contasCorrentePj.get(0).sacar(new BigDecimal(100000.00));

                ImprimeSaldoConta(banco1.contasCorrentePj.get(0).consultarSaldo(), Banco.TipoDeConta.CONTA_CORRENTE,
                                banco1.contasCorrentePj.get(0).getNumeroConta());

                System.out.print(
                                "\n############################## Operações em Conta Investimento PJ ###############################\n\n");

                banco1.contasInvestimentoPj.get(0).investir(new BigDecimal(5000000.00));

                System.out.println(
                                "Investimento no valor de " + FormatacaoMonetaria(new BigDecimal(5000000.00), ptbr)
                                                + " realizado na conta investimento nº 4.");

                ImprimeSaldoConta(banco1.contasInvestimentoPj.get(0).consultarSaldo(),
                                Banco.TipoDeConta.CONTA_INVESTIMENTO,
                                banco1.contasInvestimentoPj.get(0).getNumeroConta());

                System.out.println("Transferindo " + FormatacaoMonetaria(new BigDecimal(1800000.00), ptbr)
                                + " da conta investimento n°4 para a conta corrente nº 5.");

                banco1.contasInvestimentoPj.get(0).transferir(banco1.contasCorrentePj.get(0),
                                new BigDecimal(1800000.00));

                ImprimeSaldoConta(banco1.contasInvestimentoPj.get(0).consultarSaldo(),
                                Banco.TipoDeConta.CONTA_INVESTIMENTO,
                                banco1.contasInvestimentoPj.get(0).getNumeroConta());

                ImprimeSaldoConta(banco1.contasCorrentePj.get(0).consultarSaldo(),
                                Banco.TipoDeConta.CONTA_CORRENTE,
                                banco1.contasCorrentePj.get(0).getNumeroConta());

                System.out.println("Sacando " + FormatacaoMonetaria(new BigDecimal(2000000.00), ptbr)
                                + " da conta investimento n°4.");

                banco1.contasInvestimentoPj.get(0).sacar(new BigDecimal(2000000.00));

                ImprimeSaldoConta(banco1.contasInvestimentoPj.get(0).consultarSaldo(),
                                Banco.TipoDeConta.CONTA_INVESTIMENTO,
                                banco1.contasInvestimentoPj.get(0).getNumeroConta());

                System.out.print(
                                "\n############################################## END ##############################################\n");

        }

        private static String FormatacaoMonetaria(BigDecimal valor, Locale local) {
                return NumberFormat.getCurrencyInstance(local).format(valor);
        }

        public static void ImprimeSaldoConta(BigDecimal saldo, Banco.TipoDeConta tipoConta, int numeroConta) {

                switch (tipoConta) {
                        case CONTA_CORRENTE:
                                System.out.println("O saldo da conta corrente nº " + numeroConta + " é de: "
                                                + FormatacaoMonetaria(saldo, ptbr));
                                break;
                        case CONTA_POUPANCA:
                                System.out.println("O saldo da conta poupança nº " + numeroConta + " é de: "
                                                + FormatacaoMonetaria(saldo, ptbr));
                                break;
                        case CONTA_INVESTIMENTO:
                                System.out.println("O saldo da conta investimento nº " + numeroConta + " é de: "
                                                + FormatacaoMonetaria(saldo, ptbr));
                                break;
                }

        }
}
