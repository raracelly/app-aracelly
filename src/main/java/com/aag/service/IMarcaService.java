package com.aag.service;

import java.util.List;

import javax.validation.Valid;

import com.aag.model.Marca;

public interface IMarcaService {

	Marca registrar(@Valid Marca marca);

	void eliminar(Integer id);

	Marca leerPorId(Integer id);

	Marca modificar(@Valid Marca marca);

	List<Marca> listar();

}
