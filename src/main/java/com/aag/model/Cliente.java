package com.aag.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	
	@Size(min = 3, message = "Nombres debe tener minimo 3 caracteres")
	@Column(name = "nombre",nullable = false, length = 70)
	private String nombreCliente;
	
	@Size(min = 3, message = "Direccion debe tener minimo 3 caracteres")
	@Column(name = "direccion",nullable = false, length = 70)
	private String direccionCliente;
	
	@Size(min = 9, max = 9, message = "Teléfono debe tener 9 digitos")
	@Column(name = "telefono",nullable = false, length = 9)
	private int telefonoCliente;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public int getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(int telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	
	
}
