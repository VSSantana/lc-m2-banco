public class ContaCorrentePf extends Conta {

    ClientePessoaFisica cliente;

    public ContaCorrentePf(Integer numeroConta, Integer numeroAgencia,
            ClientePessoaFisica cliente) {
        super(numeroConta, numeroAgencia);
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "ContaCorrentePf [numeroConta="
                + super.getNumeroConta().toString() + ", numeroAgencia="
                + super.getNumeroAgencia().toString() + ", dataAbertura=" + super.getDataAbertura() + ", estaAtiva="
                + super.getEstaAtiva() + ", saldo=" + super.consultarSaldo() + ", dataEncerramento="
                + super.getDataEncerramento() + "]";
    }

}
