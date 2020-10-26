package com.aag.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aag.model.Vendedor;
import com.aag.repo.IVendedorRepo;
import com.aag.service.IVendedorService;

@Service
public class VendedorServiceImpl implements IVendedorService{

	@Autowired
	private IVendedorRepo repo;

	@Override
	public List<Vendedor> listar() {
		return repo.findAll();
	}

	@Override
	public Vendedor leerPorId(Integer id) {
		Optional<Vendedor> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Vendedor();
	}

	@Override
	public Vendedor modificar(@Valid Vendedor vendedor) {
		return repo.save(vendedor);
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Vendedor registrar(@Valid Vendedor vendedor) {
		return repo.save(vendedor);
	}
}
