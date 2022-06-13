import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Conta implements OperacoesMovimentacacao {

    private Integer numeroConta;
    private Integer numeroAgencia;
    private LocalDate dataAbertura;
    private LocalDate dataEncerramento;
    private boolean estaAtiva;
    protected BigDecimal saldo;

    public Conta(Integer numeroConta, Integer numeroAgencia,
            LocalDate dataAbertura) {
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.dataAbertura = dataAbertura;
        this.estaAtiva = true;
        this.saldo = new BigDecimal(0).setScale(2);
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

    public boolean isEstaAtiva() {
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
            this.saldo = this.saldo.subtract(valorSaque).setScale(2);
    }

    @Override
    public void depositar(BigDecimal valorDeposito) {
        if (valorDeposito.compareTo(new BigDecimal(0)) != -1)
            this.saldo = this.saldo.add(valorDeposito).setScale(2);
    }

    @Override
    public void transferir(Conta contaDestino, BigDecimal valorTransferencia) {
        if (this.saldo.compareTo(valorTransferencia) != -1
                && valorTransferencia.compareTo(new BigDecimal(0)) != -1) {
            this.saldo = this.saldo.subtract(valorTransferencia).setScale(2);
            contaDestino.depositar(valorTransferencia);
        }
    }

}