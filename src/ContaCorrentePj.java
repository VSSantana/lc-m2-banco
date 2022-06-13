import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaCorrentePj extends Conta {

    private BigDecimal porcentagemTaxaMovimentacao = new BigDecimal(0.05)
            .setScale(2);

    public ContaCorrentePj(Integer numeroConta, Integer numeroAgencia,
            LocalDate dataAbertura) {
        super(numeroConta, numeroAgencia, dataAbertura);
    }

    private BigDecimal CalculoTaxaMovimentacao(BigDecimal valor) {

        BigDecimal valorTaxa = valor.multiply(this.porcentagemTaxaMovimentacao)
                .setScale(2);

        return valorTaxa;

    }

    @Override
    public void Sacar(BigDecimal valorSaque) {

        if (valorSaque.compareTo(new BigDecimal(0)) != -1)
            valorSaque.add(CalculoTaxaMovimentacao(valorSaque));

        if (this.saldo.compareTo(valorSaque) != -1
                && valorSaque.compareTo(new BigDecimal(0)) != -1)
            this.saldo.subtract(valorSaque);
    }

    @Override
    public void Transferir(Conta contaDestino, BigDecimal valorTransferencia) {

        if (valorTransferencia.compareTo(new BigDecimal(0)) != -1)
            valorTransferencia.add(CalculoTaxaMovimentacao(valorTransferencia));

        if (this.saldo.compareTo(valorTransferencia) != -1
                && valorTransferencia.compareTo(new BigDecimal(0)) != -1) {
            this.saldo.subtract(valorTransferencia);
            contaDestino.Depositar(valorTransferencia);
        }
    }

}
