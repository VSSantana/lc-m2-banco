import java.math.BigDecimal;

public interface OperacoesMovimentacacao {

    void sacar(BigDecimal valorSaque);

    void depositar(BigDecimal valorSaque);

    void transferir(Conta contaDestino, BigDecimal valorSaque);

}
