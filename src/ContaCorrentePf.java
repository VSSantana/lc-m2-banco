public class ContaCorrentePf extends Conta {

    ClientePessoaFisica cliente;

    public ContaCorrentePf(Integer numeroConta, Integer numeroAgencia, ClientePessoaFisica cliente) {
        super(numeroConta, numeroAgencia);
        this.cliente = cliente;
    }

}
