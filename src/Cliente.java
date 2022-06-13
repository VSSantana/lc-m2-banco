import java.math.BigDecimal;
import java.time.LocalDate;

// Classe abstrata não pode ser instânciada.

public abstract class Cliente {

    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;
    private String UfRg;
    private BigDecimal renda;

    public Cliente(String nome, LocalDate dataNascimento, String cpf, String rg,
            String ufRg, BigDecimal renda) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.rg = rg;
        UfRg = ufRg;
        this.renda = renda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getUfRg() {
        return UfRg;
    }

    public void setUfRg(String ufRg) {
        UfRg = ufRg;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

}
