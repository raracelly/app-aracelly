package com.aag.service;

import java.util.List;

import javax.validation.Valid;

import com.aag.model.Venta;

public interface IVentaService {

	List<Venta> listar();

	Venta leerPorId(Integer id);

	Venta modificar(@Valid Venta venta);

	void eliminar(Integer id);

	Venta registrar(@Valid Venta venta);

}
