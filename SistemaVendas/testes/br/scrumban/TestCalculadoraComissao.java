package br.scrumban;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class TestCalculadoraComissao {

	@Test
	public void testCalcularComissaoVendade100Espero5() {
		double valorVenda = 100;
		double esperado = 5;
		
		Calculadora calculadora = new Calculadora();
		double retorno = calculadora.calcularComissao(valorVenda);
		
		assertEquals(esperado, retorno, 0.0001);
		
	}
	
	@Test
	public void testCalcularComissaoVendade1000Espero50() {
		double valorVenda = 1000;
		double esperado = 50;
		
		Calculadora calculadora = new Calculadora();
		double retorno = calculadora.calcularComissao(valorVenda);
		
		assertEquals(esperado, retorno, 0.0001);
	}
		
	@Test
	public void testCalcularComissaoVendade10000Espero500() {
		double valorVenda = 10000;
		double esperado = 500;
		
		Calculadora calculadora = new Calculadora();
		double retorno = calculadora.calcularComissao(valorVenda);
		
		assertEquals(esperado, retorno, 0.0001);
	}

	@Test
	public void testCalcularComissaoVendade100000Espero6000() {
		double valorVenda = 100000;
		double esperado = 6000;
		
		Calculadora calculadora = new Calculadora();
		double retorno = calculadora.calcularComissao(valorVenda);
		
		assertEquals(esperado, retorno, 0.0001);
	}
	
	@Test
	public void testCalcularComissaoVendade55Reais59Espero2Reais77() {
		double valorVenda = 55.59;
		double esperado = 2.77;
		
		Calculadora calculadora = new Calculadora();
		double retorno = calculadora.calcularComissao(valorVenda);
		
		assertEquals(esperado, retorno, 0.0001);
	}
		
}
