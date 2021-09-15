package br.com.aula10.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.aula10.beans.Veiculos;
import br.com.aula10.dao.VeiculoDao;

public class VeiculoBo {

	VeiculoDao vdao = new VeiculoDao();
	Veiculos veiculos = new Veiculos();

	public void adcionar(Veiculos veiculos) {

		System.out.println(veiculos.getLicenciamento().getAno());

		if (veiculos.getLicenciamento().getAno() >= 2021) {
			System.out.println("Não é permitindo veiculos com > 2022");
		} else {
			vdao.incluir(veiculos);
			System.out.println("Veiculos Adcionado");
		}

	}
	
	public void listarTodos() {
		
		vdao.listaTodos();
		
	}

	
	
	public void licenciamento() {
		
		Veiculos vconsulta = new Veiculos();

		try {
			String placa = String.format(JOptionPane.showInputDialog(null, "Digite Placa para Consulta"));
			vconsulta = vdao.consulta(placa);
			System.out.println(
					"Placa: " + vconsulta.getPlaca() + " - Modelo: " + vconsulta.getModelo() + " - Potencia: "
							+ vconsulta.getPotencia() + " - Ano: " + vconsulta.getLicenciamento().getAno()
							+ " - ValorLicencimaneto: " + vconsulta.getLicenciamento().getValorLicenciamento());
		} catch (Exception e) {

			System.out.println("Veiculo não encontrado");
		}
		
		

	
		//Criar regra para não licencia mais de uma vez. 
		//Usando a lista que veio da classe veiculoDAO. 

	
	}
}

// Criar Regra de não deixar fazer mais de um licenciamento.
// Criar regra de não cadastrar veiculo.
// finalizar os Try Catch.
// finalizar alterar.
