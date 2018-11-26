package br.edu.utfpr;

public class CalculaPrata implements CalculaConta {
	public double calculaContaComDesconto(Conta umaConta) {
		if(umaConta.getValor()>500)
			return umaConta.getValor() * 0.85;
		return umaConta.getValor() * 0.90;
	}
}