import java.math.BigDecimal;

public interface OperacoesMovimentacacao {

    void Sacar(BigDecimal valorSaque);

    void Depositar(BigDecimal valorSaque);

    void Transferir(Conta contaDestino, BigDecimal valorSaque);

}
