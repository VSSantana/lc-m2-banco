import java.math.BigDecimal;

public class ContaInvestimentoPf extends Conta implements OperacaoInvestimento {

    ClientePessoaFisica cliente;

    public ContaInvestimentoPf(Integer numeroConta, Integer numeroAgencia, ClientePessoaFisica cliente) {
        super(numeroConta, numeroAgencia);
        this.cliente = cliente;
    }

    @Override
    public void depositar(BigDecimal valorDeposito) {
        System.out.println(
                "Operação não permitida. Depósitos na conta de investimento devem ser realizados através da operação \'Investir\'.");
    }

    @Override
    public void investir(BigDecimal valorInvestido) {
        if (valorInvestido.compareTo(new BigDecimal(0)) != -1) {
            super.saldo = super.saldo.add(valorInvestido);
        }

    }

    @Override
    public String toString() {
        return "ContaInvestimentoPf [numeroConta="
                + super.getNumeroConta().toString() + ", numeroAgencia="
                + super.getNumeroAgencia().toString() + ", dataAbertura=" + super.getDataAbertura() + ", estaAtiva="
                + super.getEstaAtiva() + ", saldo=" + super.consultarSaldo() + ", dataEncerramento="
                + super.getDataEncerramento() + "]";
    }

}
