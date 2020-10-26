package com.aag.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aag.model.Producto;
import com.aag.repo.IProductoRepo;
import com.aag.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepo repo;

	@Override
	public List<Producto> listar() {
		return repo.findAll();
	}

	@Override
	public Producto leerPorId(Integer id) {
		Optional<Producto> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Producto();
	}

	@Override
	public Producto modificar(@Valid Producto producto) {
		return repo.save(producto);
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Producto registrar(@Valid Producto producto) {
		return repo.save(producto);
	}
}
