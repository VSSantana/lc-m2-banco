import java.math.BigDecimal;

public class ClientePessoaFisica extends Cliente {

    private String cpf;
    private BigDecimal renda;

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

    @Override
    public String toString() {
        return "ClientePessoaFisica [nome=" + super.getNome() + ", cpf=" + cpf
                + ", renda=" + renda + "]";
    }

}
