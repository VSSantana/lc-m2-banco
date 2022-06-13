import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaInvestimentoPf extends Conta implements OperacaoInvestimento {

    private BigDecimal valorInvestido;

    public ContaInvestimentoPf(Integer numeroConta, Integer numeroAgencia,
            LocalDate dataAbertura) {
        super(numeroConta, numeroAgencia, dataAbertura);
        this.valorInvestido = new BigDecimal(0);
    }

    @Override
    public void Investir(BigDecimal valorInvestido) {
        if (super.saldo.compareTo(valorInvestido) != -1
                && valorInvestido.compareTo(new BigDecimal(0)) != -1) {
            super.saldo.subtract(valorInvestido);
            this.valorInvestido.add(valorInvestido);
        }

    }

}
