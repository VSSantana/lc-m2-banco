import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Conta {

    private Integer numeroConta;
    private Integer numeroAgencia;
    private LocalDate dataAbertura;
    private LocalDate dataEncerramento;
    private boolean estaAtiva;
    private BigDecimal saldo;

    public Conta(Integer numeroConta, Integer numeroAgencia,
            LocalDate dataAbertura) {
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.dataAbertura = dataAbertura;
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
        return this.saldo;
    }

}