package br.com.aula10.dao;

import java.util.List;

import javax.swing.JOptionPane;

import java.awt.Container;
import java.util.ArrayList;

import br.com.aula10.beans.Licenciamento;
import br.com.aula10.beans.Veiculos;

public class VeiculoDao {

	List<Veiculos> bancoVeiculos = new ArrayList<Veiculos>();

	public void incluir(Veiculos v) {

		try {
			if (v.getLicenciamento().getAno() > 2021) {
				System.out.println("Ano do Veiculo Invalido, Tente novamente");
			} else {
				bancoVeiculos.add(v);

			}
		} catch (Exception e) {
			System.out.println("Erro em salvar Veiculo" + e.getMessage());
		}
	}

	public void alterar(String placa) {

		Veiculos veiculos = new Veiculos();
		Licenciamento licenciamento = new Licenciamento();
		try {
			veiculos = consulta(placa);
			if (veiculos.getPlaca().equalsIgnoreCase(placa)) {
				delete(veiculos);

				veiculos.setPlaca(String.format(JOptionPane.showInputDialog(null, " Digite Nova Placa do Veiculo")));
				veiculos.setModelo(String.format(JOptionPane.showInputDialog(null, " Digite Modelo Veiculo")));
				veiculos.setPotencia(
						Integer.parseInt(JOptionPane.showInputDialog(null, " Digite Pontecia do Veiculo")));

				licenciamento.setAno(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite ano do veiculo")));
				licenciamento.setValorLicenciamento(
						Float.parseFloat(JOptionPane.showInputDialog(null, "Digite valor doLicenciamento")));
				licenciamento.setControladorLicenciamento(0);

				veiculos.setLicenciamento(licenciamento);

				incluir(veiculos);
				System.out.println("Dados alterados");
			}
		} catch (Exception e) {
			System.out.println("Erro em alterar dados do veiculos");
		}

	}

	public Veiculos consulta(String placa) {

		for (Veiculos consuta : bancoVeiculos) {
			if (consuta.getPlaca().equalsIgnoreCase(placa)) {
				return consuta;

			}
		}

		return null;

	}

	public void delete(Veiculos veiculos) throws Exception {

		bancoVeiculos.remove(veiculos);

	}

	public void listaTodos() {

		for (Veiculos consultar : bancoVeiculos) {

			System.out.println("Placa: " + consultar.getPlaca() + "Modelo: " + consultar.getModelo() + "Pontencia: "
					+ consultar.getPotencia() + " Veicula Licenciado: "
					+ consultar.getLicenciamento().getControladorLicenciamento());

		}
	}

	public void registrar(String placa) {
		Veiculos veicTO = new Veiculos();

		try {

			boolean licenciamento = consultaValorPagoLicencianemto(placa);
			boolean veiculoJaLicenciado = consultaVeiculoJaFoiLicenciado(placa);
			System.out.println("ConsultaValorPagoLicenciamento é =" + licenciamento);
			System.out.println("consultaVeiculoJafoiLicenciado é = " + veiculoJaLicenciado);
			

			if (veiculoJaLicenciado == false) {

				for (Veiculos cont : bancoVeiculos) {

					if (licenciamento == true && cont.getPlaca().equalsIgnoreCase(placa)) {
						System.out.println("Fazer Atualização do Licenciamento para 2021");

						int ano = cont.getLicenciamento().getAno() - 1;
						float taxaLicenciamento = (float) (ano * 0.5);
						cont.getLicenciamento().setValorLicenciamento(taxaLicenciamento);
						System.out.println("Nova taxa: " + cont.getLicenciamento().getValorLicenciamento());
						cont.getLicenciamento().setControladorLicenciamento(1);
					}
				}

				for (Veiculos cont : bancoVeiculos) {
					if (licenciamento == false && cont.getPlaca().equalsIgnoreCase(placa)) {// Nova Licenciamento

						int contLicenciamento = Integer.parseInt(JOptionPane.showInputDialog(null,
								"Veiculo não possui Licenciamento: \n 1 - Para Licenciar 2 - Para Sair "));

						if (contLicenciamento == 1) {

							int ano = cont.getLicenciamento().getAno();
							float taxaLicenciamento = (float) (ano * 0.7);
							cont.getLicenciamento().setValorLicenciamento(taxaLicenciamento);
							System.out
									.println("Taxa Licenciamento: " + cont.getLicenciamento().getValorLicenciamento());
							cont.getLicenciamento().setControladorLicenciamento(1);

						}

						else if (contLicenciamento == 2) {
							System.out.println("Veiculo sem documentação");
						}
					}
				}
			} else if (veiculoJaLicenciado == true) {
				System.out.println("Ja Existem um Licenciamento desse Veiculo no Sistema");
			}

		} catch (NullPointerException e) {
			System.out.println("Veiculo Não encontrado" + e.getMessage());
		} catch (NumberFormatException e1) {
			System.out.println("Valor digitado campo texto invalido" + e1.getMessage());
		}

	}

	public ArrayList<Veiculos> retornaList(String placa) {
		ArrayList<Veiculos> novaLista = new ArrayList<Veiculos>();

		for (Veiculos cont : bancoVeiculos) {

			Veiculos addLista = new Veiculos();

			addLista.setPlaca(cont.getPlaca());
			addLista.setPotencia(cont.getPotencia());
			addLista.setModelo(cont.getModelo());
			addLista.getLicenciamento().setAno(cont.getLicenciamento().getAno());
			addLista.getLicenciamento().setValorLicenciamento(cont.getLicenciamento().getValorLicenciamento());
			addLista.getLicenciamento()
					.setControladorLicenciamento(cont.getLicenciamento().getControladorLicenciamento());

			novaLista.add(addLista);

			return novaLista;

		}

		return null;

	}

	public boolean consultaValorPagoLicencianemto(String placa) {
		Veiculos veicTO = new Veiculos();

		veicTO = consulta(placa);

		if (veicTO.getLicenciamento().getValorLicenciamento() > 0) {
			return true;
		}

		return false;
	}

	public boolean consultaVeiculoJaFoiLicenciado(String placa) {
		Veiculos veicTO = new Veiculos();

		veicTO = consulta(placa);

		if (veicTO.getLicenciamento().getControladorLicenciamento() == 0) {
			return false;
		} else {
			return true;
		}
	}
}
