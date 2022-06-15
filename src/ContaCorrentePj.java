import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaCorrentePj extends Conta {

    ClientePessoaJuridica cliente;
    private BigDecimal porcentagemTaxaMovimentacao = new BigDecimal(0.05);

    public BigDecimal getPorcentagemTaxaMovimentacao() {
        return porcentagemTaxaMovimentacao;
    }

    public ContaCorrentePj(Integer numeroConta, Integer numeroAgencia, ClientePessoaJuridica cliente) {
        super(numeroConta, numeroAgencia);
        this.cliente = cliente;
    }

    private BigDecimal CalculoTaxaMovimentacao(BigDecimal valor) {

        BigDecimal valorTaxa = valor.multiply(this.porcentagemTaxaMovimentacao);

        return valorTaxa.setScale(2, RoundingMode.HALF_UP);

    }

    @Override
    public void sacar(BigDecimal valorSaque) {

        if (valorSaque.compareTo(new BigDecimal(0)) != -1)
            valorSaque = valorSaque.add(CalculoTaxaMovimentacao(valorSaque));

        if (super.saldo.compareTo(valorSaque) != -1
                && valorSaque.compareTo(new BigDecimal(0)) != -1)
            super.saldo = super.saldo.subtract(valorSaque);
    }

    @Override
    public void transferir(Conta contaDestino, BigDecimal valorTransferencia) {

        BigDecimal taxaTransferencia = CalculoTaxaMovimentacao(valorTransferencia);

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
    public String toString() {
        return "ContaCorrentePj [numeroConta="
                + super.getNumeroConta().toString() + ", numeroAgencia="
                + super.getNumeroAgencia().toString() + ", dataAbertura=" + super.getDataAbertura() + ", estaAtiva="
                + super.getEstaAtiva() + ", saldo=" + super.consultarSaldo() + ", dataEncerramento="
                + super.getDataEncerramento() + "]";
    }

}
