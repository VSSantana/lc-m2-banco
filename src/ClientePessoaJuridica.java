import java.math.BigDecimal;

public class ClientePessoaJuridica extends Cliente {

    private String cnpj;
    private BigDecimal faturamentoMensal;

    public ClientePessoaJuridica(String nome, String cnpj,
            BigDecimal faturamentoMensal) {
        super.setNome(nome);
        this.cnpj = cnpj;
        this.faturamentoMensal = faturamentoMensal;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public BigDecimal getFaturamentoMensal() {
        return faturamentoMensal;
    }

    public void setFaturamentoMensal(BigDecimal faturamentoMensal) {
        this.faturamentoMensal = faturamentoMensal;
    }

}
