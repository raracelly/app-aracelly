package com.aag.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aag.model.Marca;
import com.aag.repo.IMarcaRepo;
import com.aag.service.IMarcaService;

@Service
public class MarcaServiceImpl implements IMarcaService{

	@Autowired
	private IMarcaRepo repo;

	@Override
	public Marca registrar(@Valid Marca marca) {
		return repo.save(marca);
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Marca leerPorId(Integer id) {
		Optional<Marca> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Marca();
	}

	@Override
	public Marca modificar(@Valid Marca marca) {
		return repo.save(marca);
	}

	@Override
	public List<Marca> listar() {
		return repo.findAll();
	}
}
