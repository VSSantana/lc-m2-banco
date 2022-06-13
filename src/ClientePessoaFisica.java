import java.math.BigDecimal;
import java.time.LocalDate;

public class ClientePessoaFisica extends Cliente {

    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;
    private ContaInvestimento contaInvestimento;

    public ClientePessoaFisica(String nome, LocalDate dataNascimento,
            String cpf, String rg, String ufRg, BigDecimal renda) {
        super(nome, dataNascimento, cpf, rg, ufRg, renda);
    }

    public void AbrirContaCorrente(Integer numeroConta, Integer numeroAgencia,
            LocalDate dataAbertura) {
        this.contaCorrente = new ContaCorrente(numeroConta, numeroAgencia,
                dataAbertura);
    }

    public void AbrirContaPoupança(Integer numeroConta, Integer numeroAgencia,
            LocalDate dataAbertura) {
        this.contaPoupanca = new ContaPoupanca(numeroConta, numeroAgencia,
                dataAbertura);
    }

    public void AbrirContaInvestimento(Integer numeroConta,
            Integer numeroAgencia, LocalDate dataAbertura) {
        this.contaInvestimento = new ContaInvestimento(numeroConta,
                numeroAgencia, dataAbertura);
    }

}
