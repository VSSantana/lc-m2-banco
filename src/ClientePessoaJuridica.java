import java.math.BigDecimal;
import java.time.LocalDate;

public class ClientePessoaJuridica extends Cliente {

    private ContaCorrente contaCorrente;
    private ContaInvestimento contaInvestimento;

    public ClientePessoaJuridica(String nome, LocalDate dataNascimento,
            String cpf, String rg, String ufRg, BigDecimal renda) {
        super(nome, dataNascimento, cpf, rg, ufRg, renda);
    }

    public void AbrirContaCorrente(Integer numeroConta, Integer numeroAgencia,
            LocalDate dataAbertura) {
        this.contaCorrente = new ContaCorrente(numeroConta, numeroAgencia,
                dataAbertura);
    }

    public void AbrirContaInvestimento(Integer numeroConta,
            Integer numeroAgencia, LocalDate dataAbertura) {
        this.contaInvestimento = new ContaInvestimento(numeroConta,
                numeroAgencia, dataAbertura);
    }

}
