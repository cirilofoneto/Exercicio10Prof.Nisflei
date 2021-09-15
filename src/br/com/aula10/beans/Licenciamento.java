package br.com.aula10.beans;

public class Licenciamento {
	

	private int ano; 
	private float valorLicenciamento;
	private int controladorLicenciamento;
	
	
	
	
	
	
	
	public int getControladorLicenciamento() {
		return controladorLicenciamento;
	}





	public void setControladorLicenciamento(int controladorLicenciamento) {
		this.controladorLicenciamento = controladorLicenciamento;
	}





	public Licenciamento() {
		
	}
	
	
	


	public Licenciamento(int ano, float valorLicenciamento) {
		super();
	
		this.ano = ano;
		this.valorLicenciamento = valorLicenciamento;
	}





	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}


	public float getValorLicenciamento() {
		return valorLicenciamento;
	}


	public void setValorLicenciamento(float valorLicenciamento) {
		this.valorLicenciamento = valorLicenciamento;
	}
	
}
