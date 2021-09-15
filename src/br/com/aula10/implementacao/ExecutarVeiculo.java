package br.com.aula10.implementacao;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.aula10.beans.Licenciamento;
import br.com.aula10.beans.Veiculos;
import br.com.aula10.bo.VeiculoBo;
import br.com.aula10.dao.VeiculoDao;

public class ExecutarVeiculo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String placa;
		VeiculoBo vbo = new VeiculoBo();
		VeiculoDao veiculoDAO = new VeiculoDao();
		
		System.out.println("Tesye");

		int menu = 0;

		do {
		
			try {
			menu = Integer.parseInt(JOptionPane.showInputDialog(null,
					" 1 - Incluir \n 2 - Alterar \n 3 - Consultar \n 4 - Listar \n 5 - Deletar \n 6 - Consultar Licenciamento \n 0 - Sair"));
			}catch (NumberFormatException e) {
				System.out.println("Valor digitado no menu Invalido");
			}
			
			switch (menu) {
			case 1:
				Veiculos veiculosTO = new Veiculos();
				Licenciamento licenciamento = new Licenciamento();
				
				try {
				veiculosTO.setPlaca(String.format(JOptionPane.showInputDialog(null, "Digie a Placa")));
				veiculosTO.setModelo(String.format(JOptionPane.showInputDialog(null, "Digie o Modelo")));
				veiculosTO.setPotencia(Integer.parseInt(JOptionPane.showInputDialog(null, " Digite Pontencia")));
				licenciamento.setAno(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite ano do veiculo")));
				licenciamento.setValorLicenciamento(
						Float.parseFloat(JOptionPane.showInputDialog(null, "Digite valor doLicenciamento")));
				licenciamento.setControladorLicenciamento(0);
				}catch (NumberFormatException e) {
					System.out.println("Formulario Veiculo, campo digitado Incorreto");
				}
				veiculosTO.setLicenciamento(licenciamento);
				veiculoDAO.incluir(veiculosTO);

				break;
			case 2:
				
				 placa = String.format(JOptionPane.showInputDialog(null, "Digite a placa que deseja fazer a alteração"));
				veiculoDAO.alterar(placa);
				break;

			case 3: // Consutar
				Veiculos vconsulta = new Veiculos();

				try {
					placa = String.format(JOptionPane.showInputDialog(null, "Digite Placa para Consulta"));
					vconsulta = veiculoDAO.consulta(placa);
					System.out.println(
							"Placa: " + vconsulta.getPlaca() + " - Modelo: " + vconsulta.getModelo() + " - Potencia: "
									+ vconsulta.getPotencia() + " - Ano: " + vconsulta.getLicenciamento().getAno()
									+ " - ValorLicencimaneto: " + vconsulta.getLicenciamento().getValorLicenciamento());
				} catch (Exception e) {

					System.out.println("Veiculo não encontrado");
				}
				break;

			case 4:
				veiculoDAO.listaTodos();
				break;

			case 5:
				placa = String.format(JOptionPane.showInputDialog(null, "Digite Placa para Consulta"));
				vconsulta = veiculoDAO.consulta(placa);
				veiculoDAO.delete(vconsulta);
				break;
				
			case 6: // registro Licenciamento;
				
				placa = String.format(JOptionPane.showInputDialog(null, "Digite Placa para Consulta Licenciamento"));
				veiculoDAO.registrar(placa);
				
			

				
				
			default:
				break;
			}

		} while (menu != 0);

	}

}
