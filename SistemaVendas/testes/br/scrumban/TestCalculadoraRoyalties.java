package br.scrumban;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.scrumban.dao.VendaRepository;
import br.scrumban.modelo.Venda;


public class TestCalculadoraRoyalties {
	
	
	@Test
	public void testCalculaRoyaltiesDeUmaUnicaVendaDe100() {
		double valorVenda = 100;
		int mes = 12;
		int ano = 2012;
		int id = 1;
		int idVendedor = 1;
		double esperado = 19;
		
		Venda venda = new Venda(id, idVendedor, mes, ano, valorVenda);
		List<Venda> listaVenda = new ArrayList<Venda>();
		listaVenda.add(venda);
		
		VendaRepository vendaRepositoryMock = mock(VendaRepository.class);
		Calculadora calculadoraMock = mock(Calculadora.class);
		
		when(vendaRepositoryMock.obterVendasPorMesEAno(ano, mes)).thenReturn(listaVenda);
		when(calculadoraMock.calcularComissao(valorVenda)).thenReturn(5.0);
		
		CalculadoraRoyalties calculadoraRoyalties = new CalculadoraRoyalties(vendaRepositoryMock, calculadoraMock);
		
		double retorno =  calculadoraRoyalties.calcula(ano, mes);
		assertEquals(esperado, retorno, 0.001);
	} 
	
	@Test
	public void testCalculaRoyaltiesDeUmaUnicaVendaDe200() {

		
		double valorVenda = 200;
		int mes = 12;
		int ano = 2012;
		int id = 1;
		int idVendedor = 1;
		double esperado = 38;
		
		Venda venda = new Venda(id, idVendedor, mes, ano, valorVenda);
		List<Venda> listaVenda = new ArrayList<Venda>();
		listaVenda.add(venda);
		
		VendaRepository vendaRepositoryMock = mock(VendaRepository.class);
		Calculadora calculadoraMock = mock(Calculadora.class);
		
		when(vendaRepositoryMock.obterVendasPorMesEAno(ano, mes)).thenReturn(listaVenda);
		when(calculadoraMock.calcularComissao(valorVenda)).thenReturn(10.0);
		
		CalculadoraRoyalties calculadoraRoyalties = new CalculadoraRoyalties(vendaRepositoryMock, calculadoraMock);
		
		double retorno =  calculadoraRoyalties.calcula(ano, mes);
		assertEquals(esperado, retorno, 0.001);
	} 
	
	@Test
	public void testCalculaRoyaltiesDeDuasVendasNoMesmoMes() {
		
		double valorVenda = 50;
		double valorVenda2 = 350;
		int mes = 12;
		int ano = 2012;
		int id = 1;
		int idVendedor = 1;
		double esperado = 80;
		
		Venda venda = new Venda(id, idVendedor, mes, ano, valorVenda);
		Venda venda2 = new Venda(id, idVendedor, mes, ano, valorVenda2);
		List<Venda> listaVenda = new ArrayList<Venda>();
		listaVenda.add(venda);
		listaVenda.add(venda2);
		
		VendaRepository vendaRepositoryMock = mock(VendaRepository.class);
		Calculadora calculadoraMock = mock(Calculadora.class);
		
		when(vendaRepositoryMock.obterVendasPorMesEAno(ano, mes)).thenReturn(listaVenda);
		when(calculadoraMock.calcularComissao(valorVenda)).thenReturn(0.0);
		
		CalculadoraRoyalties calculadoraRoyalties = new CalculadoraRoyalties(vendaRepositoryMock, calculadoraMock);
		
		double retorno =  calculadoraRoyalties.calcula(ano, mes);
		assertEquals(esperado, retorno, 0.001);
		
		verify(calculadoraMock,times(1)).calcularComissao(valorVenda);
		
		verify(calculadoraMock,times(1)).calcularComissao(valorVenda2);
	} 
		
}
