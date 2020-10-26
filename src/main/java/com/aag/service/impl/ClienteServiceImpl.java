package com.aag.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aag.model.Cliente;
import com.aag.repo.IClienteRepo;
import com.aag.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepo repo;
	
	@Override
	public List<Cliente> listar() {
		return repo.findAll();
	}

	@Override
	public Cliente leerPorId(Integer id) {
		Optional<Cliente> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Cliente();
	}

	@Override
	public Cliente modificar(@Valid Cliente cliente) {
		return repo.save(cliente);
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Cliente registrar(@Valid Cliente cliente) {
		return repo.save(cliente);
	}

}
