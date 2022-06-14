public class ContaPoupancaPf extends Conta {

    ClientePessoaFisica cliente;

    public ContaPoupancaPf(Integer numeroConta, Integer numeroAgencia,
            ClientePessoaFisica cliente) {
        super(numeroConta, numeroAgencia);
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "ContaPoupancaPf [numeroConta="
                + super.getNumeroConta().toString() + ", numeroAgencia="
                + super.getNumeroAgencia().toString() + "]";
    }

}
