import java.time.LocalDate;

public class ContaPoupancaPf extends Conta {

    ClientePessoaFisica cliente;

    public ContaPoupancaPf(Integer numeroConta, Integer numeroAgencia,
            LocalDate dataAbertura) {
        super(numeroConta, numeroAgencia, dataAbertura);
    }

}
