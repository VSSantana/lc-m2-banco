import java.math.BigDecimal;

public class ContaCorrentePj extends Conta {

    ClientePessoaJuridica cliente;
    private BigDecimal porcentagemTaxaMovimentacao = new BigDecimal(0.05)
            .setScale(2);

    public ContaCorrentePj(Integer numeroConta, Integer numeroAgencia, ClientePessoaJuridica cliente) {
        super(numeroConta, numeroAgencia);
        this.cliente = cliente;
    }

    private BigDecimal CalculoTaxaMovimentacao(BigDecimal valor) {

        BigDecimal valorTaxa = valor.multiply(this.porcentagemTaxaMovimentacao)
                .setScale(2);

        return valorTaxa;

    }

    @Override
    public void sacar(BigDecimal valorSaque) {

        if (valorSaque.compareTo(new BigDecimal(0)) != -1)
            valorSaque = valorSaque.add(CalculoTaxaMovimentacao(valorSaque)).setScale(2);

        if (super.saldo.compareTo(valorSaque) != -1
                && valorSaque.compareTo(new BigDecimal(0)) != -1)
            super.saldo = super.saldo.subtract(valorSaque).setScale(2);
    }

    @Override
    public void transferir(Conta contaDestino, BigDecimal valorTransferencia) {

        if (valorTransferencia.compareTo(new BigDecimal(0)) != -1)
            valorTransferencia = valorTransferencia.add(CalculoTaxaMovimentacao(valorTransferencia)).setScale(2);

        if (super.saldo.compareTo(valorTransferencia) != -1
                && valorTransferencia.compareTo(new BigDecimal(0)) != -1) {
            super.saldo = super.saldo.subtract(valorTransferencia).setScale(2);
            contaDestino.depositar(valorTransferencia);
        }
    }

}
