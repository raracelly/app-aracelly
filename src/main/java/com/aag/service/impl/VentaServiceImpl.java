package com.aag.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aag.model.Venta;
import com.aag.repo.IVentaRepo;
import com.aag.service.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService{

	@Autowired
	private IVentaRepo repo;

	@Override
	public List<Venta> listar() {
		return repo.findAll();
	}

	@Override
	public Venta leerPorId(Integer id) {
		Optional<Venta> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Venta();
	}

	@Override
	public Venta modificar(@Valid Venta venta) {
		return repo.save(venta);
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Venta registrar(@Valid Venta venta) {
		return repo.save(venta);
	}
}
