## Enunciado

Crie uma aplicação que simule uma app bancária. Os clientes podem ser pessoa física ou jurídica, sendo que para PJ existe a cobrança de uma taxa de 0.5% para cada saque ou transferência. Além do produto conta-corrente, os clientes PF podem abrir uma conta-poupança e conta-investimento. Clientes PJ não abrem poupança, mas seus rendimentos em conta-investimento rendem 2% a mais.

Crie as funcionalidades: abrir conta, sacar, depositar, transferência, investir, consultar saldo.

Use a classe "Aplicacao" para criar seu método "main" e demonstrar o funcionamento do seu código.

O projeto pode ser entregue via arquivo zip para o e-mail do professor ou via link de repositório Github.


## Classes

* Clientes:

    - Pessoa Física (PF)
    - Pessoa Jurídica (PJ)

* Conta:

    - Conta Corrente (CC)
    - Conta Poupança (CP)
    - Conta Investimento (CI)


## Métodos

* Abrir conta 
* Sacar 
* Depositar 
* Transferência  
* Investir 
* Consultar saldo


# Regras de negócio

* Conta PJ é cobrada taxa de 0.5% sobre o valor de cada saque ou transferência.
* Conta Poupança é exlusiva de pessoa física (PF).
* Conta Investimento de PJ rende 2% a mais.