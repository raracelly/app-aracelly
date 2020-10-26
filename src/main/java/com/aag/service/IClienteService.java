package com.aag.service;

import java.util.List;

import javax.validation.Valid;

import com.aag.model.Cliente;

public interface IClienteService {

	List<Cliente> listar();

	Cliente leerPorId(Integer id);

	Cliente modificar(@Valid Cliente cliente);

	void eliminar(Integer id);

	Cliente registrar(@Valid Cliente cliente);

}
