package br.scrumban;

public class Calculadora {

	public double calcularComissao(double valorVenda) {
		double resultado;
		if (valorVenda > 10000) {
			resultado = (valorVenda*0.06);
		} else {	
			resultado =  (valorVenda*0.05);
		}	
		
		resultado = Math.floor(resultado * 100) / 100;
		
		return resultado;
	}

}
