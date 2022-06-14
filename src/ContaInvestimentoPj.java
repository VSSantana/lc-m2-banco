import java.math.BigDecimal;

public class ContaInvestimentoPj extends Conta implements OperacaoInvestimento {

    ClientePessoaJuridica cliente;
    private BigDecimal porcentagemTaxaMovimentacao = new BigDecimal(0.05)
            .setScale(2);
    private BigDecimal porcentagemRendimento = new BigDecimal(0.02)
            .setScale(2);

    public ContaInvestimentoPj(Integer numeroConta, Integer numeroAgencia, ClientePessoaJuridica cliente) {
        super(numeroConta, numeroAgencia);
        this.cliente = cliente;
    }

    private BigDecimal calculoTaxaMovimentacao(BigDecimal valor) {

        BigDecimal valorTaxa = valor.multiply(this.porcentagemTaxaMovimentacao)
                .setScale(2);

        return valorTaxa;

    }

    @Override
    public void sacar(BigDecimal valorSaque) {

        if (valorSaque.compareTo(new BigDecimal(0)) != -1)
            valorSaque = valorSaque.add(calculoTaxaMovimentacao(valorSaque)).setScale(2);

        if (super.saldo.compareTo(valorSaque) != -1
                && valorSaque.compareTo(new BigDecimal(0)) != -1)
            super.saldo = super.saldo.subtract(valorSaque).setScale(2);
    }

    @Override
    public void transferir(Conta contaDestino, BigDecimal valorTransferencia) {

        if (valorTransferencia.compareTo(new BigDecimal(0)) != -1)
            valorTransferencia = valorTransferencia.add(calculoTaxaMovimentacao(valorTransferencia)).setScale(2);

        if (super.saldo.compareTo(valorTransferencia) != -1
                && valorTransferencia.compareTo(new BigDecimal(0)) != -1) {
            super.saldo = super.saldo.subtract(valorTransferencia).setScale(2);
            contaDestino.depositar(valorTransferencia);
        }
    }

    @Override
    public void investir(BigDecimal valorInvestido) {

        if (super.saldo.compareTo(valorInvestido) != -1
                && valorInvestido.compareTo(new BigDecimal(0)) != -1) {
            super.saldo = super.saldo.add(valorInvestido).setScale(2);
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
        BigDecimal rendimentos = saldo.multiply(porcentagemRendimento).setScale(2);
        saldo = saldo.add(rendimentos).setScale(2);

        return saldo.setScale(2);
    }

}
