package com.aag.service;

import java.util.List;

import javax.validation.Valid;

import com.aag.model.Vendedor;

public interface IVendedorService {

	List<Vendedor> listar();

	Vendedor leerPorId(Integer id);

	Vendedor modificar(@Valid Vendedor vendedor);

	void eliminar(Integer id);

	Vendedor registrar(@Valid Vendedor vendedor);

}
