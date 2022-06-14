import java.util.ArrayList;

public class Banco {

    private String nome;
    ArrayList<ClientePessoaFisica> clientesPf = new ArrayList<>();
    ArrayList<ClientePessoaFisica> clientesPj = new ArrayList<>();
    ArrayList<ContaCorrentePf> contasCorrentePf = new ArrayList<>();
    ArrayList<ContaPoupancaPf> contasPoupancaPf = new ArrayList<>();
    ArrayList<ContaInvestimentoPf> contasInvestimentoPf = new ArrayList<>();
    ArrayList<ContaCorrentePj> contasCorrentePj = new ArrayList<>();
    ArrayList<ContaInvestimentoPj> contasInvestimentoPj = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void abrirConta(Integer numeroConta, Integer numeroAgencia, ClientePessoaFisica cliente) {

    }

}
