package br.edu.utfpr;

public class CalculaBronze implements CalculaConta {
	public double calculaContaComDesconto(Conta umaConta) {
		if(umaConta.getValor()>500)
			return umaConta.getValor() * 0.90;
		return umaConta.getValor() * 0.95;
	}
}