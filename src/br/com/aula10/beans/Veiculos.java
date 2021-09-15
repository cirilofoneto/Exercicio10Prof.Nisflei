package br.com.aula10.beans;

public class Veiculos {
	
		private Licenciamento licenciamento;
		private String placa; 
		private String modelo; 
		private int potencia; 
		
		
		
		
		public Veiculos() {
			
		}


		public Veiculos(Licenciamento licenciamento, String placa, String modelo, int potencia) {
			super();
			this.licenciamento = licenciamento;
			this.placa = placa;
			this.modelo = modelo;
			this.potencia = potencia;
		}


		public String getPlaca() {
			return placa;
		}


		public void setPlaca(String placa) {
			this.placa = placa;
		}


		public String getModelo() {
			return modelo;
		}


		public void setModelo(String modelo) {
			this.modelo = modelo;
		}


		public int getPotencia() {
			return potencia;
		}


		public void setPotencia(int potencia) {
			this.potencia = potencia;
		}





		public Licenciamento getLicenciamento() {
			return licenciamento;
		}





		public void setLicenciamento(Licenciamento licenciamento) {
			this.licenciamento = licenciamento;
		}
		
		
		
		
}
