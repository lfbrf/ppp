//Calulo de desconto no produto da loja por nivel de conta do cliente .
// USANDO O STRATEGY
package br.edu.utfpr;


public class Conta {
	protected String tipo;
	protected double valor;
	protected CalculaConta calculaConta;

	public Conta(String tipo, double valor) {
		this.valor = valor;
		if (tipo.equals("OURO")) {
			tipo = "OURO";
			calculaConta = new CalculaOuro();
		} else if (tipo.equals("PRATA")) {
			tipo = "PRATA";
			calculaConta = new CalculaPrata();
		} else if (tipo.equals("BRONZE")) {
			tipo = "OURO";
			calculaConta = new CalculaBronze();
		} else
			throw new RuntimeException("Conta não encontrada !!");
		

	}

	public double calculaContaComDesconto() {
		return calculaConta.calculaContaComDesconto(this);
	}

	public double getValor() {
		return valor;
	}
}
