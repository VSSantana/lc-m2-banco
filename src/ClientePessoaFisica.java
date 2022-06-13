import java.math.BigDecimal;
import java.time.LocalDate;

public class ClientePessoaFisica extends Cliente {

    private String cpf;
    private BigDecimal renda;
    private ContaCorrentePf contaCorrente;
    private ContaPoupancaPf contaPoupanca;
    private ContaInvestimentoPf contaInvestimento;

    public ClientePessoaFisica(String nome, String cpf, BigDecimal renda) {
        super.setNome(nome);
        this.cpf = cpf;
        this.renda = renda;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public void AbrirContaCorrente(Integer numeroConta, Integer numeroAgencia,
            LocalDate dataAbertura) {
        this.contaCorrente = new ContaCorrentePf(numeroConta, numeroAgencia,
                dataAbertura);
    }

    public ContaCorrentePf getContaCorrente() {
        return contaCorrente;
    }

    public void AbrirContaPoupança(Integer numeroConta, Integer numeroAgencia,
            LocalDate dataAbertura) {
        this.contaPoupanca = new ContaPoupancaPf(numeroConta, numeroAgencia,
                dataAbertura);
    }

    public ContaPoupancaPf getContaPoupanca() {
        return contaPoupanca;
    }

    public void AbrirContaInvestimento(Integer numeroConta,
            Integer numeroAgencia, LocalDate dataAbertura) {
        this.contaInvestimento = new ContaInvestimentoPf(numeroConta,
                numeroAgencia, dataAbertura);
    }

    public ContaInvestimentoPf getContaInvestimento() {
        return contaInvestimento;
    }

}
