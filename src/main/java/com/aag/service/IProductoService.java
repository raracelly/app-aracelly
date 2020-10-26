package com.aag.service;

import java.util.List;

import javax.validation.Valid;

import com.aag.model.Producto;

public interface IProductoService {

	List<Producto> listar();

	Producto leerPorId(Integer id);

	Producto modificar(@Valid Producto producto);

	void eliminar(Integer id);

	Producto registrar(@Valid Producto producto);

}
