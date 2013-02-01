package br.scrumban;

import java.util.List;

import br.scrumban.dao.VendaRepository;
import br.scrumban.modelo.Venda;

public class CalculadoraRoyalties {

	private VendaRepository vendaRepository;
	private Calculadora calculadora;
	
	public CalculadoraRoyalties(VendaRepository vendaRepositoryMock, Calculadora calculadoraMock) {
		this.vendaRepository = vendaRepositoryMock;
		this.calculadora = calculadoraMock;
	}

	public double calcula(int ano, int mes) {
		
		List<Venda> listaVendas = vendaRepository.obterVendasPorMesEAno(ano, mes);
		
		
		double valorLiquido = 0;
		
		for(Venda v: listaVendas){
			double comissao = calculadora.calcularComissao(v.getValor());
			valorLiquido += ( v.getValor() - comissao);
		  
		}
		
		return valorLiquido * 0.2;
	}

}
