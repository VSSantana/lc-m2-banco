import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Conta implements OperacoesMovimentacacao {

    private Integer numeroConta;
    private Integer numeroAgencia;
    private LocalDate dataAbertura;
    private LocalDate dataEncerramento;
    private boolean estaAtiva;
    protected BigDecimal saldo;

    public Conta(Integer numeroConta, Integer numeroAgencia) {
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.dataAbertura = LocalDate.now();
        this.estaAtiva = true;
        this.saldo = new BigDecimal(0);
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Integer getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(Integer numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDate dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public boolean getEstaAtiva() {
        return estaAtiva;
    }

    public void setEstaAtiva(boolean estaAtiva) {
        this.estaAtiva = estaAtiva;
    }

    public BigDecimal consultarSaldo() {
        return this.saldo.setScale(2);
    }

    @Override
    public void sacar(BigDecimal valorSaque) {
        if (this.saldo.compareTo(valorSaque) != -1
                && valorSaque.compareTo(new BigDecimal(0)) != -1)
            this.saldo = this.saldo.subtract(valorSaque);
    }

    @Override
    public void depositar(BigDecimal valorDeposito) {
        if (valorDeposito.compareTo(new BigDecimal(0)) != -1)
            this.saldo = this.saldo.add(valorDeposito);
    }

    @Override
    public void transferir(Conta contaDestino, BigDecimal valorTransferencia) { // Polimorfismo.
        if (this.saldo.compareTo(valorTransferencia) != -1
                && valorTransferencia.compareTo(new BigDecimal(0)) != -1) {
            this.saldo = this.saldo.subtract(valorTransferencia);

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

}