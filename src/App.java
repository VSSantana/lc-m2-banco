import java.math.BigDecimal;

public class App {
    public static void main(String[] args) throws Exception {

        ClientePessoaFisica cliente = new ClientePessoaFisica("Vinicius", "03579526189",
                new BigDecimal(6000.00).setScale(2));
        Cliente c;

        ClientePessoaFisica cliente2;

        c = cliente;
        cliente2 = (ClientePessoaFisica) c;

        System.out.println(c.getNome());
        System.out.println(cliente2.getCpf());

    }
}
