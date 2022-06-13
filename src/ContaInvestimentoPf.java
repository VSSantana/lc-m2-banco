import java.math.BigDecimal;
import java.time.LocalDate;

public class ContaInvestimentoPf extends Conta implements OperacaoInvestimento {

    ClientePessoaFisica cliente;

    public ContaInvestimentoPf(Integer numeroConta, Integer numeroAgencia,
            LocalDate dataAbertura) {
        super(numeroConta, numeroAgencia, dataAbertura);
    }

    @Override
    public void depositar(BigDecimal valorDeposito) {
        System.out.println(
                "Operação não permitida. Depósitos na conta de investimento devem ser realizados através da operação \'Investir\'.");
    }

    @Override
    public void investir(BigDecimal valorInvestido) {
        if (super.saldo.compareTo(valorInvestido) != -1
                && valorInvestido.compareTo(new BigDecimal(0)) != -1) {
            super.saldo = super.saldo.add(valorInvestido).setScale(2);
        }

    }

}
