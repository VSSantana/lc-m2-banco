import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaInvestimentoPj extends Conta implements OperacaoInvestimento {

    ClientePessoaJuridica cliente;
    private BigDecimal porcentagemTaxaMovimentacao = new BigDecimal(0.05);
    private BigDecimal porcentagemRendimento = new BigDecimal(0.02);

    public ContaInvestimentoPj(Integer numeroConta, Integer numeroAgencia, ClientePessoaJuridica cliente) {
        super(numeroConta, numeroAgencia);
        this.cliente = cliente;
    }

    private BigDecimal calculoTaxaMovimentacao(BigDecimal valor) {

        BigDecimal valorTaxa = valor.multiply(this.porcentagemTaxaMovimentacao);

        return valorTaxa.setScale(2, RoundingMode.HALF_UP);

    }

    @Override
    public void sacar(BigDecimal valorSaque) {

        if (valorSaque.compareTo(new BigDecimal(0)) != -1)
            valorSaque = valorSaque.add(calculoTaxaMovimentacao(valorSaque));

        if (super.saldo.compareTo(valorSaque) != -1
                && valorSaque.compareTo(new BigDecimal(0)) != -1)
            super.saldo = super.saldo.subtract(valorSaque);
    }

    @Override
    public void transferir(Conta contaDestino, BigDecimal valorTransferencia) {

        BigDecimal taxaTransferencia = calculoTaxaMovimentacao(valorTransferencia);

        if (valorTransferencia.compareTo(new BigDecimal(0)) != -1)
            valorTransferencia = valorTransferencia.add(taxaTransferencia);

        if (super.saldo.compareTo(valorTransferencia) != -1
                && valorTransferencia.compareTo(new BigDecimal(0)) != -1) {

            super.saldo = super.saldo.subtract(valorTransferencia);

            valorTransferencia = valorTransferencia.subtract(taxaTransferencia);

            if (contaDestino instanceof ContaInvestimentoPf) {
                ContaInvestimentoPf ci = (ContaInvestimentoPf) contaDestino;
                ci.investir(valorTransferencia);
            }

            else {

                if (contaDestino instanceof ContaInvestimentoPj) {
                    ContaInvestimentoPj ci = (ContaInvestimentoPj) contaDestino;
                    ci.investir(valorTransferencia);
                }

                else {
                    contaDestino.depositar(valorTransferencia);
                }

            }
        }

    }

    @Override
    public void investir(BigDecimal valorInvestido) {

        if (valorInvestido.compareTo(new BigDecimal(0)) != -1) {
            super.saldo = super.saldo.add(valorInvestido);
        }

    }

    @Override
    public void depositar(BigDecimal valorDeposito) {
        System.out.println(
                "Operação não permitida. Depósitos na conta de investimento devem ser realizados através da operação \'Investir\'.");
    }

    @Override
    public BigDecimal consultarSaldo() {
        BigDecimal saldo = super.saldo;
        BigDecimal rendimentos = saldo.multiply(porcentagemRendimento);
        saldo = saldo.add(rendimentos);

        return saldo;
    }

    @Override
    public String toString() {
        return "ContaInvestimentoPj [numeroConta="
                + super.getNumeroConta().toString() + ", numeroAgencia="
                + super.getNumeroAgencia().toString() + ", dataAbertura=" + super.getDataAbertura() + ", estaAtiva="
                + super.getEstaAtiva() + ", saldo=" + consultarSaldo() + ", dataEncerramento="
                + super.getDataEncerramento() + "]";
    }

}
