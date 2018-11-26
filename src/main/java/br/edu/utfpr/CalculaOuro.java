package br.edu.utfpr;

public class CalculaOuro implements CalculaConta {
	public double calculaContaComDesconto(Conta umaConta) {
		if(umaConta.getValor()>500)
			return umaConta.getValor() * 0.80;
		return umaConta.getValor() * 0.85;
	}
}