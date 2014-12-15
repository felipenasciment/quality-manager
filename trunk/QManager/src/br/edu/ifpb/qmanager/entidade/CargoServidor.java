package br.edu.ifpb.qmanager.entidade;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cargo_servidor")
public class CargoServidor {

	private int idCargoServidor;
	private String cargoServidor;
	
	public static final int CARGO_PROFESSOR = 1;
	public static final int CARGO_TECNICO_ADMINISTRATIVO = 2;

	@XmlElement
	public int getIdCargoServidor() {
		return idCargoServidor;
	}

	public void setIdCargoServidor(int idCargoServidor) {
		this.idCargoServidor = idCargoServidor;
	}

	@XmlElement
	public String getCargoServidor() {
		return cargoServidor;
	}

	public void setCargoServidor(String cargoServidor) {
		this.cargoServidor = cargoServidor;
	}

	@Override
	public String toString() {
		return "CargoServidor [idCargoServidor=" + idCargoServidor
				+ ", cargoServidor=" + cargoServidor + "]";
	}

}