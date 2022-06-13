import java.time.LocalDate;

public class ContaCorrentePf extends Conta {

    ClientePessoaFisica cliente;

    public ContaCorrentePf(Integer numeroConta, Integer numeroAgencia,
            LocalDate dataAbertura) {
        super(numeroConta, numeroAgencia, dataAbertura);
    }

}
