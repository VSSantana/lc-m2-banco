import java.util.ArrayList;

public class Banco {

    private String nome;
    ArrayList<ClientePessoaFisica> clientesPf = new ArrayList<>();
    ArrayList<ClientePessoaJuridica> clientesPj = new ArrayList<>();
    ArrayList<ContaCorrentePf> contasCorrentePf = new ArrayList<>();
    ArrayList<ContaPoupancaPf> contasPoupancaPf = new ArrayList<>();
    ArrayList<ContaInvestimentoPf> contasInvestimentoPf = new ArrayList<>();
    ArrayList<ContaCorrentePj> contasCorrentePj = new ArrayList<>();
    ArrayList<ContaInvestimentoPj> contasInvestimentoPj = new ArrayList<>();

    enum TipoDeConta {
        CONTA_CORRENTE, CONTA_POUPANCA, CONTA_INVESTIMENTO
    }

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void abrirConta(Integer numeroConta, Integer numeroAgencia,
            Cliente cliente, TipoDeConta tipoDeConta) {
        if (cliente instanceof ClientePessoaFisica) {
            clientesPf.add((ClientePessoaFisica) cliente);
            switch (tipoDeConta) {
                case CONTA_CORRENTE:
                    contasCorrentePf.add(new ContaCorrentePf(numeroConta,
                            numeroAgencia, (ClientePessoaFisica) cliente));
                    break;
                case CONTA_POUPANCA:
                    contasPoupancaPf.add(new ContaPoupancaPf(numeroConta,
                            numeroAgencia, (ClientePessoaFisica) cliente));
                    break;
                case CONTA_INVESTIMENTO:
                    contasInvestimentoPf.add(new ContaInvestimentoPf(numeroConta,
                            numeroAgencia, (ClientePessoaFisica) cliente));
                    break;
            }
        } else {
            if (cliente instanceof ClientePessoaJuridica) {
                clientesPj.add((ClientePessoaJuridica) cliente);
                switch (tipoDeConta) {
                    case CONTA_CORRENTE:
                        contasCorrentePj.add(new ContaCorrentePj(numeroConta,
                                numeroAgencia, (ClientePessoaJuridica) cliente));
                        break;
                    case CONTA_POUPANCA:
                        System.out.println(
                                "Pessoa jurídica não pode abrir uma conta poupança.");
                        break;
                    case CONTA_INVESTIMENTO:
                        contasInvestimentoPj.add(
                                new ContaInvestimentoPj(numeroConta, numeroAgencia,
                                        (ClientePessoaJuridica) cliente));
                        break;
                }
            }
        }

    }

}
